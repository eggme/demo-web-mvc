package me.whiteship.demowebmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Sample2Controller {
    private Logger LOG = LoggerFactory.getLogger(Sample2Controller.class);
    /*
        핸들러 메소드
        WebRequest 광범위하게 조절할 수 있지만, 로우레벨이라서 잘 안씀
        NativeWebRequest -> 여기서 꺼내는 request 는 HttpServletRequest 로 변환할 수 있음, 스프링이 제공하는거라 Servlet 을 감쌌다고 보면 됨
        HttpServletRequest, HttpServletResponse 둘다 사용 가능 (아직까지 로우레벨)
        String line = request.getReader().readLine(); // request Body
        PushBuilder -> HTTP2 에서 사용할 수 있는 방법인데, 뷰에서 리소스를 브라우저가 요청을 받았을 때 PushBuilder를 사용해서 서버가 능동적으로
        요청을 할 수 있다? Client 가 /mvc 를 요청을 보내고 응답을하는데 (다시 알아봐야할 듯. 대충 느낌은 서버에 요청을 보낸 후 서버가 응답 페이지를 '
        주는데 그 다음 또 받은 뷰에서 이미지 등 리소스를 요청하니까 그걸 다시 클라이언트가 요청을 하는게 아니라 바로 서버가 보내주는거? 같음)
        Model -> 모델을 리턴하는데 뷰 네임을 어케 찾냐? -> RequestToViewNameTranslator 을 사용해서 찾음 Mapping 이름을 가지고 찾음
    ㄴ*/
    @GetMapping("/mvc")
    public String test(){
        return "index";
    }

    /*
        어노테이션 위에서 쓸 수 있는 어노테이션이 Meta 어노테이션
        Composed 어노테이션을 쓰는 이유 매번 @RequestMapping("/url", method="GET") 이렇게 주는 것 보다
        @GetMapping("/url") 이렇게 주는게 더 편함
     */
    @GetMapping("/test")
    public String helloGet(){
        return "hello ~";
    }

    @GetHelloMapping
    public String customAnnotation(){
        return "hello :D";
    }

    @PostMapping("/test")
    public String helloPost(){
        return "hello ~";
    }

    @GetMapping("/events")
    public String test1(){
        return "events problem 1";
    }

    @GetMapping("/events/?")
    public String test2(){
        return "events problem 2";
    }

    @PostMapping(value = "/events/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String test3(@PathVariable String id){
        return "events problem 3 id =>" + id;
    }

    @DeleteMapping(value = "/events/?")
    public String test4(){
        return "event problem 4";
    }

    @PutMapping(value = "/events/?", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String test5(){
        return "event problem 5";
    }
}
