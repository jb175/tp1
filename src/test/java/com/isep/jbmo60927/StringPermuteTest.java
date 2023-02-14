package com.isep.jbmo60927;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StringPermuteTest {
    @Test
    public void testCharExtraction() {
        String str = "test";
        int charToRemove = 0;
        String result = StringPermute.charExtraction(str, charToRemove);
        assertEquals(result, "est");
        assertEquals(str.charAt(charToRemove), 't');
    }

    @Test
    public void testPermutations() {

    }

    @Test
    public void testPermutationsFor2() {

    }
}
