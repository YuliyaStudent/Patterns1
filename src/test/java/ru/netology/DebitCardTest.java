package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.DELETE;

public class DebitCardTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
        $("[data-test-id=city] input").setValue(DataGenerator.generateCity());
        $("[data-test-id=date] input").sendKeys(DELETE, DataGenerator.generateDate(3));
        $("[data-test-id=name] input").sendKeys(DataGenerator.generateName("ru"));
        $("[data-test-id=phone] input]").sendKeys(DataGenerator.generatePhone("ru"));
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=notification] .notification__content").shouldBe(visible, Duration.ofSeconds(15)).
                should(exactText("Встреча успешно забронирована на " + DataGenerator.generateDate(3)));

    }
}
