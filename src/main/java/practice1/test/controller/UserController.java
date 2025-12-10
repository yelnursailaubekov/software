package practice1.test.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice1.test.model.UserModel;
import practice1.test.service.impl.MyUserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final MyUserService userService;


    @GetMapping
    public String test() {
        return "test";
    }


    @PostMapping("/register")
    public void register(@RequestBody UserModel userModel) {
        userService.register(userModel);
    }
}
