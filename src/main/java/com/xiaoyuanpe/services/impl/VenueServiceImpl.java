package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.VenueMapper;
import com.xiaoyuanpe.pojo.Venue;
import com.xiaoyuanpe.pojo.VenueExample;
import com.xiaoyuanpe.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {

    @Resource
    private VenueMapper venueMapper;

    @Override
    public void addVenue(Venue venue) {
        this.venueMapper.insert(venue);
    }

    @Override
    public List<Venue> findVenueAll() {
        return this.venueMapper.selectByExample(new VenueExample());
    }

    @Override
    public Venue findVenueById(Integer id) {
        return this.venueMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyVenue(Venue venue) {
        this.venueMapper.updateByPrimaryKey(venue);
    }

    @Override
    public void DeleteVenue(Integer id) {
        this.venueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void DeleteVenueList(List<Integer> ids) {
        for (Integer id : ids) {
            this.venueMapper.deleteByPrimaryKey(id);
        }
    }
}
