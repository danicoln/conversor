package oracleone.challenge.conversor.domain.model;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Conversor extends Component {

    private double moedaValor;
    private double moedaPar;

    public Conversor(double moedaValor, double moedaPar) {
        this.moedaValor = moedaValor;
        this.moedaPar = moedaPar;
    }

    public Conversor() {
    }

    public void calcularDeBrlParaMoedaEstrangeira() {
        double conversao = moedaValor / moedaPar;

        JOptionPane.showMessageDialog(null, " Valor convertido " + conversao);

    }

    public void calcularDeMoedaEstrangeiraParaBrl() {
        double conversao = moedaValor * moedaPar;

        JOptionPane.showMessageDialog(null, " Valor convertido " + formatar(conversao));

    }

    public String formatar(double valor) {
        NumberFormat numeroFormatado = NumberFormat.getNumberInstance(Locale.getDefault());
        Currency currency = numeroFormatado.getCurrency();
        String vlrFormatado = numeroFormatado.format(valor);
        return currency + vlrFormatado;
    }

    public double getMoedaValor() {
        return moedaValor;
    }

    public void setMoedaValor(double moedaValor) {
        this.moedaValor = moedaValor;
    }

    public double getMoedaPar() {
        return moedaPar;
    }

    public void setMoedaPar(double moedaPar) {
        this.moedaPar = moedaPar;
    }

}
