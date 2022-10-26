package com.example.main.Gasolinera;

public class Caja implements Runnable {
    
    Coche enEsperaCoche[];

    public Caja() {
        
    }

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
    }


}
