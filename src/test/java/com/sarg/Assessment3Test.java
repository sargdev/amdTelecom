package com.sarg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assessment3Test {

    @Test
    void shouldApplyFirstFilter() throws Exception {
        Assessment3 assessment3 = new Assessment3();
        String expectedValue = "Omtay otgay away mallsay iecepay ofway iepay.";
        String words = "Tom got a small piece of pie.";
        Assertions.assertEquals(expectedValue, assessment3.doRemake(words));

    }
    @Test
    void shouldApplyFirstFilter2() throws Exception {
        Assessment3 assessment3 = new Assessment3();
        String expectedValue = "Atscay areway reatgay etspay.";
        String words = "Cats are great pets.";
        Assertions.assertEquals(expectedValue, assessment3.doRemake(words));

    }
    @Test
    void shouldApplyFirstFilter3() throws Exception {
        Assessment3 assessment3 = new Assessment3();
        String expectedValue = "Ehay oldtay usway away eryvay excitingway aletay.";
        String words = "He told us a very exciting tale.";
        Assertions.assertEquals(expectedValue, assessment3.doRemake(words));

    }
    @Test
    void shouldApplyFirstFilter4() throws Exception {
        Assessment3 assessment3 = new Assessment3();
        String expectedValue = "Ehay oldtay Avvassay away eryvay excitingway aletay.";
        String words = "He told Savvas a very exciting tale.";
        Assertions.assertEquals(expectedValue, assessment3.doRemake(words));

    }


}