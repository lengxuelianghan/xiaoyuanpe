package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Reservation;

import java.util.List;

public interface ReservationService {
    void addReservation(Reservation reservation);

    List<Reservation> findReservationAll();

    Reservation findReservationById(Integer id);

    void ModifyReservation(Reservation reservation);

    void DeleteReservation(Integer id);
}
