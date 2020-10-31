package io.rsi.codespace.algo;

import static io.rsi.codespace.util.DsAlogoUtil.print;

public class PrimeNumberExample {
    private static void checkPrimeNumber(int num) {
        if (num < 1) {
            print("Not a valid number");
            return;
        }

        if (num == 1) {
            print("one is prime number");
            return;
        }

        boolean isPrime = true;
        int count =  0;
        for (int i = 2; i < num; i++) {
            count++;
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        print("Is " + num + " a prime number ? " + isPrime);
        System.out.println("Counter run : " + count);
        System.out.println();

    }

    public static void main(String[] args) {
        /*checkPrimeNumber(113);*/
        int n = 7;
        System.out.println(13/6);
    }
}
