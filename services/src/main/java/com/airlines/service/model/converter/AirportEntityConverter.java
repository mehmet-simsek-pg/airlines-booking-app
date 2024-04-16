package com.airlines.service.model.converter;

import com.airlines.service.model.entity.AirportEntity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AirportEntityConverter implements AttributeConverter<AirportEntity, Long> {
    @Override
    public Long convertToDatabaseColumn(final AirportEntity attribute) {
        return attribute.getId();
    }

    @Override
    public AirportEntity convertToEntityAttribute(final Long dbData) {
        return new AirportEntity(dbData);
    }
}
