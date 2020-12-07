package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/userVenue")
public class UserVenueController {
    @Autowired
    private UserVenueService userVenueService;
    @Autowired
    private VenueService venueService;
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private SportVenueService sportVenueService;
    @Autowired
    private UserService userService;

    private UserVenueEntry changeClass(UserVenue userVenue){
        UserVenueEntry userVenueEntry = new UserVenueEntry();
        userVenueEntry.setId(userVenue.getId());
        userVenueEntry.setSpaceId(userVenue.getSpaceId());
        userVenueEntry.setSpaceName(this.spaceService.findSpaceById(userVenue.getSpaceId()).getSpaceName());
        userVenueEntry.setSportvenueId(userVenue.getSportvenueId());
        userVenueEntry.setSportVenueName(this.sportVenueService.findSportvenueById(userVenue.getSportvenueId()).getSportName());
        userVenueEntry.setStartTime(userVenue.getStartTime());
        userVenueEntry.setEndTime(userVenue.getEndTime());
        userVenueEntry.setVenueId(userVenue.getVenueId());
        userVenueEntry.setVenueName(this.venueService.findVenueById(userVenue.getVenueId()).getVenueName());
        userVenueEntry.setOthers(userVenue.getOthers());
        userVenueEntry.setUserId(userVenue.getUserId());
        userVenueEntry.setUserName(this.userService.findUsersById(userVenue.getUserId()).getUsername());
        return userVenueEntry;
    }

    @GetMapping("/queryReservation/{sportVenueId}")
    public ResultBean queryReservation(Date startDate , Date endDate, @PathVariable Integer sportVenueId){
        ResultBean resultBean = new ResultBean();

        return resultBean;
    }

    @RequestMapping(value = "/addUserVenue", method = RequestMethod.POST)
    public ResultBean addUserVenue(Space space, HttpServletRequest request){
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
