package com.series;

import com.series.model.DadosTemporada;
import com.series.principal.ClassePrincipal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SeriesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SeriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ClassePrincipal principal = new ClassePrincipal();
		principal.exibeMenu();
	}
}