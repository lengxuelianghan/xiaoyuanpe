package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.ReservationMapper;
import com.xiaoyuanpe.mapper.VenueMapper;
import com.xiaoyuanpe.pojo.Reservation;
import com.xiaoyuanpe.pojo.ReservationExample;
import com.xiaoyuanpe.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Resource
    private ReservationMapper reservationMapper;
    @Override
    public void addReservation(Reservation reservation,int s, int e) {
        for (int j=0;j<7;j++) {
            for (int i = s; i <= e; i++) {
                reservation.setDayIndex(j);
                reservation.setHourIndex(i);
                this.reservationMapper.insert(reservation);
            }
        }
    }

    @Override
    public List<Reservation> findReservationAll() {
        return this.reservationMapper.selectByExample(new ReservationExample());
    }

    @Override
    public List<Reservation> findReservationAllBySportId(Integer id) {
        List<Reservation> reservations = this.reservationMapper.selectByExample(new ReservationExample());
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation : reservations){
            if(reservation.getSportvenueId()==id){
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }

    @Override
    public List<Reservation> findReservationAllBySpaceId(Integer id) {
        List<Reservation> reservations = this.reservationMapper.selectByExample(new ReservationExample());
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation : reservations){
            if(reservation.getSpaceId()==id){
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }

    @Override
    public List<Reservation> findReservationAllBySpaceIdAndDay(Integer id, int day) {
        List<Reservation> reservations = this.reservationMapper.selectByExample(new ReservationExample());
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation : reservations){
            if(reservation.getSpaceId()==id && reservation.getDayIndex()==day){
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }

    @Override
    public List<Reservation> findReservationAllByDay(int day) {
        List<Reservation> reservations = this.reservationMapper.selectByExample(new ReservationExample());
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation : reservations){
            if(reservation.getDayIndex()==day){
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }

    @Override
    public List<Reservation> findReservationAllByUserId(int userId) {
        List<Reservation> reservations = this.reservationMapper.selectByExample(new ReservationExample());
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation : reservations){
            if(reservation.getUserId()==userId){
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }

    @Override
    public Reservation findReservationById(Integer id) {
        return  this.reservationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyReservation(Reservation reservation) {
        this.reservationMapper.updateByPrimaryKey(reservation);
    }

    @Override
    public void DeleteReservation(Integer id) {
        this.reservationMapper.deleteByPrimaryKey(id);
    }
}
