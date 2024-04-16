package com.airlines.service.enums;

import com.airlines.service.consts.GenderValue;

public enum GenderEnum {
    MALE("Male", GenderValue.MALE), FEMALE("Female", GenderValue.FEMALE),
    DIVERSE("Diverse", GenderValue.DIVERSE);

    private final String name;
    private final String value;

    GenderEnum(final String name, final String value) {
        this.name = name;
        this.value = value;
    }


}
