package com.airlines.service.model.pojo;

import com.airlines.service.enums.GenderEnum;

public class Gender {

    private Long id;

    private GenderEnum name;

    public Gender() {
    }

    public Gender(final Long id, final GenderEnum gender) {
        this.id = id;
        this.name = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GenderEnum getName() {
        return name;
    }

    public void setName(GenderEnum name) {
        this.name = name;
    }
}
