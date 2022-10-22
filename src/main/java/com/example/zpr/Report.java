package com.example.zpr;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Report {

    public Report(List<Map<Integer, Long>> report) {
        this.report = report;
    }

    List<Map<Integer, Long>> report;
}
