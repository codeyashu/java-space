package io.rsi.codespace.jxpath.util;

import io.rsi.codespace.jxpath.model.Address;
import io.rsi.codespace.jxpath.model.Author;
import io.rsi.codespace.jxpath.model.Book;
import io.rsi.codespace.jxpath.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Pointer;

import java.util.Arrays;
import java.util.Iterator;

@Slf4j
public class JXPathDemo {
    public static void main(String[] args) {
        Person person = Person.builder()
                .firstName("Rahul")
                .address(Address.builder()
                        .streetNumber("12")
                        .build())
                .build();

        JXPathContext context = JXPathContext.newContext(person);
        context.setLenient(true);

        /**Java property access , firstname or @firstname can be used*/
        String firstName = (String) context.getValue("@firstName");
        log.info("Firstname : " + firstName);

        String streetNumber = (String) context.getValue("address/streetNumber");
        log.info("Street Number : " + streetNumber);

        Address address = (Address) context.getValue("address");
        log.info("Address : " + address);

        Person person1 = (Person) context.getValue(".");
        log.info("Employee : " + person1);

        Author author = Author.builder()
                .books(Arrays.asList(
                        Book.builder().bookName("book1").build(),
                        Book.builder().bookName("book2").build(),
                        Book.builder().bookName("book3").build(),
                        Book.builder().bookName("book4").build()))
                .build();

        JXPathContext context1 = JXPathContext.newContext(author);
        Iterator itr = context.iterate("books[position < 4]");

        while (itr.hasNext()) {
            Pointer empPtr = (Pointer) itr.next();
            JXPathContext relativeContext = context.getRelativeContext(empPtr);

            Object value = relativeContext.getValue(".");
            System.out.println(value);
        }
    }
}
