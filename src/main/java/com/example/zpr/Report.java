package com.example.zpr;

import lombok.Data;

import java.util.Map;

@Data
public class Report {

    public Report(Map<Long, Integer> report) {
        this.report = report;
    }

    Map<Long, Integer> report;
}
