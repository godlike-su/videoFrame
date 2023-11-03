package com.example.videoframe.mapper;

import com.example.videoframe.entity.Fileupload;
import com.example.videoframe.mapper.example.FileuploadExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileuploadMapper {
    long countByExample(FileuploadExample example);

    int deleteByExample(FileuploadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Fileupload record);

    int insertSelective(Fileupload record);

    List<Fileupload> selectByExample(FileuploadExample example);

    Fileupload selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Fileupload record, @Param("example") FileuploadExample example);

    int updateByExample(@Param("record") Fileupload record, @Param("example") FileuploadExample example);

    int updateByPrimaryKeySelective(Fileupload record);

    int updateByPrimaryKey(Fileupload record);
}