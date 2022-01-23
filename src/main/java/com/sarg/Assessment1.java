package com.sarg;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assessment1 {

    /**
     * Takes an array of numbers and return "Found"
     * if the character 7 appears in the array of the numbers. Otherwise, return "there is no 7 in the array".
     * @param numbers Array of numbers
     * @return "Found" if 7 appears in the array of the numbers, otherwise "there is no 7 in the array"
     */
    public String findSeven(Number[] numbers) throws Exception {
        if(numbers == null) {
            throw new Exception("Numbers array should not be null");
        }
        Stream<Number> s1 = Stream.of(numbers);
        List<Number> sevenAppearsList = s1
                .filter(p-> p.toString().contains("7"))
                .collect(Collectors.toList());

        return sevenAppearsList.size() > 0 ? "Found" : "there is no 7 in the array";
    }
}
