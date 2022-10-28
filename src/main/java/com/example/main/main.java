package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.main.Gasolinera.Coche;
import com.example.main.Gasolinera.Surtidor;
import com.example.main.Gasolinera.carManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class main {
	private static Logger logger = LoggerFactory.getLogger(main.class);



	public static void main(String[] args) {
		SpringApplication.run(main.class, args);


		carManager lanzador = new carManager(10, 3000);
		Thread jornada = new Thread(lanzador);
		logger.info("Iniciando jornada");
		jornada.start();
		
		
	}

}
