package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Video;

import java.util.List;

public interface VideoService {
    void addVideo(Video video);

    List<Video> findVideoAll();

    Video findVideoById(Integer id);

    void ModifyVideo(Video video);

    void DeleteVideo(Integer id);
}
