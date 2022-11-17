package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void stringToDate() {
        // given
        String fecha = "10/10/2022";
        Calendar myCalendar = new GregorianCalendar(2022, 9, 10);
        Date expectedDate = myCalendar.getTime();
        // When
        Date resultDate = DateUtils.stringToDate(fecha);
        // Then
        Assertions.assertEquals(expectedDate, resultDate);
    }

    @Test
    void dateToString() {
        // given
        String expectedDate = "10/10/2022";
        Calendar myCalendar = new GregorianCalendar(2022, 9, 10);
        Date fecha = myCalendar.getTime();
        // When
        String resultDate = DateUtils.dateToString(fecha);
        // Then
        Assertions.assertEquals(expectedDate, resultDate);
    }
}