package com.hyulib.marcxml.service;

import com.hyulib.marcxml.dao.CtMasterDao;
import com.hyulib.marcxml.domain.CtMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HYU on 2016-02-15.
 */
@Service
public class CtMasterService {
    @Autowired
    CtMasterDao ctMasterDao;

    public CtMaster getCtMaster(String controlNo){
        return ctMasterDao.findOneByControlNo(controlNo);
    }

    public List<CtMaster> getFromToCtMaster(String fromControlNo, String toControlNo){
        return ctMasterDao.findFromToByControlNo(fromControlNo,toControlNo);
    }
}
