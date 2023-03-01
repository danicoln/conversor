package oracleone.challenge.conversor.domain.service;

import com.google.gson.Gson;
import oracleone.challenge.conversor.domain.model.Moeda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CotacaoMoedaService {
    static String webService = "https://economia.awesomeapi.com.br/json/";
    private static Moeda novaMoeda;
    public static Moeda buscaMoedaPeloCodigo(String codigo) throws Exception {
        String urlParaChamada = webService + codigo;

        try {
            URL url = new URL(urlParaChamada);
            URLConnection conexao = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String str = "";
            List<String> jsonMoedas = new ArrayList<>();

            while((str = reader.readLine()) != null){
                jsonMoedas.add(str);
            }

            //regex
            String string = jsonMoedas.toString().replaceAll("[\\[\\]]","");

            Moeda moedaJson = new Gson().fromJson(string,Moeda.class);

            novaMoeda = new Moeda(moedaJson.getCode(), moedaJson.getBid());

            return novaMoeda;

        } catch (Exception e) {
            throw new Exception("Erro: " + e);
        }
    }

}
