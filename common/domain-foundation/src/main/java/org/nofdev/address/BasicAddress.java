package org.nofdev.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.nofdev.core.ValueObject;
import java.util.Locale;
import static org.nofdev.address.AddressValidGroup.*;

/**
 * 地址
 *
 * @param countryCode        国家/地区代码（ISO 3166-1 alpha-2，如CN、US、JP）
 * @param administrativeArea 行政区域（省/州/郡，根据国家不同有不同含义）
 * @param city               城市/城镇
 * @param district           区/县/郊区
 * @param streetAddress      街道地址（包含街道名称、门牌号等详细信息）
 * @param postalCode         邮政编码（格式因国家而异）
 * @param extendedAddress    地址补充信息（如单元号、楼层等）
 * @param contactPerson      联系人
 * @param phoneNumber        联系电话
 */
public record BasicAddress(
        @NotBlank(message = "{address.countryCode.notBlank}")
        String countryCode,
        @NotBlank(groups = {CN.class, US.class, JP.class}, message = "{address.area.notBlank}")
        String administrativeArea,
        @NotBlank(groups = {CN.class, US.class, JP.class, DEFAULT.class}, message = "{address.city.notBlank}")
        String city,
        String district,
        String streetAddress,
        @NotBlank(groups = {CN.class, US.class, JP.class}, message = "{address.postalCode.notBlank}")
        @Pattern(regexp = "\\d{6}", groups = {CN.class}, message = "{address.postalCode.Illegal}")
        @Pattern(regexp = "\\d{5}(-\\d{4})?", groups = {US.class})
        @Pattern(regexp = "\\d{3}-\\d{4}", groups = {JP.class})
        String postalCode,
        String extendedAddress,
        String contactPerson,
        String phoneNumber
) implements ValueObject<BasicAddress> {
    /**
     * 根据所在国家/地区的格式规则，返回格式化的地址字符串
     */
    public String getFormattedAddress() {
        StringBuilder sb = new StringBuilder();

        // 不同国家/地区使用不同的地址格式
        switch (countryCode) {
            case "CN": // 中国地址格式：国家 省 市 区 街道地址 补充信息 邮编
                appendIfPresent(sb, getCountryName(), " ");
                appendIfPresent(sb, administrativeArea, " ");
                appendIfPresent(sb, city, " ");
                appendIfPresent(sb, district, " ");
                appendIfPresent(sb, streetAddress, " ");
                appendIfPresent(sb, extendedAddress, " ");
                appendIfPresent(sb, "(" + postalCode + ")", "");
                break;
            case "US": // 美国地址格式：街道地址 补充信息 城市, 州 邮编 国家
                appendIfPresent(sb, streetAddress, "\n");
                appendIfPresent(sb, extendedAddress, "\n");
                appendIfPresent(sb, city, ", ");
                appendIfPresent(sb, administrativeArea, " ");
                appendIfPresent(sb, postalCode, "\n");
                appendIfPresent(sb, getCountryName(), "");
                break;
            case "JP": // 日本地址格式：国家 都道府县 市町村 街道地址 补充信息 邮编
                appendIfPresent(sb, getCountryName(), " ");
                appendIfPresent(sb, administrativeArea, " ");
                appendIfPresent(sb, city, " ");
                appendIfPresent(sb, streetAddress, " ");
                appendIfPresent(sb, extendedAddress, " ");
                appendIfPresent(sb, "〒" + postalCode, "");
                break;
            default: // 默认格式（国际通用）
                appendIfPresent(sb, streetAddress, "\n");
                appendIfPresent(sb, extendedAddress, "\n");
                appendIfPresent(sb, city, " ");
                appendIfPresent(sb, administrativeArea, " ");
                appendIfPresent(sb, postalCode, "\n");
                appendIfPresent(sb, getCountryName(), "");
        }

        return sb.toString().trim();
    }

    /**
     * 获取国家/地区的本地化名称
     */
    public String getCountryName() {
        return Locale.of("", countryCode).getDisplayCountry();
    }

    /**
     * 获取国家/地区的本地化名称（指定语言）
     */
    public String getCountryName(Locale locale) {
        return Locale.of("", countryCode).getDisplayCountry(locale);
    }

    // 辅助方法：如果值不为空则添加到字符串构建器
    private void appendIfPresent(StringBuilder sb, String value, String separator) {
        if (value != null && !value.trim().isEmpty()) {
            if (!sb.isEmpty()) {
                sb.append(separator);
            }
            sb.append(value.trim());
        }
    }
}
