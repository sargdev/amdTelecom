package com.sarg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assessment2Test {

    @Test
    void shouldPrintAllDigits(){
        Assessment2 assessment2 = new Assessment2();
        Assertions.assertEquals(2, assessment2.digitSum(785));
    }

    @Test
    void shouldPrintAllDigits2(){
        Assessment2 assessment2 = new Assessment2();
        Assertions.assertEquals(1, assessment2.digitSum(99892));
    }

    @Test
    void shouldPrintAllDigits3(){
        Assessment2 assessment2 = new Assessment2();
        Assertions.assertEquals(2, assessment2.digitSum(38));
    }

    @Test
    void shouldPrintAllDigits4(){
        Assessment2 assessment2 = new Assessment2();
        Assertions.assertEquals(7, assessment2.digitSum(-34));
    }


}