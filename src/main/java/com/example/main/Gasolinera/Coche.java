package com.example.main.Gasolinera;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Coche extends Thread{
    private static Logger logger = LoggerFactory.getLogger(Coche.class);
    boolean repostado;
    boolean pagado;
    int id;

    public Coche(int id) {
        this.repostado = false;
        this.pagado = false;
        this.id = id;
    }

    public void repostado() {
        this.repostado = true;
        //System.out.println("Coche " + id + " repostado");
        logger.info("Coche " + id + " repostado");
    }
    public void pagar() {
        this.pagado = true;
        //System.out.println("Coche " + id + " pagado");
        logger.info("Coche " + id + " pagado");
    }

}
