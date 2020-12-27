package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Reservation;

import java.util.List;

public interface ReservationService {
    void addReservation(Reservation reservation, int s, int e);

    List<Reservation> findReservationAll();

    List<Reservation> findReservationAllBySportId(Integer id);

    List<Reservation> findReservationAllBySpaceId(Integer id);

    List<Reservation> findReservationAllBySpaceIdAndDay(Integer id, int day);

    List<Reservation> findReservationAllByDay(int day);

    List<Reservation> findReservationAllByUserId(int userId);

    Reservation findReservationById(Integer id);

    void ModifyReservation(Reservation reservation);

    void DeleteReservation(Integer id);
}
