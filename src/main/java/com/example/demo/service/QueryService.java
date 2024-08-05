package com.example.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Service
public class QueryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String executeQueryFromFile(String filePath) throws IOException {
        // Read the SQL query from the file
        String query = new String(Files.readAllBytes(Paths.get(filePath)));

        // Execute the query
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        // Convert the result to JSON
        return objectMapper.writeValueAsString(result);
    }
}
