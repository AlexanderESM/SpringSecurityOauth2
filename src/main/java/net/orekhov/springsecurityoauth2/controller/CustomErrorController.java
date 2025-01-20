package net.orekhov.springsecurityoauth2.controller;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(Model model) {
        model.addAttribute("message", "An error occurred. Please try again.");
        return "error"; // Шаблон error.html
    }
}

