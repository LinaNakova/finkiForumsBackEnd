package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Response.UserResponse;
import bazi.finki.ukim.mk.finkiforums.Service.LoginService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public UserResponse loginUser(@RequestParam(name = "username") String username,
                                  @RequestParam(name = "password") String password){
        return this.loginService.findUserByUsername(username, password);
    }
}
