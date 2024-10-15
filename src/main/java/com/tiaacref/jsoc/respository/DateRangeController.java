package com.tiaacref.jsoc.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.tiaacref.jsoc.configv2.*;

import jakarta.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class DateRangeController {

    @Autowired
    private StringToLocalDateTimeConverter converter;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDateTime.class, "from", new CustomDateTimeEditor(converter, false));
        binder.registerCustomEditor(LocalDateTime.class, "to", new CustomDateTimeEditor(converter, true));
    }

    @GetMapping("/dateRange")
    public String getDateRange(@Valid @ModelAttribute DateRangeDTO dateRange) {
        LocalDateTime toDateTime = dateRange.getTo() != null ? dateRange.getTo() : LocalDateTime.now();
        return String.format("From: %s, To: %s", dateRange.getFrom(), toDateTime);
    }
}