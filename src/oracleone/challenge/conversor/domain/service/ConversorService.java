package oracleone.challenge.conversor.domain.service;

import oracleone.challenge.conversor.domain.model.Conversor;
import oracleone.challenge.conversor.domain.model.Moeda;

/**
 * Esta classe faz o serviço das conversões de moedas
 *
 * @author Daniel Lincoln
 * @since 01/03/2023
 *
 */
public class ConversorService {

    /**
     * Este método faz a conversão da moeda real para a moeda estrangeira que é escolhida
     * @param valorConverter se refere ao valor que será convertido
     * @param parMoeda se refere a moeda no qual será convertida
     * @throws Exception
     */
    private void converterRealParaMoeda(double valorConverter, String parMoeda) throws Exception {
        Moeda moeda = CotacaoMoedaService.buscaMoedaPeloCodigo(parMoeda);
        double valorParMoeda = moeda.getBid();
        conversorMoedaEstrangeira(valorConverter, valorParMoeda);
    }

    /**
     *  Este método faz a conversão da moeda estrangeira para o real brasileiro
     * @param moeda se refere de qual moeda será feita a conversão
     * @param parMoeda se refere ao valor que será calculado a conversão
     * @throws Exception
     */
    private void converterMoedaParaReal(String moeda, double parMoeda) throws Exception {
        Moeda novaMoeda = CotacaoMoedaService.buscaMoedaPeloCodigo(moeda);
        Double valorMoeda = novaMoeda.getBid();
        conversorReal(parMoeda, valorMoeda);
    }

    /**
     * Este método pega a informação dos valores e faz a conversão usando o método do conversor
     * @param moeda valor que será calculado
     * @param parMoeda valor que será calculado
     */
    private void conversorMoedaEstrangeira(double moeda, double parMoeda) {
        Conversor conversor = new Conversor(moeda, parMoeda);
        conversor.calcularDeBrlParaMoedaEstrangeira();
    }

    /**
     * Este método pega a informação dos valores e faz a conversão usando o método do conversor
     * @param moeda valor que será calculado
     * @param parMoeda valor que será calculado
     */
    private void conversorReal(double moeda, double parMoeda) {
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
