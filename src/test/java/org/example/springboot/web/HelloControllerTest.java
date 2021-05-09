package org.example.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)//테스트 진행시 JUnit에 내장된 실행자 외 다른 실행자를 실행시킴.
//여기서는 SpringRunner라는 스프링 실행자를 사용 -> 스프링 부트 테스트와 JUnit 사이 연결자 역할
@WebMvcTest//여러 스프링 어노테이션 중 web(스프링 mvc)에 집중할 수 있는 어노테이션.
//선언시 @Controller,@ControllerAdvice 등 사용 가능, @Service,@Component,@Repository 등 사용 불가.
public class HelloControllerTest {
    @Autowired//스프링이 관리하는 빈(bean)을 주입 받음
    private MockMvc mvc;//웹 API를 테스트할 때 사용. 스프링 MVC 테스트의 시작점
    //이 클래스로 HTTP GET,POST 등에 대한 API 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello"))//MockMvc를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk())//mvc.perform의 결과 검증. HTTP header의 status 검증. OK는 200 상태
                .andExpect(content().string(hello));//mvc.perform의 결과(응답 본문의 내용) 검증. "hello"를 리턴하니까 이값 맞는지 검증
    }

    @Test
    public void helooDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name",is(name)))
                    .andExpect(jsonPath("$.amount",is(amount)));
        //param: API 테스트할 때 사용될 요청 파라미터 설정. 값은 String만 허용
        //jsonPath: JSON 응답값을 필드별로 검증할 수 있는 메소드. $를 기준으로 필드명 명시. name 검증 -> $.name으로 검증
    }
}
