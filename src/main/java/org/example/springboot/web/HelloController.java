package org.example.springboot.web;
import org.example.springboot.web.dto.HelloReponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
// (예전에는 ResponseBody를 각 메소드마다 매번 선언했던 걸 한번에 사용할 수 있게 해준다)
public class HelloController {

    @GetMapping("/hello") //HTTP Method인 Get 요청을 받을 수 있는 API 생성
    // 예전에는 @RequestMapping(method=RequestMethod.GET)으로 사용했었음
    public String hello() {
        return "hello";//-> /hello로 요청오면 문자열 hello 반환하는 기능
    }

    @GetMapping("/hello/dto")
    public HelloReponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloReponseDto(name, amount);
    }
    // @RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션.
    // 외부에서 name이란 이름으로 넘긴 파라미터를 메소드 파라미터 name에 저장
}
