package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ValidVO {

    /*
    @NotNull : null 을 허용하지 않음
    @NotEmpty : null, 공백을 허용하지 않음
    @NotBlank : null, 공백, 화이트스페이스("   ") 를 모두 허용하지 않음
    @Pattern : 정규표현식으로 유효성 검사
    @Email : 이메일 타입만 허용
    @Max : 해당 값 이하
    @Min : 해당 값 이상
    @Size : 크기

    ...

     */
    @NotBlank(message = "이름은 필수 입니다.")
    private String name;

    @NotNull(message = "급여는 필수 입니다.")
    private Integer salary; // int 는 null 값을 가질 수 없어서 유효성 검사에 부적합
    // 유효성 검사하는 필드는 wrapper 클래스로 작성(null 을 가질수 있음)
    @Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호는 000-0000-0000 형식 입니다.")
    private String phone;

    @Email(message = "이메일 형식 이어야 합니다.") // 공백은 통과
    @NotBlank(message = "이메일은 필수 입니다.")
    private String email;
}
