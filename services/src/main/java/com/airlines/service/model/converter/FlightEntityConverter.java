package com.airlines.service.model.converter;

import com.airlines.service.model.entity.FlightEntity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class FlightEntityConverter implements AttributeConverter<FlightEntity,Long> {

    @Override
    public Long convertToDatabaseColumn(final FlightEntity attribute) {
        return attribute.getId();
    }

    @Override
    public FlightEntity convertToEntityAttribute(final Long dbData) {
        return new FlightEntity(dbData);
    }
}
