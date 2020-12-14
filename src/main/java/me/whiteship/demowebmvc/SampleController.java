package me.whiteship.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/jun")
@Controller
public class SampleController {

    //@RequestMapping("/{name:[a-z]+}")
    @RequestMapping(value = "/helloThymeleaf", method = {RequestMethod.PUT, RequestMethod.GET})
    public String hellos(){
        return "index";
    }

    @RequestMapping("/hello")
    public @ResponseBody String helloDefault(){
        return "hello";
    }

    @RequestMapping("/{name=[a-z]+}")
    public String sample2(@PathVariable String name){
        return "hello " +name;
    }

    @RequestMapping("/map")
    @ResponseBody
    public String sample(@RequestParam String name){
        return "hello "+name;
    }

    @RequestMapping({"/seungjun", "/hi"}) // URI > URL 범위
    @ResponseBody
    public String hello(){
        return "hello seungjun";
    }
    /*
        ContentType 및 Accept-Header 를 사용해서 매핑
        consumes -> ContentType 을 설정할 수 있음 , 문자열로 application/json 이런식으로 줄 수 있는데 Type Safe 하기 위해
        MediaType.APPLICATION_JSON_VALUE 를 사용하면 됌
        produces -> 리턴하는 ContentType 의 종류
     */
    @RequestMapping(
            value = "/helloMediaType",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
    )
    @ResponseBody
    public String jsons(){
        return "hello";
    }

    @RequestMapping(
            value = "/helloMediaType1",
            headers = HttpHeaders.FROM+ "="+"localhost",
            params = "name"
    )
    @ResponseBody
    public String json(@RequestParam String name){
        return "hello " + name;
    }


//    @RequestMapping("/**")
//    @ResponseBody
//    public String hello2(){
//        return "hello";
//    }
}
