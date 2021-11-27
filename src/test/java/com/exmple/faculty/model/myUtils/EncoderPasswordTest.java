package com.exmple.faculty.model.myUtils;

import com.example.faculty.cipher.AES;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class EncoderPasswordTest {

    @Test
    public void shouldEncodePassword() {
        assertThat(AES.encrypt("admin", AES.KEY), equalToIgnoringCase("NZf2oXn8cIH6EQgdelUipQ=="));
        assertThat(AES.encrypt("teacher", AES.KEY), equalToIgnoringCase("floRUfO10mPM4eX2uEYSpQ=="));
        assertThat(AES.encrypt("Testing123!", AES.KEY), equalToIgnoringCase("BmFmCqsldrHXNBhaacspKw=="));
    }

    @Test
    public void shouldDecodePassword() {
        assertThat(AES.decrypt("NZf2oXn8cIH6EQgdelUipQ==", AES.KEY), equalToIgnoringCase("admin"));
        assertThat(AES.decrypt("floRUfO10mPM4eX2uEYSpQ==", AES.KEY), equalToIgnoringCase("teacher"));
        assertThat(AES.decrypt("BmFmCqsldrHXNBhaacspKw==", AES.KEY), equalToIgnoringCase("Testing123!"));
    }
}
