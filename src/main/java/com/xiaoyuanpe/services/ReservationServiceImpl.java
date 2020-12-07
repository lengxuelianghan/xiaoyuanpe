package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.ReservationMapper;
import com.xiaoyuanpe.pojo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;
    @Override
    public void addReservation(Reservation reservation) {
        for (int i=0;i<12;i++){

            reservation.setStarttime();
            reservation.setEndtime();
            this.reservationMapper.insert();
        }
    }

    @Override
    public List<Reservation> findReservationAll() {
        return null;
    }

    @Override
    public Reservation findReservationById(Integer id) {
        return null;
    }

    @Override
    public void ModifyReservation(Reservation reservation) {

    }

    @Override
    public void DeleteReservation(Integer id) {

    }
}
