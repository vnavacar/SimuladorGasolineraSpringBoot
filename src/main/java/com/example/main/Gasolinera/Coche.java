package com.example.main.Gasolinera;

public class Coche {
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
        System.out.println("Coche " + id + " repostado");
    }
    public void pagar() {
        this.pagado = true;
        System.out.println("Coche " + id + " pagado");
    }

}
