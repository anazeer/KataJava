package com.yatzy.refactoring.kata;

import com.yatzy.reftoring.kata.Yatzy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        Yatzy mock = new Yatzy(2, 3, 4, 5, 1);
        int expected = 15;
        int actual = mock.chance();
        assertEquals(expected, actual);
        assertEquals(16, new Yatzy(3, 3, 4, 5, 1).chance());
    }

    @Test
    public void yatzy_scores_50() {
        int expected = 50;
        int actual = new Yatzy(4, 4, 4, 4, 4).yatzy();
        assertEquals(expected, actual);
        assertEquals(50, new Yatzy(6, 6, 6, 6, 6).yatzy());
        assertEquals(0, new Yatzy(6, 6, 6, 6, 3).yatzy());
    }

    @Test
    public void test_1s() {
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).nSum(1));
        assertEquals(2, new Yatzy(1, 2, 1, 4, 5).nSum(1));
        assertEquals(0, new Yatzy(6, 2, 2, 4, 5).nSum(1));
        assertEquals(4, new Yatzy(1, 2, 1, 1, 1).nSum(1));
    }

    @Test
    public void test_2s() {
        assertEquals(4, new Yatzy(1, 2, 3, 2, 6).nSum(2));
        assertEquals(10, new Yatzy(2, 2, 2, 2, 2).nSum(2));
    }

    @Test
    public void test_threes() {
        assertEquals(6, new Yatzy(1, 2, 3, 2, 3).nSum(3));
        assertEquals(12, new Yatzy(2, 3, 3, 3, 3).nSum(3));
    }

    @Test
    public void fours_test() {
        assertEquals(12, new Yatzy(4, 4, 5, 5).nSum(4));
        assertEquals(8, new Yatzy(4, 5, 5, 5).nSum(4));
        assertEquals(4, new Yatzy(5, 5, 5, 5).nSum(4));
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy(4, 4, 5, 5).nSum(5));
        assertEquals(15, new Yatzy(4, 5, 5, 5).nSum(5));
        assertEquals(20, new Yatzy(5, 5, 5, 5).nSum(5));
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy(4, 4, 5, 5).nSum(6));
        assertEquals(6, new Yatzy(4, 6, 5, 5).nSum(6));
        assertEquals(18, new Yatzy(5, 6, 6, 5).nSum(6));
    }

    @Test
    public void one_pair() {
        assertEquals(6, new Yatzy(3, 4, 3, 5, 6).score_pair());
        assertEquals(10, new Yatzy(5, 3, 3, 3, 5).score_pair());
        assertEquals(12, new Yatzy(5, 3, 6, 6, 5).score_pair());
    }

    @Test
    public void two_Pair() {
        assertEquals(16, new Yatzy(3, 3, 5, 4, 5).two_pair());
        assertEquals(16, new Yatzy(3, 3, 5, 5, 5).two_pair());
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(9, new Yatzy(3, 3, 3, 4, 5).n_of_a_kind(3));
        assertEquals(15, new Yatzy(5, 3, 5, 4, 5).n_of_a_kind(3));
        assertEquals(9, new Yatzy(3, 3, 3, 3, 5).n_of_a_kind(3));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, new Yatzy(3, 3, 3, 3, 5).n_of_a_kind(4));
        assertEquals(20, new Yatzy(5, 5, 5, 4, 5).n_of_a_kind(4));
        assertEquals(9, new Yatzy(3, 3, 3, 3, 3).n_of_a_kind(4));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, new Yatzy(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).smallStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).smallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(6, 2, 3, 4, 5).largeStraight());
        assertEquals(20, new Yatzy(2, 3, 4, 5, 6).largeStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18, new Yatzy(6, 2, 2, 2, 6).fullHouse());
        assertEquals(0, new Yatzy(2, 3, 4, 5, 6).fullHouse());
    }

}
