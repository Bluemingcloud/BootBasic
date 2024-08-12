package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MemoDTO {

    private Integer mno;

    //@Pattern(regexp = "^.{5,}$",message = "메모는 5글자 이상입니다.")
    @Size(min = 5, message = "메모는 5글자 이상입니다.")
    private String memo;

    @Pattern(regexp = "^(01[016789])-?\\d{3,4}-?\\d{4}$", message = "올바른 전화번호를 입력하세요.")
    private String phone;

    @Pattern(regexp = "^\\d{4}$", message = "비밀번호는 숫자 4자리 입니다.")
    private String pw;

    @NotBlank(message = "유형을 선택하세요.")
    private String secret;
}
