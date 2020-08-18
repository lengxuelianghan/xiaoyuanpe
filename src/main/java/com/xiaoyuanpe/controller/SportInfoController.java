package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.SportInfo;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.SportInfoService;
import com.xiaoyuanpe.services.UserService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sportInfo")
public class SportInfoController {
    @Autowired
    private SportInfoService sportInfoService;
    @Autowired
    private UserService userService;

    @PostMapping("/addSportInfo")
    public ResultBean addSportInfo(@RequestBody SportInfo sportInfo){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportInfoService.addSportInfo(sportInfo);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("添加运动信息失败！");
        }
        return resultBean;
    }

    @RequestMapping("/querySportInfo/{id}")
    public ResultBean querySportInfo(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportInfoService.findSportInfoById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("查找运动信息失败！");
        }
        return resultBean;
    }

    @RequestMapping("/querySportInfoList")
    public ResultBean querySportInfoList(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportInfoService.findSportInfoAll());
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("查找运动信息列表失败！");
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateSportInfo", method = RequestMethod.POST)
    public ResultBean updateSportInfoList(@RequestBody SportInfo sportInfo){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportInfoService.ModifySportInfo(sportInfo);
            User user = this.userService.findUsersById(sportInfo.getStudentId());
            user.setExerciseTime(user.getExerciseTime()+sportInfo.getSingleExerciseTime());
            if (user.getCredit() < 0){
                if (user.getExerciseTime()>8000){
                    user.setCredit(4);
                }
            }
            this.userService.ModifyUser(user);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("查找运动信息列表失败！");
        }
        return resultBean;
    }

}
