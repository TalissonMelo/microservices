package com.talissonmelo.microserviceuser.service;

import com.talissonmelo.microserviceuser.model.User;

import java.util.List;

public interface UserService  {

    public User save(User user);

    public User findByUsername(String username);

    public List<String> findByIdList(List<Long> ids);
}
