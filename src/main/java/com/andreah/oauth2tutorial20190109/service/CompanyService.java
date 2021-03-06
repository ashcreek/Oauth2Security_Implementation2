package com.andreah.oauth2tutorial20190109.service;

import com.andreah.oauth2tutorial20190109.data.MySqlCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {


    @Autowired
    private MySqlCompanyRepository companyRepository;

    //securing access to company objects in service layer so transactional and preauthorize are needed
    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('COMPANY_READER')")
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

}
















