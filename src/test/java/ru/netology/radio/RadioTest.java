package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class RadioTest {
    @ParameterizedTest
    @MethodSource("provideStringsForIsStation")
    void shouldSetStation(int station, int expected) {
        Radio rad = new Radio();
        rad.setStation(station);
        int actual = rad.getStation();
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideStringsForIsStation() {
        return Stream.of(
                Arguments.of(-1, 0),
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(8, 8),
                Arguments.of(9, 9),
                Arguments.of(10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsNext")
    void shouldSwitchNextStation(int station, int expected) {
        Radio rad = new Radio();
        rad.setStation(station);
        rad.next();
        int actual = rad.getStation();
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideStringsForIsNext() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(0, 1),
                Arguments.of(1, 2),
                Arguments.of(8, 9),
                Arguments.of(9, 0),
                Arguments.of(10, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsPrev")
    void shouldSwitchPreviouslyStation(int station, int expected) {
        Radio rad = new Radio();
        rad.setStation(station);
        rad.prev();
        int actual = rad.getStation();
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideStringsForIsPrev() {
        return Stream.of(
                Arguments.of(-1, 9),
                Arguments.of(0, 9),
                Arguments.of(1, 0),
                Arguments.of(8, 7),
                Arguments.of(9, 8),
                Arguments.of(10, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsVolume")
    void shouldSetVolume(int volume, int expected) {
        Radio rad = new Radio();
        rad.setVolume(volume);
        int actual = rad.getVolume();
        Assertions.assertEquals(expected, actual);
    }


    private static Stream<Arguments> provideStringsForIsVolume() {
        return Stream.of(
                Arguments.of(-1, 0),
                Arguments.of(0, 0),
                Arguments.of(100, 100),
                Arguments.of(101, 100)
        );
    }


    @ParameterizedTest
    @MethodSource("provideStringsForIsPlusVolume")
    void shouldPlusVolume(int volume, int expected) {
        Radio rad = new Radio();
        rad.setVolume(volume);
        rad.plusVolume();
        int actual = rad.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideStringsForIsPlusVolume() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(0, 1),
                Arguments.of(1, 2),
                Arguments.of(99, 100),
                Arguments.of(100, 100),
                Arguments.of(101, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsMinusVolume")
    void shouldMinusVolume(int volume, int expected) {
        Radio rad = new Radio();
        rad.setVolume(volume);
        rad.minusVolume();
        int actual = rad.getVolume();
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideStringsForIsMinusVolume() {
        return Stream.of(
                Arguments.of(-1, 0),
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(99, 98),
                Arguments.of(100, 99),
                Arguments.of(101, 99)
        );
    }
}