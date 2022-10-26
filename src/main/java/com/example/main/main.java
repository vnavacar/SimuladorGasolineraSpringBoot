package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.main.Gasolinera.Coche;
import com.example.main.Gasolinera.Surtidor;




@SpringBootApplication
public class main {

	public static void main(String[] args) {
		SpringApplication.run(main.class, args);
		for(int i = 0; i < 50; i++){
			Coche coche = new Coche(i);
			
		}
		for(int i= 0; i< 5; i++){
			Surtidor surtidor = new Surtidor();
			surtidor.start();
		}
	}

}
