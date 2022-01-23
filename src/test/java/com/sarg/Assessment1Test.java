package com.sarg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assessment1Test {

    String foundText = "Found";
    String notFoundText = "there is no 7 in the array";

    @Test
    void shouldFindSevenInArray() throws Exception {
        Number[] nums = {1,2,4,7,9,5,6,34,456};
        Assessment1 assessment1 = new Assessment1();
        Assertions.assertEquals(foundText, assessment1.findSeven(nums));
    }

    @Test
    void shouldNotFindSevenInArray() throws Exception {
        Number[] nums = {1,2,4,9,5,6,34,456};
        Assessment1 assessment1 = new Assessment1();
        Assertions.assertEquals(notFoundText, assessment1.findSeven(nums));
    }

    @Test
    void shouldFindAppearanceOfSevenInArray() throws Exception {
        Number[] nums = {1,2,4,807,9,5,6,34,456};
        Assessment1 assessment1 = new Assessment1();
        Assertions.assertEquals(foundText, assessment1.findSeven(nums));
    }

    @Test
    void shouldNotFindSevenInEmptyArray() throws Exception {
        Number[] nums = {};
        Assessment1 assessment1 = new Assessment1();
        Assertions.assertEquals(notFoundText, assessment1.findSeven(nums));
    }

}