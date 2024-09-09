package org.chintanu.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PRIME_MINISTERS")
public class PrimeMinister {

    @Id
    @Column(name = "PM_ID")
    @GeneratedValue
    private int pmId;
    @Column(name = "PM_NAME")
    private String pmName;
    @Temporal(TemporalType.DATE)
    @Column(name = "PM_TENURE_START_TIME")
    private LocalDate tenureStart;
    @Column(name = "PM_TENURE_END_TIME")
    @Temporal(TemporalType.DATE)
    private LocalDate tenureEnd;

    public PrimeMinister() {
    }

    public PrimeMinister(String pmName, LocalDate tenureStart, LocalDate tenureEnd) {
        this.pmName = pmName;
        this.tenureStart = tenureStart;
        this.tenureEnd = tenureEnd;
    }

    public int getPmId() {
        return pmId;
    }

    public void setPmId(int pmId) {
        this.pmId = pmId;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
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
        return "PrimeMinister{" +
                "pmId=" + pmId +
                ", pmName='" + pmName + '\'' +
                ", tenureStart=" + tenureStart +
                ", tenureEnd=" + tenureEnd +
                '}';
    }
}
