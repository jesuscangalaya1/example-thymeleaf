package edu.idat.pe.evc1.evc1.controller;

import edu.idat.pe.evc1.evc1.dtos.request.UserRequest;
import edu.idat.pe.evc1.evc1.dtos.response.UserResponse;
import edu.idat.pe.evc1.evc1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserRequest());
        return "/home/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") UserRequest userRequest, Model model) {
        try {
            UserResponse userResponse = userService.loginUser(userRequest);
            if (userResponse != null && userResponse.getFirstName().equals(userRequest.getFirstName()) && userResponse.getPassword().equals(userRequest.getPassword())) {
                // Usuario autenticado, puedes realizar las acciones necesarias
                return "redirect:/users/index";
            } else {
                return "home/login";
            }
        } catch (Exception e) {
            logger.error("Error al autenticar al usuario", e);
            model.addAttribute("error", "Ocurrió un error al autenticar al usuario");
            return "home/login";
        }
    }



    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserRequest userRequest) {
        userService.createUser(userRequest);
        return "redirect:/users/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRequest());
        return "home/register";
    }


    @GetMapping("/index")
    public String home() {
        return "home/index";
    }
}
