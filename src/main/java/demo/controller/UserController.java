package demo.controller;

import com.alibaba.fastjson.JSONObject;
import demo.annotation.UserLoginToken;
import demo.mode.User;
import demo.service.TokenService;
import demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


@RestController
@Slf4j
public class UserController {
    @Autowired
    public UserService userService;
    @Autowired
    public TokenService tokenService;

    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        log.info("user:{}",user);
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByUsername(user);
        log.info("根据名字查出来的数据:{}",userForBase);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
