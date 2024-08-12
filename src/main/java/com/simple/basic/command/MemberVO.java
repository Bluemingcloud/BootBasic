package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MemberVO {

    @Pattern(regexp = "[a-zA-Z0-9]{8,}")
    private String id;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[\\W_])(?=.*[0-9]?).{8,}$")
    private String pw;
}
