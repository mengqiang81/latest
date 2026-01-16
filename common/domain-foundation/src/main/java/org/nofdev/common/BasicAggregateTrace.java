package org.nofdev.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 聚合根生命周期信息
 * 定义了一组业务单据生命周期中的极简共性，建议在主单上添加
 * 对于子实体，参考 {@link BasicEntityTrace}
 */
@Getter
@Setter
public class BasicAggregateTrace {
    /**
     * @see BasicCreatedTrace
     */
    private BasicCreatedTrace basicCreatedTrace;
    /**
     * @see BasicUpdatedTrace
     */
    private BasicUpdatedTrace basicUpdatedTrace;
    /**
     * @see BasicSubmittedTrace
     */
    private BasicSubmittedTrace basicSubmittedTrace;
    /**
     * @see BasicConfirmedTrace
     */
    private BasicConfirmedTrace basicConfirmedTrace;
    /**
     * @see BasicConcludedTrace
     */
    private BasicConcludedTrace basicConcludedTrace;
}
