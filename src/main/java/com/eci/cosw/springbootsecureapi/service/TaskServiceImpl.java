package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.model.TaskRepository;
import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    public TaskServiceImpl() {
    }

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> geTasksList() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(String id) {
        return null;
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        return taskRepository.findByOwner(userId);
    }

    @Override
    public void assignedTaskToUser(String taskId, User user) {
        for (Task x : taskRepository.findAll()) {
            if (x.getId().equals(taskId)) {
                x.setResponsible(user.getFirstName());
            }
        }
    }

    @Override
    public void removeTask(String taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void updateTask(Task task) {
        try{
            taskRepository.deleteById(task.getId());
            taskRepository.save(task);
        } catch (Exception ex) {
            System.out.println("Error updating task: " + task.getId());
        }
    }

    @Override
    public void createNewTask(Task task) {
        taskRepository.save(task);
    }
}
