package oracleone.challenge.conversor.domain.service;

import oracleone.challenge.conversor.domain.model.Conversor;
import oracleone.challenge.conversor.domain.model.Moeda;

public class ConversorService {

    //Para converter um valor em reais para dolar:
    // precisa informar o valor do dólar em reais
    //Ex:
    //Valor a converter: 100,00 reais
    // Se 1,00 dolar, está 5,00 reais, o valor convertido será de US$ 20,00

    private void converterRealParaMoeda(double valorConverter, String parMoeda) throws Exception {
        //verifica valor do dolar
        Moeda moeda = CotacaoMoedaService.buscaMoedaPeloCodigo(parMoeda);
        double valorParMoeda = moeda.getBid();
        conversorMoedaEstrangeira(valorConverter, valorParMoeda);
    }
    private void converterMoedaParaReal(String moeda, double parMoeda) throws Exception {
        Moeda novaMoeda = CotacaoMoedaService.buscaMoedaPeloCodigo(moeda);
        Double valorMoeda = novaMoeda.getBid();
        conversorReal(parMoeda, valorMoeda);
    }
    private void conversorMoedaEstrangeira(double moeda, double parMoeda){
        Conversor conversor = new Conversor(moeda, parMoeda);
        conversor.calcularDeBrlParaMoedaEstrangeira();
    }
    private void conversorReal(double moeda, double parMoeda){
        Conversor conversor = new Conversor(moeda, parMoeda);
        conversor.calcularDeMoedaEstrangeiraParaBrl();
    }

    public void deBrl_Usd(double valorConverter, String parMoeda) throws Exception {
        converterRealParaMoeda(valorConverter, parMoeda);
    }
    public void deBrl_Eur(double valorConverter, String parMoeda) throws Exception {
        converterRealParaMoeda(valorConverter, parMoeda);

    }
    public void deBrl_Gbp(double valor, String parMoeda) throws Exception {
        converterRealParaMoeda(valor, parMoeda);
    }
    public void deBrl_Ars(double valor, String parMoeda) throws Exception {
        converterRealParaMoeda(valor, parMoeda);

    }

    public void deBrl_Clp(double valor, String parMoeda) throws Exception {
        converterRealParaMoeda(valor, parMoeda);
    }

    public void deUsd_Brl(String usd, double valor) throws Exception {
        converterMoedaParaReal(usd, valor);
    }

    public void deEur_Brl(String eur, double valor) throws Exception {
        converterMoedaParaReal(eur, valor);
    }

    public void deGbp_Brl(String gbp, double valor) throws Exception {
        converterMoedaParaReal(gbp, valor);
    }

    public void deArs_Brl(String ars, double valor) throws Exception {
        converterMoedaParaReal(ars, valor);
    }

    public void deClp_Brl(String clp, double valor) throws Exception {
        converterMoedaParaReal(clp, valor);
    }
}
