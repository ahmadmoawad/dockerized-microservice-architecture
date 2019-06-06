package com.alten.service.impl;

import com.alten.dao.UserDao;
import com.alten.entity.User;
import com.alten.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return (List<User>) userDao.findAll();
    }
}
