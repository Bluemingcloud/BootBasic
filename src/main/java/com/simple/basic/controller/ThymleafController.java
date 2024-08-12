package com.simple.basic.controller;

import com.simple.basic.command.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/view")
public class ThymleafController {

    @GetMapping("/ex01")
    public String ex01() {
        return "view/ex01";
    }

    @GetMapping("/ex02")
    public String ex02(Model model) {
        List<TestVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestVO testVO = TestVO.builder()
                    .num(i + 1)
                    .age(i + 20)
                    .name("홍길동" + i)
                    .addr("서울시" + i)
                    .build();
            list.add(testVO);
        }

        model.addAttribute("list", list);
        return "view/ex02";
    }

    @GetMapping("/ex03")
    public String ex03(Model model) {
        List<TestVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestVO testVO = TestVO.builder()
                    .num(i + 1)
                    .age(i + 20)
                    .name("홍길동" + i)
                    .addr("서울시" + i)
                    .build();
            list.add(testVO);
        }
        model.addAttribute("list", list);
        return "view/ex03";
    }

    @GetMapping("/ex03_result")
    public String ex03Result() {
        return "view/ex03_result";
    }

    @GetMapping("/ex03_result2/{num}/{name}/{age}")
    public String ex03Result2(@PathVariable("num") int num,
                              @PathVariable("name") String name,
                              @PathVariable("age") int age,
                              Model model) {
        TestVO testVO = TestVO.builder()
                .num(num)
                .name(name)
                .age(age)
                .build();
        model.addAttribute("vo", testVO);
        return "view/ex03_result";
    }

    @GetMapping("/ex04")
    public String ex04(Model model) {

        TestVO testVO = TestVO.builder()
                .num(1)
                .age(20)
                .name("홍길동")
                .addr("서울시")
                .build();

        model.addAttribute("name", "홍길동");
        model.addAttribute("arr", new Integer[] {1, 2, 3});
        model.addAttribute("now", new Date());
        model.addAttribute("vo", testVO);

        return "view/ex04";
    }

    @GetMapping("/ex05")
    public String ex05() {
        return "view/ex05";
    }

    @GetMapping("/ex06")
    public String ex06() {
        return "view/ex06";
    }

}
