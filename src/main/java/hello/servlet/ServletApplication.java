package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ServletComponentScan // servlet 자동 등록
public class ServletApplication {

    // https://mangkyu.tistory.com/75
    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }

    // application.properties 대신 아래와 같이  작성해도 무방
//    @Bean
//    ViewResolver internalResourceViewResolver(){
//        return new InternalResourceViewResolver("/WEB-INF/views",".jsp");
//    }

}
