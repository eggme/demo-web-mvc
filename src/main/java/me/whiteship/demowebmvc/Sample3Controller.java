package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class Sample3Controller {
    /*
        PathVariable -> 타입 변환 지원!
        아이디와 경로 이름으로 맞출 필요는 없음, 아규먼트를 넣어주면 되는데
        매개변수와 이름을 찾우면 아규먼트를 생략가능
        기본적으로 MatrixVariable 을 지원하지 않아서 세미콜론을 지우지 않는 설정을 해야함
     */
    @RequestMapping("/sample/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable("id") Optional<Integer> value, @MatrixVariable String name){
        Event event = new Event();
        event.setId(value.get());
        event.setName(name);
        return event;
    }

}
