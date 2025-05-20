package com.office.analysis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("author_paper")
public class AuthorPaper {

    @TableId(type = IdType.AUTO)
    private int id;

    private int authorId;    // authors表的id
    private int paperId;     // papers表的id（这里假设paper主键是Long类型）
}
