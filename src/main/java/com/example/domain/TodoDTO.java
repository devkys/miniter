package com.example.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TodoDTO {
    // 만약 DateTimeFormat어노테이션을 사용할 경우
    // SampleController에 initBinder 메서드를 사용하지 않아도 됨.
    private String title;
    @DateTimeFormat(pattern = "yyyy//MM//dd")
    private Date dueDate;

}
