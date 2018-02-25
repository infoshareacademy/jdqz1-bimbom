package com.isacademy.jjdd1.czterystrony.analysis;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SimpleMovingAverageTest {

    private static SimpleMovingAverage simpleMovingAverage;

    @Before
    public void setup() {
        simpleMovingAverage = new SimpleMovingAverage(TestAverages.POSITIVE_PERIOD);
    }

    @Test
    public void when_nothing_added_average_should_be_zero() {
        assertThat(simpleMovingAverage.getAverage()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void average_for_only_1_value_should_be_equal_this_value() {
        simpleMovingAverage.add(TestAverages.TEST_VALUE);
        // TODO check is value added to array
        assertThat(simpleMovingAverage.window).isNotEmpty().hasSize(1);
        assertThat(simpleMovingAverage.getAverage()).isEqualTo(TestAverages.TEST_VALUE);
    }

    @Test
    public void should_failure_when_negative_period_is_given() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new SimpleMovingAverage(TestAverages.NEGATIVE_PERIOD));
    }

    @Test
    public void average_array_size_should_not_be_greater_than_period() {
        for (int i = 0; i <= TestAverages.POSITIVE_PERIOD; i++) {
            simpleMovingAverage.add(BigDecimal.valueOf(i));
        }
        simpleMovingAverage.add(BigDecimal.TEN);
        assertThat(simpleMovingAverage.window).hasSize(TestAverages.POSITIVE_PERIOD);

        assertThat(simpleMovingAverage.window.get(0)).isEqualTo(BigDecimal.valueOf(2));
        assertThat(simpleMovingAverage.window.get(simpleMovingAverage.window.size() - 1)).isEqualTo(BigDecimal.TEN);
    }

    @Test
    public void divisor_should_be_equal_to_average_array_size() {
        for (int i = 0; i <= TestAverages.POSITIVE_PERIOD; i++) {
            simpleMovingAverage.add(BigDecimal.valueOf(i));
        }
        assertThat(simpleMovingAverage.getDivisor()).isEqualTo(BigDecimal.valueOf(TestAverages.POSITIVE_PERIOD));
    }
}
