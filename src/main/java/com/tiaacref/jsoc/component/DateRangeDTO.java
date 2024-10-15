package com.tiaacref.jsoc.component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateRangeDTO {

    @ValidDate(message = "From date is required and must be in MM-dd-yyyy format")
    private String from;

    @ValidDate(optional = true, message = "To date must be in MM-dd-yyyy format")
    private String to;

    // Getters and setters
}