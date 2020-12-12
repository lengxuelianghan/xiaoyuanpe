package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.ReservationMapper;
import com.xiaoyuanpe.pojo.Reservation;
import com.xiaoyuanpe.pojo.ReservationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;
    @Override
    public void addReservation(Reservation reservation) {
        for (int i=5;i<23;i++){
            reservation.setHourIndex(i);
            this.reservationMapper.insert(reservation);
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
