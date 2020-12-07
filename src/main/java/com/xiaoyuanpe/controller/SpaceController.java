package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.mapper.SpaceMapper;
import com.xiaoyuanpe.pojo.Space;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.Venue;
import com.xiaoyuanpe.services.SpaceService;
import com.xiaoyuanpe.services.VenueService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/space")
public class SpaceController {
    @Autowired
    private SpaceService spaceService;

    @RequestMapping(value = "/addSpace", method = RequestMethod.POST)
    public ResultBean addSpace(Space space, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            this.spaceService.addSpace(space);

            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg(e.getMessage());
            resultBean.setCode(1);
        }
        return resultBean;
    }
    @RequestMapping(value = "/updateSpace", method = RequestMethod.POST)
    public ResultBean updateSpace(@RequestBody Space space){
        ResultBean resultBean = new ResultBean();
        try {
            this.spaceService.ModifySpace(space);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("更新失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/querySpaceById/{id}")
    public ResultBean querySpaceById(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.spaceService.findSpaceById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查找失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/querySpaceAll")
    public ResultBean querySpaceAll(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.spaceService.findSpaceAll());
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查找失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/deleteSpace", method = RequestMethod.POST)
    public ResultBean updateSpace(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            this.spaceService.DeleteSpaceList(ids);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("删除失败");
        }
        return resultBean;
    }
}
