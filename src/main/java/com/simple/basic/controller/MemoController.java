package com.simple.basic.controller;

import com.simple.basic.command.MemoDTO;
import com.simple.basic.memo.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/memo")
public class MemoController {

    // insert기능 - 유효성 검사
    // select기능 - 화면처리

    @Autowired
    @Qualifier("memoService")
    MemoService memoService;

    @GetMapping("/memoWrite")
    public String memoWrite() {
        return "memo/memoWrite";
    }

    @PostMapping("/memoForm")
    public String memoForm(@Valid @ModelAttribute("dto") MemoDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "memo/memoWrite";
        }
        memoService.writeMemo(dto);
        return "redirect:/memo/memoList";
    }

    @GetMapping("/memoList")
    public String memoList(Model model) {
        ArrayList<MemoDTO> list = memoService.getMemoList();
        model.addAttribute("list", list);
        return "memo/memoList";
    }

    @GetMapping("/memoEdit/{mno}")
    public String memoEdit(@PathVariable Integer mno, Model model) {
        MemoDTO dto = memoService.getMemo(mno);
        model.addAttribute("dto", dto);
        return "memo/memoEdit";
    }

    @PostMapping("/memoEditForm")
    public String memoEditForm(@Valid @ModelAttribute("dto") MemoDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "memo/memoEdit";
        }
        memoService.editMemo(dto);
        return "redirect:/memo/memoList";
    }

}
