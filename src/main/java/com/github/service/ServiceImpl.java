package com.github.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by langshiquan on 2018/8/25.
 */
@Service("serviceImpl")
public class ServiceImpl {

    @Autowired
    private Dao dao;

    public Dao getDao() {
        return dao;
    }


    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
