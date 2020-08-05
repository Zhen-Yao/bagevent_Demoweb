package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Userloginlog {
    private String loginId;
    private Integer userId;
    private String loginTime;
    private String loginIp;

    @Id
    @Column(name = "login_id")
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login_time")
    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "login_ip")
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userloginlog that = (Userloginlog) o;
        return Objects.equals(loginId, that.loginId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(loginTime, that.loginTime) &&
                Objects.equals(loginIp, that.loginIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId, userId, loginTime, loginIp);
    }

    @Override
    public String toString() {
        return "Userloginlog{" +
                "loginId=" + loginId +
                ", userId=" + userId +
                ", loginTime=" + loginTime +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }
}
