package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.HealthManagementEntry;
import com.xiaoyuanpe.pojo.Healthmanagement;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.HeathManageService;
import com.xiaoyuanpe.services.StudentService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Health")
public class HealthManageController {
    @Autowired
    private HeathManageService heathManageService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/addHealthInfo", method = RequestMethod.POST)
    public ResultBean addHealthInfo(@RequestBody Healthmanagement healthmanagement){
        ResultBean resultBean = new ResultBean();
        try {
            this.heathManageService.addHealthmanagement(healthmanagement);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("添加失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryHealthInfoById/{id}")
    public ResultBean queryHealthInfoById(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.setHealthManagementEntry(this.heathManageService.findCollegeHealthmanagementById(id)));
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查询失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryHealthInfos")
    public ResultBean queryHealthInfos(){
        ResultBean resultBean = new ResultBean();
        try {
            List<HealthManagementEntry> healthManagementEntrys = new ArrayList<>();
            for (Healthmanagement healthmanagement: this.heathManageService.findHealthmanagementAll()){
                healthManagementEntrys.add(this.setHealthManagementEntry(healthmanagement));
            }
            resultBean.setData(healthManagementEntrys);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查询失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/updateHealthInfo", method = RequestMethod.POST)
    public ResultBean updateHealthInfo(@RequestBody Healthmanagement healthmanagement){
        ResultBean resultBean = new ResultBean();
        try {
            this.heathManageService.ModifyHealthmanagement(healthmanagement);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("修改失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/deleteHealthInfo", method = RequestMethod.POST)
    public ResultBean deleteHealthInfo(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            for (Integer id: ids) {
                this.heathManageService.DeleteHealthmanagement(id);
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("删除失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/getSingleHealth")
    public ResultBean getSingleHealth(HttpSession session){
        ResultBean resultBean = new ResultBean();
        User user = (User) session.getAttribute("user");
        try {
            resultBean.setCode(0);
            Student student = this.studentService.findStudentByNumber(user.getUserNumber());
            Healthmanagement healthmanagement = this.heathManageService.selectByPrimaryByStudentId(student.getId());
            resultBean.setData(this.setHealthManagementEntry(healthmanagement));
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage()+"查询失败");
        }
        return resultBean;
    }

    private HealthManagementEntry setHealthManagementEntry(Healthmanagement healthmanagement){
        HealthManagementEntry healthManagementEntry = new HealthManagementEntry();
        healthManagementEntry.setBasketball(healthmanagement.getBasketball());
        healthManagementEntry.setFiftymeters(healthmanagement.getFiftymeters());
        healthManagementEntry.setFootball(healthmanagement.getFootball());
        healthManagementEntry.setGrip(healthmanagement.getGrip());
        healthManagementEntry.setId(healthmanagement.getId());
        healthManagementEntry.setKilometre(healthmanagement.getKilometre());
        healthManagementEntry.setLungcapacity(healthmanagement.getLungcapacity());
        healthManagementEntry.setPullUps(healthmanagement.getPullUps());
        healthManagementEntry.setRopeskipping(healthmanagement.getRopeskipping());
        healthManagementEntry.setSittingforwardbending(healthmanagement.getSittingforwardbending());
        healthManagementEntry.setStandinglongjump(healthmanagement.getStandinglongjump());
        healthManagementEntry.setSteptest(healthmanagement.getSteptest());
        healthManagementEntry.setStudentId(healthmanagement.getStudentId());
        healthManagementEntry.setStudentName(this.studentService.findStudentById(healthmanagement.getId()).getStudentName());
        healthManagementEntry.setThrowsolidsphere(healthmanagement.getThrowsolidsphere());
        healthManagementEntry.setVolleyball(healthmanagement.getVolleyball());
        return healthManagementEntry;
    }
}
