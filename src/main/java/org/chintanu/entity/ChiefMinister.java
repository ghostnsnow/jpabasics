package org.chintanu.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CHIEF_MINISTERS")
public class ChiefMinister {

    @Id
    @Column(name = "CM_ID")
    @GeneratedValue
    private int cmId;
    @Column(name = "CM_NAME")
    private String cmName;
    @Temporal(TemporalType.DATE)
    @Column(name = "CM_TENURE_START_TIME")
    private LocalDate tenureStart;
    @Column(name = "CM_TENURE_END_TIME")
    @Temporal(TemporalType.DATE)
    private LocalDate tenureEnd;

    public ChiefMinister() {
    }

    public ChiefMinister(String cmName, LocalDate tenureStart, LocalDate tenureEnd) {
        this.cmName = cmName;
        this.tenureStart = tenureStart;
        this.tenureEnd = tenureEnd;
    }

    public int getCmId() {
        return cmId;
    }

    public void setCmId(int cmId) {
        this.cmId = cmId;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public LocalDate getTenureStart() {
        return tenureStart;
    }

    public void setTenureStart(LocalDate tenureStart) {
        this.tenureStart = tenureStart;
    }

    public LocalDate getTenureEnd() {
        return tenureEnd;
    }

    public void setTenureEnd(LocalDate tenureEnd) {
        this.tenureEnd = tenureEnd;
    }

    @Override
    public String toString() {
        return "ChiefMinister{" +
                "cmId=" + cmId +
                ", cmName='" + cmName + '\'' +
                ", tenureStart=" + tenureStart +
                ", tenureEnd=" + tenureEnd +
                '}';
    }
}
