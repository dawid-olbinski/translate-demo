package com.example.demo.task.domain;

import lombok.Data;

import java.util.List;

@Data
public class TypeOptions {

    private String name;

    private List<PostAction> postActions;

}
