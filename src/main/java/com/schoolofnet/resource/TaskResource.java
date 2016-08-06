package com.schoolofnet.resource;

import com.schoolofnet.domain.entity.Task;
import com.schoolofnet.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class TaskResource {

    @Autowired
    private TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(path = "/tasks", method = RequestMethod.GET)
    @Transactional
    public String findAll(Map<String, Object> model) {
        Iterable<Task> tasks = taskService.findAll();

        model.put("tasks", tasks);

        return "index";
    }

    @RequestMapping(path = "/tasks/new", method = RequestMethod.GET)
    public String newTask() {
        return "new";
    }

    @RequestMapping(path = "/tasks/edit/{id}", method = RequestMethod.GET)
    public String editTask(@PathVariable Integer id, Map<String, Object> model) {
        Task task = taskService.findOne(id);

        model.put("task", task);

        return "edit";
    }

    @RequestMapping(path = "/tasks", method = RequestMethod.POST)
    public String create(String name) {
        Task task = taskService.create(name);

        return "redirect:tasks";
    }

    @RequestMapping(path = "/tasks/edit/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Integer id, String name) {
        Task task = taskService.findOne(id);

        task.setName(name);
        taskService.update(task);

        return "redirect:/tasks";
    }

    @RequestMapping(path = "/tasks/remove/{id}", method = RequestMethod.POST)
    public String remove(@PathVariable Integer id) {
        Task task = taskService.findOne(id);

        taskService.remove(task);

        return "redirect:/tasks";
    }

}
