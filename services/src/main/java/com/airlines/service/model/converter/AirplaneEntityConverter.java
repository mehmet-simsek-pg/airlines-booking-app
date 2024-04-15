package com.airlines.service.model.converter;

import com.airlines.service.model.entity.AirplaneEntity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AirplaneEntityConverter implements AttributeConverter<AirplaneEntity, Long> {

    @Override
    public Long convertToDatabaseColumn(final AirplaneEntity attribute) {
        return attribute.getId();
    }

    @Override
    public AirplaneEntity convertToEntityAttribute(final Long dbData) {
        return new AirplaneEntity(dbData);
    }
}
