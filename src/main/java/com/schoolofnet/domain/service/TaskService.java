package com.schoolofnet.domain.service;

import com.schoolofnet.domain.entity.Task;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Leonan-Mac on 7/25/16.
 */
public interface TaskService {

    Iterable<Task> findAll();
    Task create(String name);
    Task findOne(Integer id);
    Task update(Task task);
    void remove(Task task);
}
