package io.rsi.codespace.jxpath.model;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private List employees;
    private String name;

    public Department(String name) {
        this.name = name;
    }
}