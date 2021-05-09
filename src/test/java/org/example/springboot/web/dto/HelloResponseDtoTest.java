package org.example.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 룸복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloReponseDto dto = new HelloReponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        /*
        * assertThat : assertj라는 테스트 검증 라이브러리의 검증메소드.
                       검증하고 싶은 대상을 메소드 인자로 받음.
        * isEqualTo : assertj의 동등 비교 메소드
                      assertThat에 있는 값과 isEqualTo의 값을 비교해 같아야 성공.
        */

        //Junit과 비교한 assertj의 장점 : 자동완성 더 확실, 추가적 라이브러리 필요x

    }
}
