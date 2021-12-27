package io.olen4ixxx.investing.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order extends InvestingEntity {
    private Long orderId;
    private Long tutorId;
    private Long courseId;
    private Long clientId;
    private Timestamp orderDate;
    private BigDecimal orderPrice;
}
