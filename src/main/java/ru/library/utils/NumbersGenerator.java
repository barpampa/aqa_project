package ru.library.utils;

import java.util.Random;

public class NumbersGenerator {
    long min = 100L;
    long max = 999L;
    Random random = new Random();
    long value = random.nextLong(max - min + 1L) + min;

    public long getRandomValue() {
        return value;
    }
}
