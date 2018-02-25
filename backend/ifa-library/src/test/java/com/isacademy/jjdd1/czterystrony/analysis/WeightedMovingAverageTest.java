package com.isacademy.jjdd1.czterystrony.analysis;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WeightedMovingAverageTest {

    private static WeightedMovingAverage weightedMovingAverage;

    @Before
    public void setup() {
        weightedMovingAverage = new WeightedMovingAverage(TestAverages.POSITIVE_PERIOD);
    }

    @Test
    public void when_nothing_added_average_should_be_zero() {
        assertThat(weightedMovingAverage.getAverage()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void average_for_only_1_value_should_be_equal_this_value() {
        weightedMovingAverage.add(TestAverages.TEST_VALUE);
        // TODO check is value added to array
        assertThat(weightedMovingAverage.window).isNotEmpty().hasSize(1);
        assertThat(weightedMovingAverage.getAverage()).isEqualTo(TestAverages.TEST_VALUE);

    }

    @Test
    public void should_failure_when_negative_period_is_given() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                // TODO change SMA to WMA constructor
                .isThrownBy(() -> new WeightedMovingAverage(TestAverages.NEGATIVE_PERIOD));
    }


    public void average_array_size_should_not_be_greater_than_period() {
        for (int i = 0; i <= TestAverages.POSITIVE_PERIOD; i++){
            weightedMovingAverage.add(BigDecimal.valueOf(1));
        }
        weightedMovingAverage.add(BigDecimal.TEN);
        assertThat(weightedMovingAverage.window).hasSize(TestAverages.POSITIVE_PERIOD);
        assertThat(weightedMovingAverage.window.get(0)).isEqualTo(BigDecimal.valueOf(2));
        assertThat(weightedMovingAverage.window.get(weightedMovingAverage.window.size() -1)).isEqualTo(BigDecimal.TEN);
    }

    @Test
    public void divisor_should_equal_to_average_array_index_sum() {
        for (int i = 0; i <= TestAverages.POSITIVE_PERIOD; i++) {
            weightedMovingAverage.add(BigDecimal.valueOf(i));
        }
        assertThat(weightedMovingAverage.getDivisor())
                .isEqualTo(BigDecimal.valueOf(IntStream.rangeClosed(1, TestAverages.POSITIVE_PERIOD).sum()));
    }
}
