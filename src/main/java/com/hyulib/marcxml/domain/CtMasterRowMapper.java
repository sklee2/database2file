package com.hyulib.marcxml.domain;

import org.springframework.jdbc.core.RowMapper;
import oracle.xdb.XMLType;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by HYU on 2016-02-15.
 */
public class CtMasterRowMapper implements RowMapper<CtMaster> {
    @Override
    public CtMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
        CtMaster ctMaster = new CtMaster();
        ctMaster.setControlNo(rs.getString("controlno"));

        XMLType poxml = (XMLType)rs.getObject("marc_data");
        ctMaster.setMarcXmlData(poxml.getStringVal());
        return ctMaster;
    }

}

