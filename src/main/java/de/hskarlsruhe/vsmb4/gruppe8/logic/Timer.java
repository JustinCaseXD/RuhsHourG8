package de.hskarlsruhe.vsmb4.gruppe8.logic;

import javafx.fxml.FXML;

public class Timer {

    @FXML
    public String counter;
    /*
    int verbleibendeZeit = 120;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            verbleibendeZeit--;
            counter = String.valueOf(verbleibendeZeit);
        }
    };
    public void start(){
        timer.scheduleAtFixedRate(task,1000,1000);
    }

    private void scheduleAtFixedRate(TimerTask task, int i, int i1) {
    } */

    public boolean timer (int playtime) {

        for ( int i = playtime ; i >= 0 ; i--){
            counter = String.valueOf(i);
            try {
                wait(1000, 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }if ( counter == String.valueOf(0) ){
         return true;
        }else{
            System.out.println("da ist was schief gelaufen");
            return false;
        }

    }
}
