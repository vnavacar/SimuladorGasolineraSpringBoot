package com.example.main.Gasolinera;
//import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Caja {
    
    Coche enEsperaCoche[];
    //Semaphore semaforo;
    ReentrantLock cerrojo;

    public Caja() {

        this.cerrojo = new ReentrantLock();
        
    }

    public void ocupar() {
        cerrojo.lock();
    }
    public void soltar() {
        cerrojo.unlock();
    }

/* 
    public void run() {
        
        
        if(enEsperaCoche[0] != null){
            for(int i = 0; i < enEsperaCoche.length; i++){
                if(enEsperaCoche[i] != null){
                    try{
                        Thread.sleep((int)(3000));
                        enEsperaCoche[i].pagar();
                        enEsperaCoche[i] = null; // deberia enviar el coche a la caja en lugar de obliterarlo
                    }catch(InterruptedException e){
                        e.printStackTrace();
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
    }*/


}
