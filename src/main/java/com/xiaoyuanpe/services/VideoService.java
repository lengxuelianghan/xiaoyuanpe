package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Video;
import com.xiaoyuanpe.units.Pager;

import java.util.List;

public interface VideoService {
    void addVideo(Video video);

    Pager<Video> findVideoAll(Integer current, Integer pageSize);

    Video findVideoById(Integer id);

    void ModifyVideo(Video video);

    void DeleteVideo(Integer id);

    void DeleteVideoList(List<Integer> ids);
}
