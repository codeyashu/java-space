package io.rsi.codespace.practice;

import java.util.Optional;

public class NullPointerExample {

    public static void main(String[] args) throws Exception {
        Optional<Object> process = process(false);

        

    }

    private static String doSomething(boolean processed) {
        if (processed) {
            return "passed";
        } else {
            return null;
        }
    }

    public static Optional<Object> process(boolean processed) {
        String response = doSomething(processed);

        return Optional.ofNullable(response);
    }
}
