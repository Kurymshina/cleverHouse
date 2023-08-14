package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @ParameterizedTest
    @MethodSource("provideStringsForIsStation")
    void shouldSetStationIfIsSize(int station, int expected, int currentStation) {
        Radio rad = new Radio(8);
        rad.setPreviouslyStation(currentStation);
        rad.setCurrentStation(station);
        int actual = rad.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideStringsForIsStation() {
        return Stream.of(
                Arguments.of(-1, 0, 0),
                Arguments.of(-1, 7, 7),
                Arguments.of(0, 0, 0),
                Arguments.of(1, 1, 0),
                Arguments.of(7, 7, 0),
                Arguments.of(8, 0, 0),
                Arguments.of(9, 0, 0),
                Arguments.of(10, 3, 3)
        );
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/previouslyStation.csv")
    void shouldReturnPreviouslyStationIfSetIncorrectStationWhenDefaultSize(int previouslyStation, int currentStation) {
        Radio rad = new Radio();
        rad.setPreviouslyStation(previouslyStation);
        rad.setCurrentStation(currentStation);
        int actual = rad.getCurrentStation();
        int expected = rad.getPreviouslyStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsNext")
    void shouldSwitchNextStation(int station, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(station);
        rad.next();
        int actual = rad.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideStringsForIsNext() {
        return Stream.of(
//                Arguments.of(-1, 1),
//                Arguments.of(0, 1),
//                Arguments.of(1, 2),
                Arguments.of(8, 9),
                Arguments.of(9, 0),
                Arguments.of(10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsPrev")
    void shouldSwitchPreviouslyStation(int station, int expected) {
        Radio rad = new Radio();
        rad.setCurrentStation(station);
        rad.prev();
        int actual = rad.getCurrentStation();
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
    @MethodSource("setMinMax")
    void setMinStationAndMaxStation(int expected, int minStation, int maxStation) {
        Radio rad = new Radio(5);
        rad.setMinStation(minStation);
        rad.setMaxStation(maxStation);
        int actualMax = rad.getMaxStation();
        int actualMin = rad.getMinStation();
        Assertions.assertEquals(expected, actualMax, actualMin);
    }

    private static Stream<Arguments> setMinMax() {
        return Stream.of(
                Arguments.of(0, 5, 5),
                Arguments.of(1, 1, 1),
                Arguments.of(4, 4, 4),
                Arguments.of(0, 6, 6)
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
