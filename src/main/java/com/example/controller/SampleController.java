package com.example.controller;

import com.example.domain.SampleDTO;
import com.example.domain.SampleDTOList;
import com.example.domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

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

    // GetMapping으로 ex02!
    // url에 받는 파라미터로 name, age 반환 형 지정 가능!!
    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") String age) {
        log.info("name: " + name);
        log.info("age :" + age);

        return "ex02";
    }

    // 스프링은 파라미터의 타입을 보고 객체를 생성하므로 파라미터의 타입은 List<>와 같이
    // 인터페이스 타입이 아닌 실제적인 클래스 타입으로 지정
    // 메서드 이름 ex02List로 지정하고 파라미터 이름 ids 타입은 ArrayList
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids)  {
        log.info("ids: " + ids);

        return "ex02List";
    }

    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids) {

        log.info("ids: " + Arrays.toString(ids));
        return "ex02Array";
    }

    // 전달하는 데이터가 SampleDTO와 같이 객체 타입이고
    // 여러 개를 처리해야 한다면
    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos: " + list);

        return "ex02Bean";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);
        return "/sample/ex04";
    }

    @GetMapping("/ex04_2")
    public String ex04_2(SampleDTO dto, @ModelAttribute("page") int page){
       log.info("dto: " +dto);
       log.info("page: " + page);

       return "/sample/ex04";
    }

}
