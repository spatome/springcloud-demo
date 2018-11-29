package com.spatome.demo.core.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Prize {
    private Long id;

    private String prizeName;

    private BigDecimal prizeUnitAmount;

    private Integer prizeTotalCount;

    private Integer prizeBalanceCount;

    private String prizeStatus;

    private String descs;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    public BigDecimal getPrizeUnitAmount() {
        return prizeUnitAmount;
    }

    public void setPrizeUnitAmount(BigDecimal prizeUnitAmount) {
        this.prizeUnitAmount = prizeUnitAmount;
    }

    public Integer getPrizeTotalCount() {
        return prizeTotalCount;
    }

    public void setPrizeTotalCount(Integer prizeTotalCount) {
        this.prizeTotalCount = prizeTotalCount;
    }

    public Integer getPrizeBalanceCount() {
        return prizeBalanceCount;
    }

    public void setPrizeBalanceCount(Integer prizeBalanceCount) {
        this.prizeBalanceCount = prizeBalanceCount;
    }

    public String getPrizeStatus() {
        return prizeStatus;
    }

    public void setPrizeStatus(String prizeStatus) {
        this.prizeStatus = prizeStatus == null ? null : prizeStatus.trim();
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs == null ? null : descs.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}