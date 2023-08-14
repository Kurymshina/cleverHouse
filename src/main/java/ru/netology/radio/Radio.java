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

//    public int getPreviouslyStation() {
//        return previouslyStation;
//    }
//
//    public int getCurrentStation() {
//        return currentStation;
//    }
//
//    public int getMinStation() {
//        return minStation;
//    }
//
//    public int getMaxStation() {
//        return maxStation;
//    }
//
//    public int getVolume() {
//        return volume;
//    }
//
//    public void setPreviouslyStation(int previouslyStation) {
//        {
//            this.previouslyStation = previouslyStation;
//        }
//    }
//
        public void setCurrentStation(int currentStation){
            if (currentStation >= 0 && currentStation < count) {
                this.currentStation = currentStation;
            } else {
                this.currentStation = previouslyStation;
            }
        }
//
//        public void setMinStation ( int minStation){
//            if (minStation >= 0 && minStation < count) {
//                this.minStation = minStation;
//            } else {
//                return;
//            }
//            ;
//        }
//
//        public void setMaxStation ( int maxStation){
//            if (maxStation >= 0 && maxStation < count) {
//                this.maxStation = maxStation;
//            } else {
//                return;
//            }
//        }
//
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
