package com.talissonmelo.microserviceuser.service.impl;

import com.talissonmelo.microserviceuser.model.User;
import com.talissonmelo.microserviceuser.repository.UsersRepository;
import com.talissonmelo.microserviceuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user){
        log.info("Encodando senha e salvando usuário!.");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        log.info("Buscando usuário por username");
        return  usersRepository.findByUserUsername(username).orElse(null);
    }

    @Override
    public List<String> findByIdList(List<Long> ids) {
        return usersRepository.findByIdList(ids);
    }


}
