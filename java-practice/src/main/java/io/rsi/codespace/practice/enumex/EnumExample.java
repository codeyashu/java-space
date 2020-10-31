package io.rsi.codespace.practice.enumex;

public class EnumExample {

    public static final int HIGH = 1;
    public static final int MEDIUM = 2;
    public static final int LOW = 3;

    public static final String FILE = "FILE";
    public static final String HTTP = "HTTP";

    public static void main(String[] args) {
        Level level = Level.HIGH;

        switch (level) {
            case HIGH: {
                System.out.println(Level.HIGH);
                break;
            }
            case MEDIUM: {
                System.out.println(Level.MEDIUM);
                break;
            }
            case LOW: {
                System.out.println(Level.LOW);
                break;
            }
        }


    }

}
