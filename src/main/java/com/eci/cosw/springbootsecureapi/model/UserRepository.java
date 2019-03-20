package com.eci.cosw.springbootsecureapi.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findById(Long id);

    User findByUsername(String username);

    User findByEmail(String email);

}
