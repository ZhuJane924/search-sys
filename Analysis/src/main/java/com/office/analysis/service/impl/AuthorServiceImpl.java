package com.office.analysis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.office.analysis.entity.Author;
import com.office.analysis.mapper.AuthorMapper;
import com.office.analysis.service.AuthorService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Resource
    private AuthorMapper authorMapper;

    @Override
    public Author getByInitialAndFullName(String initial, String fullName) {
        return authorMapper.selectOne(new QueryWrapper<Author>()
                .eq("initial", initial)
                .eq("full_name", fullName));
    }

    @Override
    public Author saveOrUpdateAuthor(String initial, String fullName, String affiliation) {
        Author author = getByInitialAndFullName(initial, fullName);
        if (author == null) {
            author = new Author();
            author.setInitial(initial);
            author.setFullName(fullName);
            author.setAffiliation(affiliation);
            authorMapper.insert(author);
        }
        return author;
    }
}
