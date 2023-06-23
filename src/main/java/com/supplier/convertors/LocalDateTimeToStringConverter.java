package com.supplier.convertors;

import org.joda.time.LocalDateTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class LocalDateTimeToStringConverter implements Converter<LocalDateTime,String> {
    @Override
    public String convert(LocalDateTime source) {
        return source == null ? null : source.toString();
    }
} 
