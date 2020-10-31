package io.rsi.codespace.jxpath.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Book {
    private String bookName;
}
