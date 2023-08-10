package ru.netology.radio;

public class Radio {
    private int station;
    private int volume;

    public void setStation(int station) {
//        this.station = station < 0 || station > 9 ? 0 : station;

        if (station <= 9 && station >= 0) {
            this.station = station;
        }
    }

    public int getStation() {
        return station;
    }

    public void setVolume(int volume) {
//        this.volume = volume < 0 ? 0 : Math.min(volume, 100);

        if (volume < 0) {
            this.volume = 0;
            return;
        }
        if (volume >= 100) {
            this.volume = 100;
            return;
        }
        this.volume = volume;

    }

    public int getVolume() {
        return volume;
    }

    public void next() {
        if (station == 9) {
            setStation(0);
        } else {
            setStation(++station);
        }
    }

    public void prev() {
//        setStation(station == 0 ? 9 : --station);
        if (station > 0) {
            setStation(--station);
        } else {
            station = 9;
        }
    }

    public void plusVolume() {
        setVolume(++volume);
    }

    public void minusVolume() {
        if (volume != 0) {
            setVolume(--volume);
        }
    }
}