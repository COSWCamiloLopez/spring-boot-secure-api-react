package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class TaskServiceImpl implements TaskService {

    private List<Task> tasksList = new ArrayList<>();

    @Autowired
    public TaskServiceImpl() {
    }

    @Override
    public List<Task> geTasksList() {
        return tasksList;
    }

    @Override
    public Task getTaskById(String id) {
        Task taskToReturn = null;
        for (Task x : tasksList) {
            if (x.getId().equals(id)) {
                taskToReturn = x;
            }
        }
        return taskToReturn;
    }

    @Override
    public List<Task> getTasksByUserId(Long userId) {

        List<Task> listToReturn = new ArrayList<>();
        for (Task x : tasksList) {
            if (x.getOwner().equals(userId)) {
                listToReturn.add(x);
            }
        }
        return listToReturn;
    }

    @Override
    public void assignedTaskToUser(String taskId, User user) {
        for (Task x : tasksList) {
            if (x.getId().equals(taskId)) {
                x.setResponsible(user.getId());
            }
        }
    }

    @Override
    public void removeTask(String taskId) {
        tasksList.remove(getTaskById(taskId));
    }

    @Override
    public void updateTask(Task task) {
        if (tasksList.contains(getTaskById(task.getId()))) {
            tasksList.remove(getTaskById(task.getId()));
            tasksList.add(task);
        } else {
            System.out.println("This task doesn't exists");
        }
    }

    @Override
    public void createNewTask(Task task) {
        tasksList.add(task);
    }
}
