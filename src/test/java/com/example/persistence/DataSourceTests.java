package com.example.persistence;

import lombok.extern.log4j.Log4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@Log4j
public class DataSourceTests {

    @Autowired
    private BasicDataSource dataSource;

    @Test
    public void testConnection() {
       try{
           Connection con = dataSource.getConnection();
           log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
           log.info(con);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
