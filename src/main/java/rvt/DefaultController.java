package rvt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {
    
   @GetMapping(value = "/")
    String index(@RequestParam(name="name", required=false, defaultValue="null") String name, Model model) {
        return "index";
    }

    @GetMapping(value = "/hellos")
    String hello() {
        return "hellos";
    }

    @GetMapping(value = "/hello")
    String hello(@RequestParam(name="name", required=false, defaultValue="null") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping(value = "/about")
    String about() {
        return "about";
    }
}
