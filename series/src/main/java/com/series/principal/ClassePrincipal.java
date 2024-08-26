package com.series.principal;

import com.series.model.DadosEpisodio;
import com.series.model.DadosSerie;
import com.series.model.DadosTemporada;
import com.series.service.ConsumoAPI;
import com.series.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassePrincipal {
        private Scanner leitura= new Scanner(System.in);
        private ConsumoAPI consumoApi = new ConsumoAPI();
        private ConverteDados conversor = new ConverteDados();
        private final String ENDERECO = "https://www.omdbapi.com/?t=";
        private final String API_KEY= "&apikey=6585022c";
        public void exibeMenu(){
            System.out.println("Digite o nome da série para a busca");
            var nomeSerie = leitura.nextLine();
            var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" " , "+") + API_KEY);
            DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
            System.out.println(dados);
            		List<DadosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i<= dados.totalTemporadas(); i++){
			json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" " , "+")+"&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

//            for (int i = 0; i < dados.totalTemporadas(); i++) {
//                List<DadosEpisodio> episodioTemporada = temporadas.get(i).episodios();
//                for (int j = 0; j< episodioTemporada.size(); j++){
//                    System.out.println(episodioTemporada.get(j).titulo());
//                }
//            }
            temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
	}
    
}


