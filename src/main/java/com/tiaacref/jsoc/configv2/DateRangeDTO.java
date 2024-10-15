package com.tiaacref.jsoc.configv2;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DateRangeDTO {

    @ValidDate(message = "From date is required and must be in MM-dd-yyyy format")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @DateTimeFrom
    private LocalDateTime from;

    @ValidDate(optional = true, message = "To date must be in MM-dd-yyyy format")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @DateTimeTo
    private LocalDateTime to;

    // Getters and setters
}