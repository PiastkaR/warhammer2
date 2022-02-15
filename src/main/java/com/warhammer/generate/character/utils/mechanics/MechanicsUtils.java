package com.warhammer.generate.character.utils.mechanics;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MechanicsUtils {

    public static int getTensFromDigit(int digit) {
        return (digit / 10) % 10;
    }

    public static boolean isBetween(int value, int min, int max) {
        return ((value >= min) && (value <= max));
    }

    public static <T> List<T> filterData(Iterable<T> iterable, Predicate<T> predicate1, Predicate<T> predicate2) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .filter(predicate1)
                .filter(predicate2)
                .collect(Collectors.toList());
    }

    public static <T> List<T> filterData(Iterable<T> iterable, Predicate<T> predicate) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static <T> int drawFromFiltered(List<T> filteredList) {
        int size = filteredList.size();
        return new Random().nextInt(size);
    }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
