package ru.netology.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GetCardFormTest {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSubmitRequest() {
        LocalDate today = LocalDate.now();
        LocalDate meetingDay = today.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String textDate = meetingDay.format(formatter);

        $("[placeholder='Город']").setValue("Санкт-Петербург");
        $("[placeholder='Дата встречи']").setValue(textDate);
        $("[name='name']").setValue("Иванов Петр");
        $("[name='phone']").setValue("+79001234567");
        $("[class='checkbox__box']").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно")).shouldBe(Condition.visible, Duration.ofSeconds(15));


    }


}
