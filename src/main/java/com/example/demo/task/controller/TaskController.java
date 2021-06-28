package com.example.demo.task.controller;

import com.example.demo.task.domain.TaskDto;
import com.example.demo.task.domain.entity.Task;
import com.example.demo.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/saveTask")
    public void saveTask(@RequestBody TaskDto task){
        this.taskService.save(task);
    }

    @GetMapping("/get/{id}")
    public Task saveTask(@PathVariable Long id){
        return this.taskService.getById(id);
    }
}
