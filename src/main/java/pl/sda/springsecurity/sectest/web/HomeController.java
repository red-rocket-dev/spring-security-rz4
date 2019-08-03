package pl.sda.springsecurity.sectest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {
    @GetMapping("/hello")
    public String getHello(Principal principal, Model model) {
        String name = principal.getName();
        model.addAttribute("username", name);
        return "helloWorld";
    }
}
