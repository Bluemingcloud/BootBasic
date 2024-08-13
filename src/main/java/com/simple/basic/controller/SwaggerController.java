package com.simple.basic.controller;

import com.simple.basic.command.ErrorVO;
import com.simple.basic.command.SwaggerVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Tag(name = "Swagger 사용 예제 API 명세 document", description = "예제 API에 대한 내용입니다.") // API 엔드포인트에 대한 정보
public class SwaggerController {

    //http://localhost:8181/swagger-ui/index.html
    //http://localhost:8181/v3/api-docs
    //에서 확인 가능

    // 요청 본문에 대한 설명을 추가합니다.
    @Operation(
            summary = "Get Example 입니다.",
            description = "id 회원의 정보를 조회합니다."
    )
    // 파라미터에 대한 설명을 추가합니다.
    @Parameter(name = "id", description = "ID는 식별자이고 필수로 전달해야 합니다.", required = true)

    // 응답 본문에 대한 설명을 추가합니다.
    @ApiResponse(
            responseCode = "200",
            description = "요청 성공시 반환됩니다.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = SwaggerVO.class)
            )
    )
    @ApiResponse(
            responseCode = "400",
            description = "잘못된 매개변수를 의미합니다.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorVO.class),
                    examples = @ExampleObject(value = "{\"errorCode\": \"400\", \"message\": \"Invalid ID\"}")
            )
    )

    @GetMapping(value = "/getItem/{id}", produces = "application/json")
    public ResponseEntity<?> getItem(@PathVariable("id") String id) {
        if(id == null) {
            return new ResponseEntity<>(new ErrorVO("405", "invalid id"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new SwaggerVO("1", "홍", "길동", LocalDateTime.now()), HttpStatus.OK);
    }

    /*
    아래 코드는
    post방식 /api/v3/history
    요청본문
        json타입, SimpleVO데이터
    응답본문
        정의하지않음, SimpleVO데이터
    을 나타내는 REST API코드 입니다.

    이코드로 스웨거 문서에 사진처럼 표시되도록 정의해보세요.
    */
    @Operation(
            summary = "Post 실습입니다.",
            description = "회원의 구매이력을 리턴합니다"
    )
    @Parameter(name = "sno", description = "회원번호", required = true)
    @Parameter(name = "first", description = "회원이름")
    @ApiResponse(
            responseCode = "200",
            description = "요청 성공시 반환됩니다.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = SwaggerVO.class),
                    examples = @ExampleObject(value = "{\"first\": \"길동\", \"last\": \"홍\"}")
            )
    )
    @PostMapping(value = "/api/v3/history")
    public ResponseEntity<?> history(@RequestBody SwaggerVO vo) {
        return new ResponseEntity<>(new SwaggerVO("1", "홍", "길동", LocalDateTime.now()), HttpStatus.OK );
    }
}
