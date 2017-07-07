package com.dbgenerate.api.utils;

import com.dbgenerate.api.bo.LdgTable;
import com.dbgenerate.api.bo.LdgTableInfo;
import com.dbgenerate.api.po.TDbSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbInfoUtil {
    public static List<LdgTable> getTableList(TDbSource param) {
        List<LdgTable> result = new ArrayList();
        Connection conn = null;
        DatabaseMetaData dbmd = null;
        try {
            Class.forName(param.getDbsourcedriver()); //1、使用CLASS 类加载驱动程序
            conn = DriverManager.getConnection(param.getDbsourcelinkurl(), param.getDbsourceusername(), param.getDbsourcepassword()); //2、连接数据库
            dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(conn.getCatalog(), param.getDbsourceusername().toUpperCase(), null, new String[]{"TABLE"});
            while (rs.next()) {
                LdgTable table = new LdgTable();
                table.setTABLE_NAME(rs.getString("TABLE_NAME"));
                table.setREMARKS(rs.getString("REMARKS"));
                table.setTABLE_CAT(rs.getString("TABLE_CAT"));
                table.setTABLE_TYPE(rs.getString("TABLE_TYPE"));
                table.setTABLE_SCHEM(rs.getString("TABLE_SCHEM"));
                result.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 根据数据库的连接参数，获取指定表的基本信息：字段名、字段类型、字段注释
     *
     * @param table 表名
     * @return Map集合
     */
    public static List<LdgTableInfo> getTableInfo(TDbSource param, String table) {
        List<LdgTableInfo> result = new ArrayList();
        Connection conn = null;
        DatabaseMetaData dbmd = null;
        try {
            Class.forName(param.getDbsourcedriver()); //1、使用CLASS 类加载驱动程序
            conn = DriverManager.getConnection(param.getDbsourcelinkurl(), param.getDbsourceusername(), param.getDbsourcepassword()); //2、连接数据库
            dbmd = conn.getMetaData();
            ResultSet resultSet = dbmd.getTables(conn.getCatalog(), param.getDbsourceusername().toUpperCase(), table, new String[]{"TABLE"});
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                if (tableName.equals(table)) {
                    ResultSet rs = conn.getMetaData().getColumns(conn.getCatalog(), getSchema(conn), tableName.toUpperCase(), "%");
                    while (rs.next()) {
                        LdgTableInfo tableinfo = new LdgTableInfo();
                        String colName = rs.getString("COLUMN_NAME");
                        tableinfo.setCOLUMN_NAME(colName);

                        String remarks = rs.getString("REMARKS");
                        if (remarks == null || remarks.equals("")) {
                            remarks = colName;
                        }
                        tableinfo.setREMARKS(remarks);
                        String dbType = rs.getString("TYPE_NAME");
                        tableinfo.setTYPE_NAME(dbType);
                        result.add(tableinfo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static String changeDbType(String dbType) {
        dbType = dbType.toUpperCase();
        switch (dbType) {
            case "VARCHAR":
            case "VARCHAR2":
            case "CHAR":
                return "1";
            case "NUMBER":
            case "DECIMAL":
                return "4";
            case "INT":
            case "SMALLINT":
            case "INTEGER":
                return "2";
            case "BIGINT":
                return "6";
            case "DATETIME":
            case "TIMESTAMP":
            case "DATE":
                return "7";
            default:
                return "1";
        }
    }


    //其他数据库不需要这个方法 oracle和db2需要  
    private static String getSchema(Connection conn) throws Exception {
        String schema;
        schema = conn.getMetaData().getUserName();
        if ((schema == null) || (schema.length() == 0)) {
            throw new Exception("ORACLE数据库模式不允许为空");
        }
        return schema.toUpperCase().toString();

    }

}  