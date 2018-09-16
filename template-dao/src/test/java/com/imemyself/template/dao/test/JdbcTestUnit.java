package com.imemyself.template.dao.test;

import com.imemyself.template.domain.DictionaryType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JdbcTestUnit {

    Logger LOG = LogManager.getLogger(JdbcTestUnit.class);

    private String driverClassName = "";

    private String url = "";

    private String userName;

    private String password;

    @Before
    public void initMysql() {
        //Mysql驱动
        driverClassName = "com.mysql.cj.jdbc.Driver";
        //MySql连接
        url = "jdbc:mysql://111.231.197.245:3306/imemyself?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=true";
        //mysql 用户名
        userName = "root";
        //登陆密码
        password = "ImeMYself888!";
    }

    @Test
    public void testInsert() throws Exception {
        //加载驱动
        Class.forName(driverClassName);
        //创建连接
        Connection conn = DriverManager.getConnection(url, userName, password);
        Statement stmt = null;
        try {
            //创建Statement
            stmt = conn.createStatement();
            //执行操作
            boolean num = stmt.execute("INSERT INTO dictionary_type(dictionary_type_code,dictionary_type_name,create_date,creator) VALUES('operateType','操作类型',NOW(),'System')");
            LOG.info("result:{}", num);
        } catch (Exception e) {
            LOG.error("操作数据库失败", e);
        } finally {
            //关闭Statement
            if (stmt != null) {
                stmt.close();
            }
            //关闭连接
            if (conn != null) {
                conn.close();
            }
        }
    }

    @Test
    public void testUpdate() throws Exception {
        //加载驱动
        Class.forName(driverClassName);
        //创建连接
        Connection conn = DriverManager.getConnection(url, userName, password);
        Statement stmt = null;
        try {
            //创建Statement
            stmt = conn.createStatement();
            //执行操作
            boolean num = stmt.execute("UPDATE dictionary_type SET remark = '测试更新操作' WHERE id =1");
            LOG.info("result:{}", num);
        } catch (Exception e) {
            LOG.error("操作数据库失败", e);
        } finally {
            //关闭Statement
            if (stmt != null) {
                stmt.close();
            }
            //关闭连接
            if (conn != null) {
                conn.close();
            }
        }
    }

    @Test
    public void testDelete() throws Exception {
        //加载驱动
        Class.forName(driverClassName);
        //创建连接
        Connection conn = DriverManager.getConnection(url, userName, password);
        PreparedStatement stmt = null;
        try {
            //创建Statement
            stmt = conn.prepareStatement("DELETE FROM dictionary_type WHERE id=?");
            stmt.setLong(1, 2);
            //执行操作
            boolean num = stmt.execute();
            LOG.info("result:{}", num);
        } catch (Exception e) {
            LOG.error("操作数据库失败", e);
        } finally {
            //关闭Statement
            if (stmt != null) {
                stmt.close();
            }
            //关闭连接
            if (conn != null) {
                conn.close();
            }
        }
    }

    @Test
    public void testQuery() throws Exception {
        //加载驱动
        Class.forName(driverClassName);
        //创建连接
        Connection conn = DriverManager.getConnection(url, userName, password);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //创建Statement
            stmt = conn.prepareStatement("SELECT id,dictionary_type_code,dictionary_type_name,create_date,creator,remark FROM dictionary_type WHERE id=?");
            stmt.setLong(1, 1);
            //执行操作
            rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String dictionaryTypeCode = rs.getString("dictionary_type_code");
                String dictionaryTypeName = rs.getString("dictionary_type_name");
                Timestamp createDate = rs.getTimestamp("create_date");
                String creator = rs.getString("creator");
                String remark = rs.getString("remark");
                DictionaryType dictionaryType = new DictionaryType();
                dictionaryType.setId(id);
                dictionaryType.setDictionaryTypeCode(dictionaryTypeCode);
                dictionaryType.setDictionaryTypeName(dictionaryTypeName);
                dictionaryType.setCreateDate(createDate);
                dictionaryType.setCreator(creator);
                dictionaryType.setRemark(remark);
                LOG.info(dictionaryType);

            }
        } catch (Exception e) {
            LOG.error("操作数据库失败", e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            //关闭Statement
            if (stmt != null) {
                stmt.close();
            }
            //关闭连接
            if (conn != null) {
                conn.close();
            }
        }
    }
}
