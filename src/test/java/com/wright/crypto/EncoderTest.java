package com.wright.crypto;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Danny
 * @date 12/23/13 11:32 AM
 */
public class EncoderTest {

    @Test
    public void rotation() {
        assertEquals("ABC", Encoder.rotation("ABC", 0));
        assertEquals("BCD", Encoder.rotation("ABC", 1));
    }

}
