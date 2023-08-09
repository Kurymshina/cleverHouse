package ru.netology.radio;

public class Radio {
    private int station;
    private int volume;

    public void setStation(int station) {
//        this.station = station < 0 || station > 9 ? 0 : station;
        this.station = station;
        if (station < 0) {
            this.station = 0;
        }
        if (station > 9) {
            this.station = 0;
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
        setStation(++station);

    }

    public void prev() {
//        setStation(station == 0 ? 9 : --station);
        if (station > 0) {
            setStation(--station);
        } else station = 9;
    }

    public void plusVolume() {
        setVolume(++volume);
    }

    public void minusVolume() {
//        setVolume(volume == 0 ? 0 : --volume);
        if(volume == 0){
            volume = 0;
        }
        else
        setVolume(--volume);
    }
}