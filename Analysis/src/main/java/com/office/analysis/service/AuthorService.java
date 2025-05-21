package com.office.analysis.service;

import com.office.analysis.entity.Author;

public interface AuthorService {
    Author getByInitialAndFullName(String initial, String fullName);

    Author saveOrUpdateAuthor(String initial, String fullName, String affiliation);
}
