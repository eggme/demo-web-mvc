package me.whiteship.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    //@RequestMapping("/{name:[a-z]+}")
    @RequestMapping("/seungjun")
    @ResponseBody
    public String hello( ){
        return "hello seungjun";
    }

    @RequestMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String jsons(){
        return "hello";
    }


    @RequestMapping("/**")
    @ResponseBody
    public String hello2(){
        return "hello";
    }
}
