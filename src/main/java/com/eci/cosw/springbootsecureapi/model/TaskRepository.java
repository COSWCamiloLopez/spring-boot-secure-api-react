package com.eci.cosw.springbootsecureapi.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
