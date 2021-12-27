package io.olen4ixxx.investing.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Client extends User{
    private Long clientId;
    private Timestamp registrationDate;
    private BigDecimal money;
}
