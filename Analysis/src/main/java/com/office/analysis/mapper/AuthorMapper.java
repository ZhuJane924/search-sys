package com.office.analysis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.office.analysis.entity.Author;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorMapper extends BaseMapper<Author> {
}
