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
        this.pagado = false;
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
        logger.info("Coche {} terminado", id);
    }


    private void repostar() throws InterruptedException{

        logger.info("El coche: "+id+" esta buscando un surtidor libre");
        Surtidor s = manager.buscaSurtidorLibre();
        s.ocupar();
        Thread.sleep((int)(Math.random()*5+5)*1000); // entre 5 y 10 segundos de repostaje
        s.soltar();
        this.repostado = true;
        logger.info("Coche " + id + " repostado");
    }

    public void pagar() throws InterruptedException{
        logger.info("El coche: "+id+" esta buscando una caja libre");
        Caja c = manager.buscaCajaLibre();
        c.ocupar();
        Thread.sleep(3000); // 3 segundos para pagar
        c.soltar();
        this.pagado = true;
        logger.info("Coche " + id + " a pagado");
    }

}
