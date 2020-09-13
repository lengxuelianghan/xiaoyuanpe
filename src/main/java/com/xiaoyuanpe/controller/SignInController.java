package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Signin;
import com.xiaoyuanpe.services.SignInService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SignIn")
public class SignInController {

    @Autowired
    private SignInService signInService;

    @PostMapping("/addSignIn")
    public ResultBean addSignIn(@RequestBody Signin signin){
        ResultBean resultBean = new ResultBean();
        try{
            //if ()
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/updateSignIn")
    public ResultBean updateSignIn(@RequestBody Signin signin){
        ResultBean resultBean = new ResultBean();
        try{
            this.signInService.ModifySignin(signin);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/updateSignInList")
    public ResultBean updateSignInList(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try{

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

}
