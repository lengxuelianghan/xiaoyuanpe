package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Venue;

import java.util.List;

public interface VenueService {
    void addVenue(Venue venue);

    List<Venue> findVenueAll();

    Venue findVenueById(Integer id);

    void ModifyVenue(Venue venue);

    void DeleteVenue(Integer id);

    void DeleteVenueList(List<Integer> ids);
}
