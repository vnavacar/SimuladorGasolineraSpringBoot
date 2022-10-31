package com.example.main.Gasolinera;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Coche extends Thread{
    private static Logger logger = LoggerFactory.getLogger(Coche.class);
    boolean repostado;
    boolean pagado;
    carManager manager;
    public static int id = 0 ;
    {
        id++;
    }

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
                    autodestruirse();
                }
            }catch(InterruptedException e){
                logger.error(e.getMessage(), e);
            }
        }

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
        try {
            Caja c = manager.buscaCajaLibre();
            c.ocupar();
            logger.info(getName()+" esta pagando");
            Thread.sleep((int)(Math.random()*5+5)*1000); // entre 5 y 10 segundos de pago
            c.soltar();
            this.pagado = true;
            logger.info("Coche " + id + " pagado");
        } catch (Exception e) {
            //logger.error(e.getMessage() + "Caja libre no encontrada, volvera a intentar", e);
            logger.error("Caja libre no encontrada, volvera a intentar");
            Thread.sleep(5000);
        }
    }

    public void autodestruirse() throws InterruptedException{
        logger.info("Coche " + id + " ha salido");
        System.exit(0);
    }

}
