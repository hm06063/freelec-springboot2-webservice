package org.example.springboot;

import org.springframework.boot.SpringApplication; //import 단축키: alt+enter
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication//스프링 부트의 자동설정, 스프링 bean 읽기와 생성 모두 자동으로 설정. -> 여기부터 설정 읽어감
public class Application {//메인클래스. -> SpringBootApplication부터 읽기 때문에 프로젝트 최상단에 위치해야함
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);//내장 WAS 실행->tomcat 설치 필요X, Jar로 실행
        /* 스프링부트에서는 내장 WAS 사용하는 것을 권장 <- 언제 어디서나 같은 환경에서 스프링부트 배포.
        * 성능차이도 톰캣과 큰 차이 없음. 똑같은 코드 사용하기 때문에 */
    }
}