package oracleone.challenge.conversor;

import oracleone.challenge.conversor.rest.controller.MenuMoedaController;

import javax.swing.*;

/**
 * Tela principal do programa
 */

public class TelaPrincipal {
    public static void main(String[] args) throws Exception {

        /**Caixa de diálogo que permite o usuário escolher entre as opções de conversão.
         * */

        boolean continua = true;
        do {
            String[] opcoes = {"Conversor de Moeda",
                    //"Conversor de Temperatura",
                    //"Conversor de Km"
            };

            String entrada = JOptionPane.showInputDialog(
                    null,
                    "Escolha uma opção:",
                    "Sistema de Conversão",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes, opcoes[0]).toString();

            if (entrada.equals("Conversor de Moeda")) {
                MenuMoedaController menuMoeda = new MenuMoedaController();
                menuMoeda.conversorDeMoeda();

                /**Tarefa: Nosso cliente quer que nosso usuário decida que ele quer fazer depois de executar a primeira conversão. Apresentamos as seguintes opções:

                 Yes: deve trazer nosso usuário novamente para o menu principal.
                 No: Você deve mostrar uma mensagem "Programa finalizado"
                 Cancel: Você deve mostrar uma mensagem de "Programa concluído"

                 Utilizar o método showConfirmDialog para o usuário que deseja seguir no programa. */

                int continuar = JOptionPane.showConfirmDialog(
                        null,
                        "Deseja continuar?",
                        "Sistema de Conversão",
                        JOptionPane.YES_NO_CANCEL_OPTION);

                if (continuar == 1) {
                    continua = false;
                    JOptionPane.showMessageDialog(
                            null,
                            "Programa finalizado",
                            "Informação",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                } else if (continuar == 2) {
                    continua = false;
                    JOptionPane.showMessageDialog(
                            null,
                            "Programa concluído!",
                            "Informação",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

            } else if (entrada.equals("Conversor de Temperatura")) {
                System.out.println("IMPLEMENTAR: Conversor de temperatura");
            } else if (entrada.equals("Conversor de Km")) {
                System.out.println("IMPLEMENTAR: Conversor de km");
            }
        } while (continua);
    }
}
