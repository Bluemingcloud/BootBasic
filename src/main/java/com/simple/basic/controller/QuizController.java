package com.simple.basic.controller;

import com.simple.basic.command.MemberVO;
import com.simple.basic.command.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private List<TestVO> makeList() {
        List<TestVO> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            TestVO testVO = TestVO.builder()
                    .num(i)
                    .name("홍길동" + i)
                    .age(20 + i)
                    .build();
            list.add(testVO);
        }
        return list;
    }

    int index = 10;

    @GetMapping("/quiz01")
    public String quiz01(Model model) {
        List<TestVO> list = this.makeList();
        model.addAttribute("list", list);
        return "quiz/quiz01";
    }

    @GetMapping("/quiz01_result/{num}")
    public String quiz01_result(@PathVariable("num") int num, Model model) {
        List<TestVO> list = this.makeList();
        model.addAttribute("vo", list.get(num - 1));
        return "quiz/quiz01_result";
    }

    @GetMapping("/quiz01_regist")
    public String quiz01_regist() {
        return "quiz/quiz01_regist";
    }

    @PostMapping("/quiz01_registForm")
    public String quiz01_registForm(@RequestParam("name") String name,
                                    @RequestParam("age") int age) {
        List<TestVO> list = this.makeList();
        TestVO testVO = TestVO.builder()
                .num(++index)
                .name(name)
                .age(age)
                .build();
        list.add(testVO);
        return "redirect:/quiz/quiz01";
    }

    @GetMapping("/quiz02")
    public String quiz02() {
        return "quiz/quiz02";
    }

    @GetMapping("/quiz02_result")
    public String quiz02Result() {
        return "quiz/quiz02_result";
    }

    @PostMapping("/quiz02Form")
    public String quiz02Form(@Valid @ModelAttribute("vo") MemberVO vo, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "quiz/quiz02";
        }
        return "redirect:/quiz/quiz02_result";
    }

}
