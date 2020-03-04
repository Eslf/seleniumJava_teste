package com.test.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestWebservice {
	
	public static void main(String[] args) throws IOException {
		
//		MyGETRequest();
		swAPI_getRequest();
		
	}
	
	public static void swAPI_getRequest() {
		try {

			URL url = new URL("https://swapi.co/api/films/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Erro HTTP, codigo: "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			JsonFactory factory = new JsonFactory();
			JsonParser parser = factory.createParser(br);
			ObjectMapper mapper = new ObjectMapper();
			Map obj = mapper.readValue(parser,Map.class);
			
			ArrayList<Map> mapa = (ArrayList<Map>) obj.get("results");
			
			ArrayList<Result> resultados_array = new ArrayList<Result>();
			
			for (Map<Object,String> filme : mapa) {
				Result resultados = new Result();
				resultados.setTitle(filme.get("title"));
				resultados.setDirector(filme.get("director"));
				resultados.setProducer(filme.get("producer"));
				resultados_array.add(resultados);
			}
			System.out.println("\nImprimindo o resultados_array:\n");
			for (Result re:resultados_array) {
				if (re.getDirector().equals("George Lucas") && re.getProducer().contains("Rick McCallum")) {
					System.out.println(re.getTitle());
				}
				
			}
			

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
	}
	
}
