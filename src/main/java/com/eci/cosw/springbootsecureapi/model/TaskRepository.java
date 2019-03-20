package com.eci.cosw.springbootsecureapi.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByOwner(Long owner);

    List<Task> findByResponsible(Long responsible);

    List<Task> findByDueDate(Date dueDate);

    List<Task> findByStatus(String status);

    Optional<Task> findById(String id);

}
