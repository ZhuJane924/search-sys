package com.office.analysis.service.impl;

import com.office.analysis.mapper.AuthorPaperMapper;
import com.office.analysis.service.AuthorPaperService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

@Service
public class AuthorPaperServiceImpl implements AuthorPaperService {

    @Resource
    private AuthorPaperMapper authorPaperMapper;

    @Override
    public void saveRelation(Long authorId, Long paperId) {
        if (authorId == null || paperId == null) {
            return;
        }
        int count = authorPaperMapper.countByAuthorIdAndPaperId(authorId, paperId);
        if (count == 0) {
            authorPaperMapper.insertRelation(authorId, paperId);
        }
    }
}
