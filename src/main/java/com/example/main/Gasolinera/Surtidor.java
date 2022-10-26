package com.example.main.Gasolinera;
import java.util.concurrent.Semaphore;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Surtidor implements Runnable{
    Coche enEsperaCoche[];
    Semaphore semaforo;
    //private static Logger logger = LoggerFactory.getLogger(Surtidor.class);


    public Surtidor() {
        this.enEsperaCoche = new Coche[5];
        this.semaforo = new Semaphore(1);
    }

    public void run() {
        while(true){
            if(enEsperaCoche[0] != null){
                for(int i = 0; i < enEsperaCoche.length; i++){
                    if(enEsperaCoche[i] != null){
                        try{
                            Thread.sleep((int)(Math.random()*5+5));
                            enEsperaCoche[i].repostado();
                            enEsperaCoche[i] = null; // deberia enviar el coche a la caja en lugar de obliterarlo
                        }catch(InterruptedException e){
                            //e.printStackTrace();
                            Logger.getLogger(Surtidor.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                }
            }else{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
}
