package com.hyulib.marcxml.domain;

/**
 * Created by HYU on 2016-02-15.
 */
public class CtMaster {
    private String controlNo;
    private String marcXmlData;

    public String getControlNo() {
        return controlNo;
    }

    public void setControlNo(String controlNo) {
        this.controlNo = controlNo;
    }

    public String getMarcXmlData() {
        return marcXmlData;
    }

    public void setMarcXmlData(String marcXmlData) {
        this.marcXmlData = marcXmlData;
    }

    @Override
    public String toString() {
        return "CtMaster{" +
                "controlNo='" + controlNo + '\'' +
                ", marcXmlData='" + marcXmlData + '\'' +
                '}';
    }
}
