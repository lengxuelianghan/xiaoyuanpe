package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.UserService;
import com.xiaoyuanpe.units.Pager;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private Map<Integer, String> startTime = new HashMap<>();
    private Map<Integer, String> endTIme = new HashMap<>();
    @PostMapping(value = "/addUser")
    public ResultBean addUser(@RequestBody User user){
        ResultBean resultBean = new ResultBean();
        try {
            this.userService.addUser(user);
            resultBean.setCode(0);
        }catch (Exception se){
            System.out.println("出错"+se.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("用户添加失败"+se.getMessage());
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryUser/{id}")
    public ResultBean queryUser(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            User user = this.userService.findUsersById(id);
            resultBean.setCode(0);
            resultBean.setData(user);
            System.out.println(user.getIdentity());
        }catch (Exception se){
            System.out.println("出错"+se.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("用户查询失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/queryUserList/{current}/{pageSize}")
    public ResultBean queryUserList(@PathVariable Integer current, @PathVariable Integer pageSize){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.userService.findUsersAll(current, pageSize));
            resultBean.setCode(0);
        }catch (Exception se){
            System.out.println("出错"+se.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("用户列表查询失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/ceshi")
    public String ceshi(){
      return "hello world";
    }

    @RequestMapping(value = "/updateUser")
    public ResultBean updateUser(@RequestBody User user){
        ResultBean resultBean = new ResultBean();
        try {
            this.userService.ModifyUser(user);
            resultBean.setCode(0);
        }catch (Exception se){
            System.out.println("出错"+se.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("用户更新失败");
        }
        return resultBean;
    }

    @PostMapping("/deleteUser")
    public ResultBean deleteUser(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            this.userService.DeleteUserList(ids);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            System.out.println(e.getMessage());
            resultBean.setMsg("删除失败"+e.getMessage());
        }
        return resultBean;
    }
//    @RequestMapping(value="/startTime/{id}/{time}")
//    public ResultBean startTime(@PathVariable Integer id, String time){
//        ResultBean resultBean = new ResultBean();
//        resultBean.setData(time);
//        if (startTime.keySet().contains(id)) {
//            this.startTime.remove(id);
//        }
//        this.startTime.put(id, time);
//        return resultBean;
//    }
//    @RequestMapping(value = "/endTime/{id}/{time}")
//    public ResultBean endTime(@PathVariable Integer id, String time){
//        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//        ResultBean resultBean = new ResultBean();
//        resultBean.setData(time);
//        if (this.endTIme.keySet().contains(id)){
//            this.endTIme.remove(id);
//        }
//        this.endTIme.put(id,time);
//        int minutes = 0;
//        try {
//            String d1 = this.startTime.get(id);
//            String d2 = this.endTIme.get(id);
//            Date dStart = simpleFormat.parse("2018-03-01 12:00");
//            Date dEnd = simpleFormat.parse("2018-03-12 12:00");
//            long ds = dStart.getTime();
//            long de = dEnd.getTime();
//            minutes = (int) ((de - ds) / (1000 * 60));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        if (this.startTime.keySet().contains(id)){
//            resultBean.setData(minutes);
//            resultBean.setCode(0);
//            //System.out.println(this.endTIme.get(id)-this.startTime.get(id));
//        }
//        else {
//            resultBean.setMsg("未点击开始");
//            resultBean.setCode(1);
//            System.out.println("未点击开始");
//        }
//        return resultBean;
//    }
}
