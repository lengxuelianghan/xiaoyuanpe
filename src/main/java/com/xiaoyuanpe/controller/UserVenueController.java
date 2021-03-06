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
    @PostMapping("/queryReservationToSpace/{sportVenueId}")
    public ResultBean queryReservationToSpace(@RequestParam Date startDate , @RequestParam Date endDate,
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
                    spaceList.add(space);
                }
            }
            resultBean.setCode(0);
            resultBean.setData(spaceList);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查询失败");
        }
        return resultBean;
    }
    //查询场地和时间预约信息
    @PostMapping("/queryReservation/{sportVenueId}")
    public ResultBean queryReservation(@RequestParam Date queryDate, @PathVariable Integer sportVenueId){
        int dayInWeek = queryDate.getDay();
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(1);
            String days[] = this.venueService.findVenueById(this.sportVenueService.findSportvenueById(sportVenueId).getVenueId()).
                    getOpeningTime().split("-");
            resultBean.setMsg("dayInWeek"+dayInWeek);
            int startHour = Integer.parseInt(days[0]);
            int endHour = Integer.parseInt(days[1]);
            List<Space> spaces = this.spaceService.findSpaceBySportId(sportVenueId);
            List<Space> spaceList = new ArrayList<>();
            List<SpaceTime> spaceTimes = new ArrayList<>();
            for (Space space : spaces) {
                List<Reservation> reservations = this.reservationService.findReservationAllBySpaceIdAndDay(space.getId(),dayInWeek);
                int b = 0;
                SpaceTime spaceTime = new SpaceTime();
                spaceTime.setSpaceId(space.getId());
                spaceTime.setSpaceName(space.getSpaceName());
                for (Reservation reservation : reservations) {
                    for (int i=startHour; i<endHour; i++) {
                        if (reservation.getHourIndex() >= i && reservation.getHourIndex() < i+1) {
                            if (reservation.getStatus() == 1){
                                continue;
                            }
                            else {
                                //spaceTime.setSpaceStatus("可预约");
                                if (spaceTime.getDataList()==null){
                                    spaceTime.setDataList(new ArrayList<>());
                                }
                                spaceTime.getDataList().add(i+"");
                            }
                        }
                    }
                }
                if (spaceTime.getDataList()!=null){
                    spaceTimes.add(spaceTime);
                }
            }
            resultBean.setCode(0);
            resultBean.setData(spaceTimes);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查询失败");
        }
        return resultBean;
    }
    // 预约场馆,修改后
    @RequestMapping(value = "/addUserVenues", method = RequestMethod.POST)
    public ResultBean addUserVenues(@RequestBody List<SpaceTime> spaceTimes, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(1);
            for (SpaceTime spaceTime: spaceTimes) {
                int dayInWeek = spaceTime.getDate().getDay();
                Space space = this.spaceService.findSpaceById(spaceTime.getSpaceId());
                UserVenue userVenue = new UserVenue();
                //userVenue.setEndTime(endDate);
                //userVenue.setStartTime(startDate);
                userVenue.setSpaceId(space.getId());
                userVenue.setSportvenueId(space.getSportvenueId());
                userVenue.setUserId(user.getId());
                this.userVenueService.addUserVenue(userVenue);
                for (String s:spaceTime.getDataList()) {
                    int sTime = Integer.parseInt(s);//startDate.getHours();
                    int eTime = sTime+1;
                    List<Reservation> reservationAllBySpaceId =
                            this.reservationService.findReservationAllBySpaceIdAndDay(space.getId(), dayInWeek);
                    for (Reservation reservation : reservationAllBySpaceId) {
                        if ((reservation.getHourIndex() >= sTime) && (reservation.getHourIndex() < eTime) && reservation.getStatus()==0) {
                            reservation.setStatus(1);
                            reservation.setUserId(user.getId());
                            this.reservationService.ModifyReservation(reservation);
                        }
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
    // 预约场馆
    @RequestMapping(value = "/addUserVenue/{spaceId}", method = RequestMethod.POST)
    public ResultBean addUserVenue(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
                                   @PathVariable Integer spaceId, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            Space space = this.spaceService.findSpaceById(spaceId);
            UserVenue userVenue = new UserVenue();
            userVenue.setEndTime(endDate);
            userVenue.setStartTime(startDate);
            userVenue.setSpaceId(space.getId());
            userVenue.setSportvenueId(space.getSportvenueId());
            userVenue.setUserId(user.getId());
            this.userVenueService.addUserVenue(userVenue);
            int sTime = startDate.getHours();
            int eTime = endDate.getHours();
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
    //查询预约场馆
//    @RequestMapping(value = "/queryReservation")
//    public ResultBean queryReservation(HttpSession session){
//        User user = (User) session.getAttribute("user");
//        ResultBean resultBean = new ResultBean();
//        List<SpaceTime> spaceTimes = new ArrayList<>();
//        try {
//            this.reservationService.findReservationAllByUserId(user.getId());
//            for ()
//            resultBean.setCode(0);
//        }catch (Exception e){
//            resultBean.setCode(1);
//            resultBean.setMsg("查找失败");
//        }
//        return resultBean;
//    }
    //取消预约
    @RequestMapping(value = "/deleteUserVenue", method = RequestMethod.POST)
    public ResultBean updateUserVenue(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            for (Integer id: ids) {
                Reservation reservation = this.reservationService.findReservationById(id);
                if (reservation.getStatus()==1) {
                    reservation.setStatus(0);
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
}
