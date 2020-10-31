package io.rsi.codespace.jxpath.model;

import lombok.Data;

import java.util.List;

@Data
public class Company {
    private String name;
    private List departmentList;

    public Company(String name) {
        this.name = name;
    }
}
