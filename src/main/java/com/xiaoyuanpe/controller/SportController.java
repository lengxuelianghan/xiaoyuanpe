package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.SportStud;
import com.xiaoyuanpe.pojo.Sports;
import com.xiaoyuanpe.services.SportService;
import com.xiaoyuanpe.services.SportStudService;
import com.xiaoyuanpe.units.HasRole;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {
    @Autowired
    private SportService sportService;
    @Autowired
    private SportStudService sportStudService;

    @PostMapping("/addSport")
    public ResultBean addSport(@RequestBody Sports sports){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportService.addSports(sports);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动信息添加错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping("/querySport/{id}")
    public ResultBean querySport(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportService.findSportsById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动查找错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping("/querySportList/{current}/{pageSize}")
    public ResultBean querySportList(@PathVariable Integer current, @PathVariable Integer pageSize){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportService.findSportsAll(current, pageSize));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动列表查找错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateSport", method = RequestMethod.POST)
    public ResultBean updateSport(@RequestBody Sports sports){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportService.ModifySports(sports);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动修改错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/deleteSport", method = RequestMethod.POST)
    public ResultBean deleteSport(@RequestBody List ids){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportService.DeleteSportsList(ids);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动修改错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }
    //指定早操签到员
    @RequestMapping("/designateChecker/{sportId}/{studentId}")
    public ResultBean designateChecker(@PathVariable Integer sportId,@PathVariable Integer studentId){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("teacher","classmanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                SportStud sportStud = new SportStud();
                sportStud.setStudentId(studentId);
                sportStud.setSportId(sportId);
                sportStud.setCharacters("签到员");
                this.sportStudService.addSportStud(sportStud);
            }catch (Exception e){
                resultBean.setMsg("设置失败"+e.getMessage());
                resultBean.setCode(1);
            }
        }
        return resultBean;
    }
}
