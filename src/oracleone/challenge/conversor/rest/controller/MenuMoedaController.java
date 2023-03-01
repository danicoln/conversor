package oracleone.challenge.conversor.rest.controller;

import oracleone.challenge.conversor.domain.service.ConversorService;

import javax.swing.*;

/**
 * Esta classe se refere ao menu de opções de conversões
 *
 * @author Daniel Lincoln
 * @since 23/02/2023
 */
public class MenuMoedaController {


    private ConversorService conversorService = new ConversorService();


    /**
     * Método que faz a conversão de moeda de acordo com a opção escolhida
     */
    public void conversorDeMoeda() throws Exception {
        try {

            String inserirValor = (JOptionPane.showInputDialog(
                    "Informe o valor que será convertido:"));

            //======================Tratamento de erro========================
            /**Backlog
             * No cartão Criar caixa de dialogo especificamos que outros tipos de caracteres que não são números
             * não devem ser permitidos, agora se o usuário digitar em letras ou caracteres especiais e pressionar OK,
             * deve ser mostrado uma mensagem apontando que o valor não é válido.*/

            double valor = 0;
            try {
                valor = Double.parseDouble(inserirValor);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Caracteres inválidos. Tente novamente!",
                        "Ops!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] opcao = {
                    "Moeda estrangeira para BRL",
                    "BRL para moeda estrangeira"
            };
            String entrada = JOptionPane.showInputDialog(
                    null,
                    "Informe qual a opção de conversão você quer fazer",
                    "Menu",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcao,
                    opcao[0]).toString();


            if (entrada.equals("BRL para moeda estrangeira")) {
                String[] opcoes = {
                        "Converter de BRL para USD",
                        "Converter de BRL para EUR",
                        "Converter de BRL para GBP",
                        "Converter de BRL para ARS",
                        "Converter de BRL para CLP"};
                String inputMsg = JOptionPane.showInputDialog(
                        null,
                        "BRL para Moeda estrangeira. Escolha a opção:",
                        "BRL para moeda estrangeira",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]).toString();

                if (inputMsg.equals("Converter de BRL para USD")) {
                    conversorService.deBrl_Usd(valor, "USD");

                } else if (inputMsg.equals("Converter de BRL para EUR")) {
                    conversorService.deBrl_Eur(valor, "EUR");

                } else if (inputMsg.equals("Converter de BRL para GBP")) {
                    conversorService.deBrl_Gbp(valor, "GBP");

                } else if (inputMsg.equals("Converter de BRL para ARS")) {
                    conversorService.deBrl_Ars(valor, "ARS");

                } else if (inputMsg.equals("Converter de BRL para CLP")) {
                    conversorService.deBrl_Clp(valor, "CLP");
                }

            } else if (entrada.equals("Moeda estrangeira para BRL")) {
                String[] opcoes = {
                        "Converter USD para BRL",
                        "Converter EUR para BRL",
                        "Converter GBP para BRL",
                        "Converter ARS para BRL",
                        "Converter CLP para BRL"};
                String inputMsg = JOptionPane.showInputDialog(
                        null,
                        "Moeda estrangeira para BRL. Escolha a opção:",
                        "De moeda estrangeira para BRL",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]).toString();

                if (inputMsg.equals("Converter USD para BRL")) {
                    conversorService.deUsd_Brl("USD", valor);

                } else if (inputMsg.equals("Converter EUR para BRL")) {
                    conversorService.deEur_Brl("EUR", valor);

                } else if (inputMsg.equals("Converter GBP para BRL")) {
                    conversorService.deGbp_Brl("GBP", valor);

                } else if (inputMsg.equals("Converter ARS para BRL")) {
                    conversorService.deArs_Brl("ARS", valor);

                } else if (inputMsg.equals("Converter CLP para BRL")) {
                    conversorService.deClp_Brl("CLP", valor);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
