package com.airlines.service.model.entity;

import com.airlines.service.enums.GenderEnum;
import com.airlines.service.model.pojo.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "gender")
public class GenderEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Enumerated(EnumType.STRING)
    private GenderEnum name;

    public GenderEntity() {
    }

    public GenderEntity(final Long id) {
        this.id = id;
    }

    public GenderEntity(final Gender gender) {
        this.id = gender.getId();
        this.name = gender.getName();
    }

    public GenderEntity(final GenderEnum gender) {
        this.name = gender;

        switch (gender) {
            case MALE:
                this.id = 1L;
                break;
            case FEMALE:
                this.id = 2L;
                break;
            case DIVERSE:
                this.id = 3L;
                break;
            default:
                throw new IllegalArgumentException(String.format("Gender '%s' not supported.", gender));
        }

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

    public Gender toGender() {

        final Gender result = new Gender();

        result.setId(getId());
        result.setName(getName());

        return result;
    }


}
