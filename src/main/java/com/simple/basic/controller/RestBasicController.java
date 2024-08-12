package com.simple.basic.controller;

import com.simple.basic.command.TestVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController// @Controller + @ResponseBody(컨트롤러에서 응답을 요청이 들어온 곳으로 바꿈)
public class RestBasicController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World"; // 원래는 화면의 경로를 반환했으나 RestController 는 요청보낸 클라이언트("/hello") 로 응답한다.
    }

    @GetMapping("/hello2")
    public String[] hello2() {
        return new String[] { "홍", "길", "동" };
    }

//    @GetMapping("/getData")
//    public String getData(TestVO vo) {
//        return vo.toString();
//    }

    @GetMapping("/getData")
    public String getData(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return "name: " + name + ", age: " + age;
    }

    @GetMapping("/getData2/{num}/{name}")
    public String getData2(@PathVariable("num") int num, @PathVariable("name") String name) {
        return "num: " + num + ", name: " + name;
    }

    // 반환을 JSON 타입으로 하려면 Map 타입이나 VO를 쓰면 됩니다. (list 나 배열 도 가능)
    // Jackson-databind 라이브러리가 필요함(Spring Boot 는 기본 포함)
    // VO 클래스 사용
    @GetMapping("/returnData")
    public TestVO returnData() {
        return TestVO.builder().num(1).name("서버에서반환").age(20).addr("서울시").build();
    }

    // Map 타입 사용
    @GetMapping("/returnData2")
    public Map<String, Object> returnData2() {
        Map<String, Object> map = new HashMap<>();
        map.put("num", 1);
        map.put("name", "홍길동");
        map.put("age", 20);
        map.put("arr", Arrays.asList("a", "b", "c"));
        return map;
    }

    ///////////////////////////////////////////////////////////////////////
    // post 방식 - 소비자(사용자) 와 제공자(서버) 이 둘의 데이터를 주고 받는 규약이 정확하게 지켜져야 한다.

    // Form 형식으로 데이터 전송 - 소비자가 데이터를 Form 형식으로 반드시 만들어서 보내야 함
    @PostMapping("/getForm")
    public String getForm(TestVO vo) { // @RequestBody 없이 (TestVO vo) 라고 선언하면 form 타입의 name 값을 통해 자동으로 받아진다.
        System.out.println(vo.toString());
        return "success";
    }

    // JSON 형식으로 데이터 전송
    // @RequestBody - JSON 데이터 -> 자바 Object 로 변형해서 맵핑
    @PostMapping("/getJSON")
    public String getJSON(@RequestBody TestVO vo) { // JSON 과 Object 는 다른 타입 -> @RequestBody 어노테이션을 통해 JSON 의 값을 Object 에 자동 바인딩
        System.out.println(vo.toString());
        return "success";
    }

    // Map 타입도 가능
    @PostMapping("/getJSON2")
    public String getJSON2(@RequestBody Map<String, Object> map) { // map 으로도 받을 수 있으나 연관된 데이터 값인지 확인없이 모두 받기 때문에 지양됨
        System.out.println(map.toString());
        return "success";
    }

    //@PutMapping (수정), @DeleteMapping (삭제) - Post 방식과 거의 유사해서 모두 Post 요청처리로 대신하기에 잘 사용되지 않는다.

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // consumer - 반드시 이 타입으로 보내라!
    // produces - 내가 이 타입으로 줄게
    // 기본값 - "application/json"
    @PostMapping(value = "/getResult", consumes = "text/plain", produces = "text/html")
    public String getResult( @RequestBody String str) {
        System.out.println(str);
        return "<h3>문자열</h3>";
    }

    // ResponseEntity<데이터 타입>
    // 응답 문서 명확하게 작성하기
    @PostMapping("/getEntity")
    public ResponseEntity<TestVO> getEntity() {
        TestVO vo = new TestVO(1, "홍길동", 20, "서울시");
        // 1st
        // ResponseEntity entity = new ResponseEntity(vo, HttpStatus.OK);

        // 2nd
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer JSON WEB TOKEN");
        header.add("Content-Type", "application/json"); // produces 와 같은 표현
        header.add("Access-Control-Allow-Origin", "http://example.com");

        ResponseEntity entity = new ResponseEntity(vo, header, HttpStatus.OK); // 데이터, 헤더, 상태값

        return entity;
    }
}
