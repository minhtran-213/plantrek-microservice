package com.plantrek.searchservice.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriceHelperTest {

    @Test
    void testCalculateTwoNumberWithAEqualZeroThenReturnB() {
        //given
        int a = 0;
        int b = 3;

        //when
        int actual = PriceHelper.calculateTwoNumber(a, b);

        //then
        assertThat(actual).isEqualTo(3);
    }
}
