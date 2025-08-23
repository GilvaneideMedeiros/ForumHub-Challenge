package com.gilvaneide.forumhub.curso.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CursoCategoriaConverter implements AttributeConverter<CursoCategoria, String> {

    @Override
    public String convertToDatabaseColumn(CursoCategoria categoria) {
        if (categoria == null) {
            return null;
        }
        return categoria.getDescricao();
    }

    @Override
    public CursoCategoria convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return CursoCategoria.fromDescricao(dbData);
    }
}