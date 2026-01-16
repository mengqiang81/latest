package org.nofdev.sales;

import java.util.List;

public record OrderDTO(String id, List<OderDetailDTO> orderDetails) {
    /**
     * 用紧凑构造函数保障 list 成员变量的不可变性
     *
     * @param id
     * @param orderDetails
     */
    public OrderDTO {
        orderDetails = List.copyOf(orderDetails);
    }
}
