package com.example.demo.task.domain;

import lombok.Data;

import java.util.List;

@Data
public class TaskData {

    private String type;

    private List<TypeOptions> typeOptions;

}
