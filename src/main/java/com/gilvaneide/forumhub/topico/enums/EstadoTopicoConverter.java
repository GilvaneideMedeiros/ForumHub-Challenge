package com.gilvaneide.forumhub.topico.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EstadoTopicoConverter implements AttributeConverter<EstadoTopico, String> {

    @Override
    public String convertToDatabaseColumn(EstadoTopico estado) {
        if (estado == null) {
            return null;
        }
        return estado.name();
    }

    @Override
    public EstadoTopico convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return EstadoTopico.valueOf(dbData.toUpperCase());
    }
}