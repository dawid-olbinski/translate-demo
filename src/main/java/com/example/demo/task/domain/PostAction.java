package com.example.demo.task.domain;

import lombok.Data;

@Data
public class PostAction {

    private PostActionType type;
    private String value;
    private Boolean fillByUser;

}
