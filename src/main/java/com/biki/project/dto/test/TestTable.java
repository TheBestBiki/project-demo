package com.biki.project.dto.test;

import java.math.BigDecimal;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/10/30
 */
public class TestTable {

    private String id;
    private String test;
    private BigDecimal amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
