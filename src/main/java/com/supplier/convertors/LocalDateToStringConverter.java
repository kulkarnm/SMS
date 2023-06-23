package com.supplier.convertors;

import org.joda.time.LocalDate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class LocalDateToStringConverter implements Converter<LocalDate,String> {
    @Override
    public String convert(LocalDate source) {
        return source == null ? null : source.toString();
    }
} 
