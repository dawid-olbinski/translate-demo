package com.example.demo.task.domain.entity;

import com.example.demo.task.domain.TaskData;
import com.example.demo.translation.domain.entity.Translation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

@Entity
@Data
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class)
})
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private TaskData data;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Translation name;
}
