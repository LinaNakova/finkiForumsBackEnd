package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Enumerations.UserType;
import bazi.finki.ukim.mk.finkiforums.Response.UserResponse;
import bazi.finki.ukim.mk.finkiforums.Service.RegistrationService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/register")
public class RegisterController {

    private final RegistrationService registrationService;

    public RegisterController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public UserResponse registerUser(@RequestParam(name = "name") String name,
                                     @RequestParam(name = "lastName") String lastName,
                                     @RequestParam(name = "email") String email,
                                     @RequestParam(name = "username") String username,
                                     @RequestParam(name = "password") String password,
                                     @RequestParam(name = "userType") String userType,
                                     @RequestParam(name = "index", required = false) String index){
        UserType uType = userType.equals(UserType.PROFESSOR.name()) ? UserType.PROFESSOR : UserType.STUDENT;
        return this.registrationService.create(name,lastName,email,username,password,uType,index);
    }
}
