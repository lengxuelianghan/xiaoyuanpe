package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Reservation;
import com.xiaoyuanpe.pojo.ReservationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservationMapper {
    long countByExample(ReservationExample example);

    int deleteByExample(ReservationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reservation record);

    int insertSelective(Reservation record);

    List<Reservation> selectByExample(ReservationExample example);

    Reservation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reservation record, @Param("example") ReservationExample example);

    int updateByExample(@Param("record") Reservation record, @Param("example") ReservationExample example);

    int updateByPrimaryKeySelective(Reservation record);

    int updateByPrimaryKey(Reservation record);
}