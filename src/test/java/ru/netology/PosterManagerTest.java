
package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {

    // 1. Проверяем, что пустая афиша возвращает пустой массив
    @Test
    void shouldReturnEmptyArrayIfNoMoviesAdded() {
        PosterManager manager = new PosterManager();

        String[] actual = manager.findAll();

        assertArrayEquals(new String[0], actual);
    }

    // 2. Проверяем добавление одного фильма
    @Test
    void shouldAddMovie() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Бладшот");

        String[] actual = manager.findAll();
        String[] expected = {"Бладшот"};

        assertArrayEquals(expected, actual);
    }

    // 3. Проверяем добавление нескольких фильмов
    @Test
    void shouldAddSeveralMovies() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");

        String[] actual = manager.findAll();
        String[] expected = {
                "Бладшот",
                "Вперёд",
                "Отель Белград"
        };

        assertArrayEquals(expected, actual);
    }

    // 4. Проверяем последние 5 фильмов в обратном порядке
    @Test
    void shouldReturnLastFiveMoviesInReverseOrder() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");
        manager.addMovie("Фильм 6");

        String[] actual = manager.findLast();
        String[] expected = {
                "Фильм 6",
                "Фильм 5",
                "Фильм 4",
                "Фильм 3",
                "Фильм 2"
        };

        assertArrayEquals(expected, actual);
    }

    // 5. Проверяем пользовательский лимит 3
    @Test
    void shouldReturnLastThreeMovies() {
        PosterManager manager = new PosterManager(3);

        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");

        String[] actual = manager.findLast();
        String[] expected = {
                "Фильм 5",
                "Фильм 4",
                "Фильм 3"
        };

        assertArrayEquals(expected, actual);
    }

    // 6. Проверяем, если фильмов меньше лимита
    @Test
    void shouldReturnAllMoviesIfLessThanLimit() {
        PosterManager manager = new PosterManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Тролли");

        String[] actual = manager.findLast();
        String[] expected = {
                "Тролли",
                "Вперёд",
                "Бладшот"
        };

        assertArrayEquals(expected, actual);
    }

    // 7. Проверяем пустую афишу через findLast()
    @Test
    void shouldReturnEmptyArrayIfNoMoviesAddedToFindLast() {
        PosterManager manager = new PosterManager();

        String[] actual = manager.findLast();

        assertArrayEquals(new String[0], actual);
    }

    // 8. Проверяем пользовательский лимит 7
    @Test
    void shouldReturnLastSevenMovies() {
        PosterManager manager = new PosterManager(7);

        for (int i = 1; i <= 10; i++) {
            manager.addMovie("Фильм " + i);
        }

        String[] actual = manager.findLast();
        String[] expected = {
                "Фильм 10",
                "Фильм 9",
                "Фильм 8",
                "Фильм 7",
                "Фильм 6",
                "Фильм 5",
                "Фильм 4"
        };

        assertArrayEquals(expected, actual);
    }

    // 9. Проверяем, если количество фильмов равно лимиту
    @Test
    void shouldReturnAllFiveMoviesIfCountEqualsLimit() {
        PosterManager manager = new PosterManager(5);

        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");

        String[] actual = manager.findLast();
        String[] expected = {
                "Фильм 5",
                "Фильм 4",
                "Фильм 3",
                "Фильм 2",
                "Фильм 1"
        };

        assertArrayEquals(expected, actual);
    }
}
