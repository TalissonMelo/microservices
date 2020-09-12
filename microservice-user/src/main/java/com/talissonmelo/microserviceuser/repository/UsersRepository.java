package com.talissonmelo.microserviceuser.repository;

import com.talissonmelo.microserviceuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("select u.name from User u where u.id in :ids")
    List<String> findByIdList(@Param("ids") List<Long> ids);
}
