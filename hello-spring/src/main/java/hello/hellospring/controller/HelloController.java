package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";
    }
    //
    @GetMapping("hello-mvc") // 화면을 가지고 (뷰) 조작하는 방식
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    //
    @GetMapping("hello-string")
    @ResponseBody // <html>코드 없이 문자를 그대로 보냄
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    //API (json으로 객체반환 뷰없이. ResponseBody에 객체를 담아서 반환해주는 것.)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }




    }
}
