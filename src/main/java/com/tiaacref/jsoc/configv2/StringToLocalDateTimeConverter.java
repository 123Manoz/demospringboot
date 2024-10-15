package com.tiaacref.jsoc.configv2;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    @Override
    public LocalDateTime convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        try {
            LocalDate date = LocalDate.parse(source, formatter);
            return date.atStartOfDay(); // Default to start of day
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use MM-dd-yyyy");
        }
    }

    public LocalDateTime convertToEndOfDay(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        try {
            LocalDate date = LocalDate.parse(source, formatter);
            return date.atTime(LocalTime.MAX);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use MM-dd-yyyy");
        }
    }
}