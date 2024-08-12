package com.simple.basic.controller;

import com.simple.basic.command.ValidVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/valid")
public class ValidController {

    @GetMapping("/view")
    public String view(Model model) {
        //model.addAttribute("vo", new ValidVO());
        return "valid/view";
    }

    @PostMapping("/actionForm")
    public String actionForm(@Valid @ModelAttribute("vo") ValidVO vo,
                             BindingResult bindingResult) {

        // @Valid는 유효성 검사를 하겠다는 표시
        // 만약 유효성 검사에 통과하지 못하면, 통과하지 못한 멤버변수 내역이 BindingResult 객체에 저장됩니다.
        if (bindingResult.hasErrors()) { // 내역이 있으면 true, 없으면 false
//              System.out.println("유효성 검사 실패");
//            List<FieldError> errors = bindingResult.getFieldErrors(); // 유효성 검사에 실패한 목록
//            for(FieldError error : errors) {
//                System.out.println(error.getField()); // 유효성 검사에 실패한 필드명(input name="필드명")
//                System.out.println(error.getDefaultMessage()); // 유효성 검사에 실패한 내역의 message 값
//            }
            return "valid/view";
        }

        // 처리
        //System.out.println(vo.toString());

        return "redirect:/valid/result";
    }

    @GetMapping("/result")
    public String result() {
        return "valid/result";
    }
}
