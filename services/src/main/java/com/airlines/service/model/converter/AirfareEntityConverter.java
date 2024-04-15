package com.airlines.service.model.converter;

import com.airlines.service.model.entity.AirfareEntity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AirfareEntityConverter implements AttributeConverter<AirfareEntity, Long> {

    @Override
    public Long convertToDatabaseColumn(final AirfareEntity attribute) {
        return attribute.getId();
    }

    @Override
    public AirfareEntity convertToEntityAttribute(final Long dbData) {
        return new AirfareEntity(dbData);
    }
}
