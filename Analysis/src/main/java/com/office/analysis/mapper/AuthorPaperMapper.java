package com.office.analysis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

@Mapper
public interface AuthorPaperMapper {

    @Select("SELECT COUNT(1) FROM author_paper WHERE author_id = #{authorId} AND pubmed_id = #{paperId}")
    int countByAuthorIdAndPaperId(@Param("authorId") Long authorId, @Param("paperId") Long paperId);

    @Insert("INSERT INTO author_paper(author_id, pubmed_id) VALUES(#{authorId}, #{paperId})")
    void insertRelation(@Param("authorId") Long authorId, @Param("paperId") Long paperId);
}
