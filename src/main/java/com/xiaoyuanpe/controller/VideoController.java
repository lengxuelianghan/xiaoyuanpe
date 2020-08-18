package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Video;
import com.xiaoyuanpe.services.VideoService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @PostMapping("/addVideo")
    public ResultBean addVideo(@RequestBody Video video){
        ResultBean resultBean = new ResultBean();
        try {
            this.videoService.addVideo(video);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("视频添加失败");
        }
        return resultBean;
    }

    @RequestMapping("/queryVideo/{id}")
    public ResultBean queryVideo(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.videoService.findVideoById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("视频查找失败");
        }
        return resultBean;
    }

    @RequestMapping("/queryVideoList")
    public ResultBean queryVideoList(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.videoService.findVideoAll());
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("视频列表查找失败");
        }
        return resultBean;
    }

    @RequestMapping("/updateVideo")
    public ResultBean updateVideo(@RequestBody Video video){
        ResultBean resultBean = new ResultBean();
        try {
            this.videoService.ModifyVideo(video);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("视频修改失败");
        }
        return resultBean;
    }

    @RequestMapping("/deleteVideo/{id}")
    public ResultBean deleteVideo(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            this.videoService.DeleteVideo(id);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("视频删除失败");
        }
        return resultBean;
    }
}
