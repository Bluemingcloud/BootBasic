package com.simple.basic.config;

import com.simple.basic.command.TestVO;
import com.simple.basic.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Spring 설정 파일임을 나타냄
//@PropertySource("classpath:/hello.properties") // 특정 properties 파일을 참조받을 때 사용
public class WebConfig implements WebMvcConfigurer {

    /*
    @Value("${server.port}") // application.properties 파일의 키값을 읽어서 받아옴
    String port;

    @Value("${hello}")
    String hello;

    @Value("${bye}")
    String bye;

    // 자바코드로 bean 생성
    @Bean
    public TestVO testVO() {
        return new TestVO();
    }
    */

    /*
    @Autowired
    ApplicationContext applicationContext; // IoC 엔진

    @Bean // Spring이 이 코드를 실행시켜서, return 에 담기는 값을 bean 으로 등록
    public void test() {
//        System.out.println("Spring 설정파일 실행됨");
//
//        int result = applicationContext.getBeanDefinitionCount();
//        System.out.println("context안의 Bean 전체개수 :" + result);
//
//        HomeController home = applicationContext.getBean(HomeController.class);
//        System.out.println("context안에 만들어진 home 컨트롤러: " + home);

        TestVO vo = applicationContext.getBean(TestVO.class);
        System.out.println("context안의 testVO Bean : " + vo);

        System.out.println("application.properties 파일의 server.port 값: " + port);
        System.out.println("application.properties 파일의 hello 값: " + hello);
        System.out.println("hello.properties 파일의 bye 값: " + bye);
    }
    */
}
