package com.dbgenerate.api.bo;

/**
 * Created by LiuDongguang on 2017/7/7.
 */
public class LdgTableInfo {
    private String COLUMN_NAME;
    private String REMARKS;
    private String TYPE_NAME;

    public String getCOLUMN_NAME() {
        return COLUMN_NAME;
    }

    public void setCOLUMN_NAME(String COLUMN_NAME) {
        this.COLUMN_NAME = COLUMN_NAME;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS;
    }

    public String getTYPE_NAME() {
        return TYPE_NAME;
    }

    public void setTYPE_NAME(String TYPE_NAME) {
        this.TYPE_NAME = TYPE_NAME;
    }

    @Override
    public String toString() {
        return "LdgTableInfo{" +
                "COLUMN_NAME='" + COLUMN_NAME + '\'' +
                ", REMARKS='" + REMARKS + '\'' +
                ", TYPE_NAME='" + TYPE_NAME + '\'' +
                '}';
    }
}
