package views;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class main_3Test {

    // Тестування обчислень для завдання 1
    @Test
    void testCalculateVolumeAndSurface() {
        // Довжини ребер паралелепіпеда
        double a = 1;
        double b = 2;
        double c = 3;

        // Очікувані результати
        double expectedVolume = 6.0;
        double expectedSurface = 22.0;

        // Обчислення
        double volume = a * b * c;
        double surface = 2 * (a * b + b * c + a * c);

        // Перевірка результатів
        Assertions.assertEquals(expectedVolume, volume, "Об'єм обчислено неправильно.");
        Assertions.assertEquals(expectedSurface, surface, "Площа поверхні обчислена неправильно.");
    }

    // Тестування визначення зупинок за маршрутом (Завдання 2)
    @Test
    void testGetStops() {
        main_3 mainApp = new main_3();

        // Перевірка маршруту 1
        Assertions.assertEquals("вул. Буковинська — вул. Акціонерна", mainApp.getStops(1));

        // Перевірка маршруту 9
        Assertions.assertEquals("Вулиця Милославська — Станція метро «Позняки»", mainApp.getStops(9));

        // Перевірка невідомого маршруту
        Assertions.assertEquals("Невідомий маршрут", mainApp.getStops(99));
    }
}
