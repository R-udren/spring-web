package rvt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
public class DefaultController {
    
   @GetMapping(value = "/")
    String index() {
        return "index";
    }

    @GetMapping(value = "/hello")
    String hello(@RequestParam(name="name", required=false, defaultValue="Anonymous") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping(value = "/about")
    String about() {
        return "about";
    }

    @GetMapping(value = "/login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }   

    @GetMapping(value = "/registration")
    public ModelAndView registerForm() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("roles", new String[] {"Other", "Student", "Buisness", "Home"});
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            modelAndView.addObject("roles", new String[] {"Other", "Student", "Buisness", "Home"});
            return modelAndView;
        }

        modelAndView.setViewName("success");
        modelAndView.addObject("user", user);
        System.out.println(user.toString());
        return modelAndView;
    }

    @GetMapping(value = "/error")
    public ModelAndView errorPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message", "An error occurred");

        return modelAndView;
    }
}
