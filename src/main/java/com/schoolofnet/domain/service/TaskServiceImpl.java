package com.schoolofnet.domain.service;

import com.schoolofnet.domain.entity.Task;
import com.schoolofnet.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public Iterable<Task> findAll() {
        return taskRepository.findAllNativeQuery();
    }

    public Task create(String name) {
        Task task = new Task(name);

        taskRepository.save(task);

        return task;
    }

    public Task findOne(Integer id) {
        return taskRepository.findOne(id);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

    public void remove(Task task) {
        taskRepository.delete(task);
    }
}
