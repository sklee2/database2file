package com.hyulib.userInfo.domain;

/**
 * Created by sklee on 2016. 1. 11..
 */
public class UserInfo {
    private String userId;
    private String userName;
    private String userPosition;
    private String company;
    private String department;
    private String status;
    private String loanCheck;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoanCheck() {
        return loanCheck;
    }

    public void setLoanCheck(String loanCheck) {
        this.loanCheck = loanCheck;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPosition='" + userPosition + '\'' +
                ", company='" + company + '\'' +
                ", department='" + department + '\'' +
                ", status='" + status + '\'' +
                ", loanCheck='" + loanCheck + '\'' +
                '}';
    }
}
