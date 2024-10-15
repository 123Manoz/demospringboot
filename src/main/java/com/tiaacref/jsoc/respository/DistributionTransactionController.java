package com.tiaacref.jsoc.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.validation.Valid;
import java.time.LocalDateTime;

import com.tiaacref.jsoc.component.*;

@RestController
@Validated
public class DistributionTransactionController {

    @Autowired
    private StringToDateTimeConverter converter;

    private static final Logger logger = LogManager.getLogger(DistributionTransactionController.class);
    @GetMapping("/distributiontransaction")
    public String getDistributionTransaction(
            @Valid @ModelAttribute DateRangeDTO dateRange) {

        LocalDateTime fromDateTime = converter.convert(dateRange.getFrom());
        LocalDateTime toDateTime = dateRange.getTo() != null ?
                converter.convertToEndOfDay(dateRange.getTo()) :
                LocalDateTime.now();
        logger.info("Received 'from' parameter: {}", fromDateTime);
        logger.info("Received 'to' parameter: {}", toDateTime);

        return String.format("From: %s, To: %s", fromDateTime, toDateTime);

    }
}
