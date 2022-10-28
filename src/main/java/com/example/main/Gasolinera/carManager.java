package com.example.main.Gasolinera;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class carManager implements Runnable{

    private List<Coche> coches;
    private List<Surtidor> surtidores;
    //private List<Caja> cajas;	
    private Caja cajas;

    int t;
    int cochesALanzar;
    
    public carManager(int cochesALanzar, int tiempoEntreCoche) {
        this.cochesALanzar = cochesALanzar;
        this.t= tiempoEntreCoche;

        this.surtidores = new ArrayList<>(4);
        this.coches = new LinkedList<>();

        for(int i = 0; i < 5; i++){
            Surtidor s = new Surtidor();
            this.surtidores.add(s);
        }
        for(int i = 0; i < cochesALanzar; i++){
            Coche c = new Coche(this);
            this.coches.add(c);
        }

        //for(int i = 0; i < 1; i++){
            //Caja c = new Caja();
            //this.cajas.add(c);
        //}
        this.cajas = new Caja();

    }

    public Surtidor buscaSurtidorLibre(){
        for(Surtidor s: surtidores){
            if(!s.cerrojo.isLocked()){
                return s;
            }
        }
        return null;
    }

    public Caja buscaCajaLibre(){
        /*for(Caja c: cajas){
            if(!c.cerrojo.isLocked()){
                return c;
            }
        }
        return null;*/
        if(!cajas.cerrojo.isLocked()){
            return cajas;
        }
        return null;
    }

    public void run() {
        /* 
        for(int i = 0; i < cochesALanzar; i++){
            try{
                Thread.sleep(t);
                Coche coche = new Coche(i);
                coche.run();
            }catch(InterruptedException e){
                e.printStackTrace();
            }



        }*/
        ExecutorService executor = Executors.newFixedThreadPool(coches.size());
        for(Coche c : coches){
            executor.execute(c);
            try{
                Thread.sleep(t);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }
    
}
