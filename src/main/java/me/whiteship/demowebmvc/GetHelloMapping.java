package me.whiteship.demowebmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET, value = "/hello")
public @interface GetHelloMapping {
    /*
     어노테이션의 Retention -> 해당 어노테이션 값을 언제까지 유지할 것 인가?
     기본값은 RetentionPolicy.CLASS -> 런타임시 사라짐
     컴파일이 되어도 어노테이션 정보가 클래스에 남아있는데, 클래스를 로딩하는 순간 사라짐
     클래스로더가 바이트코드를 읽어올 때 RetentionPolicy 가 CLASS 인 어노테이션의 정보가 사라짐
     스프링 컨테이너가 런타임시 참고해야하기때문에 실행이 안됌
     RetentionPolicy 크기
     SOURCE < CLASS < RUNTIME
     @Target -> 해당 어노테이션을 어디에 붙일 것인가?
     @Documented -> 해당 어노테이션을 사용한 곳에서 자바독에 남게됨
     */
}
