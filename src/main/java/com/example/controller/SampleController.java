package com.example.controller;

import com.example.domain.SampleDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Component
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {
        log.info("basic get....");
    }

    @GetMapping("/basicOnlyGet")
    public void basicGet2(){
        log.info("basic get only get...............");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info("  " + dto);
        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") String age) {
        log.info("name: " + name);
        log.info("age :" + age);

        return "ex02";
    }

}
