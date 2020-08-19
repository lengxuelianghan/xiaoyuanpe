package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.VideoMapper;
import com.xiaoyuanpe.pojo.Video;
import com.xiaoyuanpe.pojo.VideoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public void addVideo(Video video) {
        this.videoMapper.insert(video);
    }

    @Override
    public List<Video> findVideoAll() {
        VideoExample videoExample = new VideoExample();
        return this.videoMapper.selectByExample(videoExample);
    }

    @Override
    public Video findVideoById(Integer id) {
        return this.videoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyVideo(Video video) {
        this.videoMapper.updateByPrimaryKey(video);
    }

    @Override
    public void DeleteVideo(Integer id) {
        this.videoMapper.deleteByPrimaryKey(id);
    }
}

