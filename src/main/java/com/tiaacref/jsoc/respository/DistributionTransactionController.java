package com.tiaacref.jsoc.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistributionTransactionController {
    private static final Logger logger = LogManager.getLogger(DistributionTransactionController.class);
    @GetMapping("/distributiontransaction")
    public String getDistributionTransaction(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        logger.info("Received 'from' parameter: {}", from);
        logger.info("Received 'to' parameter: {}", to);

        return String.format("Received request with 'from' = %s and 'to' = %s", from, to);
    }
}
