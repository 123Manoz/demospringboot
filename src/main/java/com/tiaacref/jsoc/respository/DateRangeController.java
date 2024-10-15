package com.tiaacref.jsoc.respository;

import org.springframework.beans.PropertyEditorSupport;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;

public class CustomDateTimeEditor extends PropertyEditorSupport {

    private final StringToLocalDateTimeConverter converter;
    private final boolean isEndOfDay;

    public CustomDateTimeEditor(StringToLocalDateTimeConverter converter, boolean isEndOfDay) {
        this.converter = converter;
        this.isEndOfDay = isEndOfDay;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            setValue(null);
        } else {
            setValue(isEndOfDay ? converter.convertToEndOfDay(text) : converter.convert(text));
        }
    }
}