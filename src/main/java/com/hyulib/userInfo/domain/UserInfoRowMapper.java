package com.hyulib.userInfo.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sklee on 2016. 2. 8..
 */
public class UserInfoRowMapper implements RowMapper<UserInfo> {
@Override
public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(rs.getString("user_id"));
        userInfo.setUserName(rs.getString("user_name"));
        userInfo.setUserPosition(rs.getString("user_position"));
        userInfo.setCompany(rs.getString("company"));
        userInfo.setDepartment(rs.getString("department"));
        userInfo.setStatus(rs.getString("status"));
        userInfo.setLoanCheck(rs.getString("loan_check"));
        return userInfo;
        }

}
