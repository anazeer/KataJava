package com.yatzy.reftoring.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy {

    private static final int ROLL_COUNT = 5;
    private static final int ROLL_MIN   = 1;
    private static final int ROLL_MAX   = 6;

    private final int[] rolls;

    public Yatzy(int... rolls) {
        if (rolls == null || rolls.length != ROLL_COUNT) {
            throw new IllegalArgumentException("The roll count should be " + ROLL_COUNT);
        }
        if (Arrays.stream(rolls).anyMatch(roll -> roll < ROLL_MIN || roll > ROLL_MAX)) {
            throw new IllegalArgumentException("The roll value should be between " + ROLL_MIN + " and " + ROLL_MAX);
        }
        this.rolls = rolls;
    }

    public int chance() {
        return Arrays.stream(rolls).sum();
    }

    public int yatzy() {
        return Arrays.stream(rolls).allMatch(roll -> roll == rolls[0]) ? 50 : 0;
    }

    public int nSum(int n) {
        if (n < ROLL_MIN || n > ROLL_MAX) {
            throw new IllegalArgumentException("The roll value should be between " + ROLL_MIN + " and " + ROLL_MAX);
        }
        return Arrays.stream(rolls).filter(roll -> roll == n).sum();
    }

    public int score_pair() {
        List<Integer> rollsList = Arrays.stream(rolls).boxed().collect(Collectors.toList());
        return 2 * rollsList.stream()
                .filter(roll -> Collections.frequency(rollsList, roll) > 1)
                .mapToInt(i -> i)
                .max()
                .orElse(0);
    }

    public int two_pair() {
        List<Integer> rollsList = Arrays.stream(rolls).boxed().collect(Collectors.toList());
        int[] twiceRolls = rollsList.stream()
                .filter(roll -> Collections.frequency(rollsList, roll) > 1)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .mapToInt(i -> i).toArray();
        int twiceRollsLength = twiceRolls.length;
        if (twiceRollsLength < 2) {
            return 0;
        }
        return twiceRolls[twiceRollsLength - 1] * 2 + twiceRolls[twiceRollsLength - 2] * 2;
    }

    public int n_of_a_kind(int n) {
        List<Integer> rollsList = Arrays.stream(rolls).boxed().collect(Collectors.toList());
        return n * rollsList.stream()
                .filter(roll -> Collections.frequency(rollsList, roll) >= n)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public int smallStraight() {
        int sum = Arrays.stream(rolls)
                .filter(roll -> roll != ROLL_MAX)
                .distinct()
                .sum();
        return sum == 15 ? sum : 0;
    }

    public int largeStraight() {
        int sum = Arrays.stream(rolls)
                .filter(roll -> roll != ROLL_MIN)
                .distinct()
                .sum();
        return sum == 20 ? sum : 0;
    }

    public int fullHouse() {
        int twoOfAKind = n_of_a_kind(2);
        int threeOfAKind = n_of_a_kind(3);
        if (twoOfAKind != 0 && threeOfAKind != 0) {
            return twoOfAKind + threeOfAKind;
        }
        return 0;
    }

}
