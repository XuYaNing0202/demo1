package com.example.demo.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TbDataManagement {

    private long id;
    private String planName;
    private long planNumber;
    @JsonFormat
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private Integer whetherReport;


    @Override
    public String toString() {
        return "TbDataManagement{" +
                "id=" + id +
                ", planName='" + planName + '\'' +
                ", planNumber=" + planNumber +
                ", createtime=" + createtime +
                ", whetherReport=" + whetherReport +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public long getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(long planNumber) {
        this.planNumber = planNumber;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getWhetherReport() {
        return whetherReport;
    }

    public void setWhetherReport(Integer whetherReport) {
        this.whetherReport = whetherReport;
    }
}
