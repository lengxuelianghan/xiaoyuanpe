package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Sportvenue;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.Venue;
import com.xiaoyuanpe.services.SportVenueService;
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
@RequestMapping("/sportVenue")
public class SportVenueController {
    @Autowired
    private SportVenueService sportVenueService;

    private String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        final SimpleDateFormat sDateFormate = new SimpleDateFormat("yyyymmddHHmmss");  //设置时间格式
        String nowTimeStr = sDateFormate.format(new Date()); // 当前时间
        fileName = fileName.substring(0, index) + "_" + nowTimeStr + fileName.substring(index);
        return fileName;
    }

    /**
     * 获取当前系统路径
     */
    private String getUploadPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath(), "static/upload/");
        if (!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }

    @RequestMapping(value = "/addSportVenueWithImg", method = RequestMethod.POST)
    public ResultBean addSportVenueWithImg(@RequestParam(value="files", required=false) MultipartFile[] files,
                                    Sportvenue venue, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            if (files != null && files.length > 0){
                int i=0;
                String imageName = "";
                for (i=0;i<files.length;i++) {
                    String filepath = getUploadPath();
                    String filename = files[i].getOriginalFilename();
                    String fileName = getFileName(filename);
                    BufferedOutputStream out = new BufferedOutputStream(
                            new FileOutputStream(new File("C:\\nginx\\img\\" + fileName)));
                    System.out.println("C:\\nginx\\img\\" + fileName);
                    if (i<files.length)
                        imageName+= "C:\\nginx\\img\\" + fileName+",";
                    else
                        imageName+= "C:\\nginx\\img\\" + fileName;
                    out.write(files[i].getBytes());
                    out.flush();
                    out.close();
                }
                venue.setImgs(imageName);
            }
            //venue.setSchoolId(user.getSchoolId());
            this.sportVenueService.addSportvenue(venue);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg(e.getMessage());
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/addSportVenue", method = RequestMethod.POST)
    public ResultBean addSportVenue(Sportvenue venue, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            this.sportVenueService.addSportvenue(venue);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg(e.getMessage());
            resultBean.setCode(1);
        }
        return resultBean;
    }
    @RequestMapping(value = "/updateSportVenue", method = RequestMethod.POST)
    public ResultBean updateSportVenue(@RequestBody Sportvenue venue){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportVenueService.ModifySportvenue(venue);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("更新失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/querySportVenueById/{id}")
    public ResultBean querySportVenueById(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportVenueService.findSportvenueById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查找失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/querySportVenueAll")
    public ResultBean querySportVenueAll(){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportVenueService.findSportvenueAll());
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查找失败");
        }
        return resultBean;
    }
    @RequestMapping(value = "/deleteSportVenue", method = RequestMethod.POST)
    public ResultBean updateSportVenue(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportVenueService.DeleteSportvenueList(ids);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("删除失败");
        }
        return resultBean;
    }
}
