package com.example.videoframe.mapper;

import com.example.videoframe.entity.Photoinfo;
import com.example.videoframe.mapper.example.PhotoinfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PhotoinfoMapper {
    long countByExample(PhotoinfoExample example);

    int deleteByExample(PhotoinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Photoinfo record);

    int insertSelective(Photoinfo record);

    List<Photoinfo> selectByExample(PhotoinfoExample example);

    List<Photoinfo> selectByAtt(Photoinfo example);

    Photoinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Photoinfo record, @Param("example") PhotoinfoExample example);

    int updateByExample(@Param("record") Photoinfo record, @Param("example") PhotoinfoExample example);

    int updateByPrimaryKeySelective(Photoinfo record);

    int updateByPrimaryKey(Photoinfo record);
}