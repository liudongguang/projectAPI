package com.dbgenerate.api.bo;

/**
 * Created by LiuDongguang on 2017/7/7.
 */
public class LdgTable {
    private String TABLE_CAT;//表类别
    private String TABLE_SCHEM;//表模式
    private String TABLE_NAME;//表名称
    private String TABLE_TYPE;//表类型
    private String REMARKS;//表注释

    public String getTABLE_CAT() {
        return TABLE_CAT;
    }

    public void setTABLE_CAT(String TABLE_CAT) {
        this.TABLE_CAT = TABLE_CAT;
    }

    public String getTABLE_SCHEM() {
        return TABLE_SCHEM;
    }

    public void setTABLE_SCHEM(String TABLE_SCHEM) {
        this.TABLE_SCHEM = TABLE_SCHEM;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    public String getTABLE_TYPE() {
        return TABLE_TYPE;
    }

    public void setTABLE_TYPE(String TABLE_TYPE) {
        this.TABLE_TYPE = TABLE_TYPE;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS;
    }

    @Override
    public String toString() {
        return "LdgTable{" +
                "TABLE_CAT='" + TABLE_CAT + '\'' +
                ", TABLE_SCHEM='" + TABLE_SCHEM + '\'' +
                ", TABLE_NAME='" + TABLE_NAME + '\'' +
                ", TABLE_TYPE='" + TABLE_TYPE + '\'' +
                ", REMARKS='" + REMARKS + '\'' +
                '}';
    }
}
