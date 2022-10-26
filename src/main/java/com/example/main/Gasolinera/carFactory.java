package com.example.main.Gasolinera;

public class carFactory implements Runnable{

    int t;
    int cochesALanzar;
    public carFactory(int cochesALanzar, int tiempoEntreCoche) {
        this.cochesALanzar = cochesALanzar;
        this.t= tiempoEntreCoche;
    }

    public void run() {
        for(int i = 0; i < cochesALanzar; i++){
            try{
                Thread.sleep(t);
                Coche coche = new Coche(i);
                coche.run();
            }throws(InterruptedException e){
                e.printStackTrace();
            }



        }
    }
    
}
