package io.rsi.codespace.jxpath.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Author {
    private List<Book> books;
}