package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @Autowired
    private ReservationService reservationService;

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
    //查询当前时间范围可预约场地
    @PostMapping("/queryReservation/{sportVenueId}")
    public ResultBean queryReservation(@RequestParam Date startDate , @RequestParam Date endDate,
                                       @PathVariable Integer sportVenueId){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(1);
            int day = startDate.getDay();
            int startHour = startDate.getHours();
            int endHour = endDate.getHours();
            List<Space> spaces = this.spaceService.findSpaceBySportId(sportVenueId);
            List<Space> spaceList = new ArrayList<>();
            for (Space space : spaces) {
                List<Reservation> reservations = this.reservationService.findReservationAllBySpaceId(space.getId());
                int b = 0;
                for (Reservation reservation : reservations) {
                    if (reservation.getHourIndex() >= startHour && reservation.getHourIndex() < endHour && reservation.getStatus() == 1) {
                        b = 1;
                    }
                }
                if (b == 0) {
                    resultBean.setCode(0);
                    spaceList.add(space);
                    resultBean.setData(spaceList);
                }
            }
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查询失败");
        }
        return resultBean;
    }
    // 预约场馆
    @RequestMapping(value = "/addUserVenue", method = RequestMethod.POST)
    public ResultBean addUserVenue(@RequestBody Space space, Date startTime, Date endTime,
                                   HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            UserVenue userVenue = new UserVenue();
            userVenue.setEndTime(endTime);
            userVenue.setStartTime(startTime);
            userVenue.setSpaceId(space.getId());
            userVenue.setSportvenueId(space.getSportvenueId());
            userVenue.setUserId(user.getId());
            this.userVenueService.addUserVenue(userVenue);
            int sTime = startTime.getHours();
            int eTime = endTime.getHours();
            List<Reservation> reservationAllBySpaceId =
                    this.reservationService.findReservationAllBySpaceId(space.getId());
            for (Reservation reservation: reservationAllBySpaceId) {
                if ((reservation.getHourIndex() >= sTime) && (reservation.getHourIndex() < eTime)) {
                    reservation.setStatus(1);
                    this.reservationService.ModifyReservation(reservation);
                }
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg(e.getMessage());
            resultBean.setCode(1);
        }
        return resultBean;
    }
    //更新信息
    @RequestMapping(value = "/updateUserVenue", method = RequestMethod.POST)
    public ResultBean updateSpace(@RequestBody UserVenue userVenue){
        ResultBean resultBean = new ResultBean();
        try {
            this.userVenueService.ModifyUserVenue(userVenue);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("更新失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryUserVenueAll")
    public ResultBean queryUserVenueAll(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            List<UserVenue> userVenuesAll = this.userVenueService.findUserVenueAll();
            List<UserVenueEntry> userVenueByUser = new ArrayList<>();
            for (UserVenue userVenue: userVenuesAll){
                if (userVenue.getUserId()==user.getId()){
                    userVenueByUser.add(changeClass(userVenue));
                }
            }
            resultBean.setData(userVenueByUser);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查找失败");
        }
        return resultBean;
    }
    //取消预约
    @RequestMapping(value = "/deleteUserVenue", method = RequestMethod.POST)
    public ResultBean updateUserVenue(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            for (Integer id: ids) {
                this.userVenueService.DeleteUserVenue(id);
                UserVenue userVenue = this.userVenueService.findUserVenueById(id);
                int sTime = userVenue.getStartTime().getHours();
                int eTime = userVenue.getEndTime().getHours();
                List<Reservation> reservationAllBySpaceId =
                        this.reservationService.findReservationAllBySpaceId(userVenue.getSpaceId());
                for (Reservation reservation : reservationAllBySpaceId) {
                    if ((reservation.getHourIndex() >= sTime) && (reservation.getHourIndex() < eTime)) {
                        reservation.setStatus(0);
                        this.reservationService.ModifyReservation(reservation);
                    }
                }
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg(e.getMessage());
            resultBean.setCode(1);
        }
        return resultBean;
    }
}
