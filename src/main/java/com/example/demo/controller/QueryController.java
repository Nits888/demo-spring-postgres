package com.example.demo.controller;

import com.example.demo.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    private static final Logger logger = LoggerFactory.getLogger(QueryController.class);

    @GetMapping
    public ResponseEntity<String> executeQuery() {
        try {
            logger.info("Executing query from file.");
            String result = queryService.executeQueryFromFile("src/main/resources/query.sql");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Error occurred while executing query: ", e);
            return ResponseEntity.status(500).body("Error executing query");
        }
    }
}
