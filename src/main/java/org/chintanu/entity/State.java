package org.chintanu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class State {

    @Column(name = "STATE_CODE")
    private int stateCode;

    @Column(name = "STATE_NAME")
    private String stateNm;

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateNm() {
        return stateNm;
    }

    public void setStateNm(String stateNm) {
        this.stateNm = stateNm;
    }

    public State() {
    }

    public State(int stateCode, String stateNm) {
        this.stateCode = stateCode;
        this.stateNm = stateNm;
    }
}
