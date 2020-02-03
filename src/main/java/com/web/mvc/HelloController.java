package com.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hi")
    @ResponseBody
    public String sayHi() {
        return "Hi!";
    }

    @RequestMapping("/yes")
    @ResponseBody
    public String sayYes() {
        return "Yes!";
    }

    @RequestMapping("/page")
    public ModelAndView callJsp() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "peter");
        /* 如果applicationContext.xml有設定 視圖解析器 就只需要給予檔名就好
        mv.setViewName("/WEB-INF/jsp/hello.jsp");
         */
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping("/page2")
    public String callJsp2(Model model) {
        model.addAttribute("name", "peter");
        return "hello";
    }

    /*
    @RequestMapping(value = "路徑")
    ?  匹配 1 個字符  /testPaths? -> /testPathsA
    ?? 匹配 2 個字符  /testPaths?? -> /testPathsAA
    *  匹配任意字符   /testPaths/* -> /testPaths/ABCDEFG...
    *  匹配任意字符   /testPaths/ * /ok -> /testPaths/ttt/ok
    ** 可含有任意多層路徑 /testPaths/** -> /testPaths/aa/bb/cc
    ** 可含有任意多層路徑 /testPaths/ ** /ok -> /testPaths/aa/bb/cc/ok
     */
    @RequestMapping(value = "/testPaths/**")
    public String testPaths(Model model) {
        model.addAttribute("name", "Path");
        return "hello";
    }

    @RequestMapping(value = "/testPaths/{name}")
    public String testPaths(Model model, @PathVariable("name") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/testParam")
    public String testParam(Model model, @RequestParam("name") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

}
