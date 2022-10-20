package com.example.zpr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

@Data
public class Report {

    public Report(List<Map<Integer, Long>> report) {
        this.report = report;
    }

    List<Map<Integer, Long>> report;
}
