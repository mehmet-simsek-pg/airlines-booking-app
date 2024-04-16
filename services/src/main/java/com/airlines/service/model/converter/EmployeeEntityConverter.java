package com.airlines.service.model.converter;

import com.airlines.service.model.entity.EmployeeEntity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EmployeeEntityConverter implements AttributeConverter<EmployeeEntity, Long> {
    @Override
    public Long convertToDatabaseColumn(final EmployeeEntity attribute) {
        return attribute.getId();
    }

    @Override
    public EmployeeEntity convertToEntityAttribute(final Long dbData) {
        return new EmployeeEntity(dbData);
    }
}
