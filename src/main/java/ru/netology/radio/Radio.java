package ru.netology.radio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class Radio {
    private int previouslyStation;
    private int currentStation;
    private int minStation;
    private int maxStation;
    private int volume;
    private int count;

        public void setCurrentStation(int currentStation){
            if (currentStation >= 0 && currentStation < count) {
                this.currentStation = currentStation;
            } else {
                this.currentStation = previouslyStation;
            }
        }

        public void setVolume ( int volume){

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

    public Radio( int size){
            count = minStation + size;
        }

    public Radio() {
            count = minStation + 10;
        }

        public void next () {
            if (currentStation == maxStation) {
                setCurrentStation(0);
            } else {
                setCurrentStation(++currentStation);
            }
        }

        public void prev () {

            if (currentStation > 0) {
                setCurrentStation(--currentStation);
            } else {
                currentStation = --count;
            }
        }

        public void plusVolume () {
            setVolume(++volume);
        }

        public void minusVolume () {
            if (volume != 0) {
                setVolume(--volume);
            }
        }
    }
