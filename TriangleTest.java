package ru.gb.lesson_4;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


import static ru.gb.lesson_4.HW.TriangleArea.calcTriangleArea;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("Начинаем мракобесие...");
    }

    @Test
    @DisplayName("First test")
    void FirstTest() throws Exception {
        double result = calcTriangleArea (2,2,2);
        Assertions.assertEquals(1.7320508075688772, result);
        logger.info("Success");
    }

    @Test
    @DisplayName("Second test")
        void SecondTest() throws Exception {
            double result = calcTriangleArea(3, 4, 5);
            Assertions.assertEquals(6, result);
            logger.info("Success");
    }

    @Test
    @DisplayName("Third test")
        void ThirdTestNegative() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> calcTriangleArea(-2, 4, 5));
        logger.error("Ups!");
    }

    @Test
    @DisplayName("Fourth test")
    void FourthTestNegative() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> calcTriangleArea(0, 1, 1));
        logger.error("Ups!");
    }

    @AfterAll
    static void afterAll() {
        logger.info("Ура, закончили!");
    }

}

