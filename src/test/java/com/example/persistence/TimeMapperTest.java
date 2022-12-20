package com.example.persistence;

import com.example.mapper.TimeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@Log4j
public class TimeMapperTest {
    @Setter(onMethod_ = { @Autowired })
    private TimeMapper timeMapper;

    @Test
    public void testTime(){
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTime());
    }

    @Test
    public void testGetTime2() {
       log.info("getTime2");
       log.info(timeMapper.getTime2());
    }

}
