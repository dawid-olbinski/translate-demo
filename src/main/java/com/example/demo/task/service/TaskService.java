package com.example.demo.task.service;

import com.example.demo.infrastructure.RequestContext;
import com.example.demo.task.domain.TaskDto;
import com.example.demo.task.domain.entity.Task;
import com.example.demo.task.repository.TaskRepository;
import com.example.demo.translation.TranslationsUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final RequestContext requestContext;

    public void save(TaskDto taskDto) {
            Task task = new Task();


            task.setData(taskDto.getData());
        TranslationsUtils.createTranslations(taskDto, task);
            taskRepository.save(task);
    }

    public Task getById(Long id){
        Task task = taskRepository.findById(id).orElseThrow();
        return task;
    }
}
