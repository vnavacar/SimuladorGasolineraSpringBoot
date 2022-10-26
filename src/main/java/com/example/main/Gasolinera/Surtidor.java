package com.example.main.Gasolinera;

public class Surtidor implements Runnable{
    Coche enEsperaCoche[];


    public Surtidor() {
        this.enEsperaCoche = new Coche[5];
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

    
}
