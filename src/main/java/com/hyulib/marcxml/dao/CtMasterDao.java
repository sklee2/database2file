package com.hyulib.marcxml.dao;

import com.hyulib.marcxml.domain.CtMaster;
import com.hyulib.marcxml.domain.CtMasterRowMapper;
import com.hyulib.userInfo.domain.UserInfo;
import com.hyulib.userInfo.domain.UserInfoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HYU on 2016-02-15.
 */
@Repository
public class CtMasterDao {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CtMaster findOneByControlNo(String controlNo){
        String query = "select controlno, marc_data " +
                "from ct_master " +
                "where controlno = :control_no" ;
        SqlParameterSource param = new MapSqlParameterSource().addValue("control_no", controlNo);
        Object o = namedParameterJdbcTemplate.queryForObject(query,param, new CtMasterRowMapper());
        return (CtMaster)o;
    }

    public List<CtMaster> findFromToByControlNo(String fromControlNo, String toControlNo){
        String query = "select controlno, marc_data " +
                "from ct_master " +
                "where controlno >= :from_control_no  and controlno <= :to_control_no " +
                "order by controlno" ;
        SqlParameterSource param = new MapSqlParameterSource().addValue("from_control_no", fromControlNo).addValue("to_control_no", toControlNo);
        return namedParameterJdbcTemplate.query(query,param, new CtMasterRowMapper());

    }
}
