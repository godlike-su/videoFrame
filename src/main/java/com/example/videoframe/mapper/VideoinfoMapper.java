package com.example.videoframe.mapper;

import com.example.videoframe.entity.Videoinfo;
import com.example.videoframe.mapper.example.VideoinfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VideoinfoMapper {
    long countByExample(VideoinfoExample example);

    int deleteByExample(VideoinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Videoinfo record);

    int insertSelective(Videoinfo record);

    List<Videoinfo> selectByExample(VideoinfoExample example);

    Videoinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Videoinfo record, @Param("example") VideoinfoExample example);

    int updateByExample(@Param("record") Videoinfo record, @Param("example") VideoinfoExample example);

    int updateByPrimaryKeySelective(Videoinfo record);

    int updateByPrimaryKey(Videoinfo record);
}