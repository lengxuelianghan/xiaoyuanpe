package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.VideoMapper;
import com.xiaoyuanpe.pojo.Video;
import com.xiaoyuanpe.pojo.VideoExample;
import com.xiaoyuanpe.units.Pager;
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
    public Pager<Video> findVideoAll(Integer current, Integer pageSize) {
        VideoExample videoExample = new VideoExample();
        List<Video> videos = this.videoMapper.selectByExample(videoExample);
        int totalNum = (int)this.videoMapper.countByExample(videoExample);
        Pager<Video> pager = new Pager<>();
        pager.setCurrentPage(current);
        pager.setPageSize(pageSize);
        pager.setRecordTotal(totalNum);
        if (current * pageSize < totalNum) {
            pager.setContent(videos.subList((current - 1) * pageSize, current * pageSize));
        }
        else {
            if ((current - 1) * pageSize <= totalNum){
                pager.setContent(videos.subList((current - 1) * pageSize, totalNum));
            }
            else {
                pager.setContent(null);
            }

        }
        return pager;
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

