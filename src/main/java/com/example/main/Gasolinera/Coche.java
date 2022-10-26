package com.example.main.Gasolinera;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Coche implements Runnable{
    private static Logger logger = LoggerFactory.getLogger(Coche.class);
    boolean repostado;
    boolean pagado;
    carManager manager;
    public static int id;

    public Coche(carManager manager) {
        this.manager = manager;
        this.repostado = false;
    }


    public void run(){

        while (true){
            try{
                
                if(!repostado){
                    repostar();
                }else if(!pagado){
                    pagar();
                }else{
                    break;
                }
            }catch(InterruptedException e){
                logger.error(e.getMessage(), e);
            }
        }

    }


    private void repostar() throws InterruptedException{

        logger.info("El coche: "+id+" esta buscando un surtidor libre");
        s = manager.buscaSurtidorLibre();
        s.ocupar();

        this.repostado = true;
        logger.info("Coche " + id + " repostado");
    }
    public void pagar() {
        this.pagado = true;
        logger.info("Coche " + id + " pagado");
    }

}
