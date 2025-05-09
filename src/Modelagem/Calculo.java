package Modelagem;

import java.util.Map;
import MapKeyValue.MapGson;

public class Calculo {
    private final Request cambiar;
    public Calculo() {
        this.cambiar = new Request ();
    }
    public double USDtoBRL(double USD) throws Exception {//OP1
        MapGson taxas = cambiar.getConversion("USD");
        Map<String, Double> apreciacao = taxas.getConversionRates();

        double convert = apreciacao.get("BRL");
        double resultado = USD * convert;
        System.out.println("\nValor em Real:" + resultado);
        return resultado;
    }
    public double ARStoUSD(double ARS) throws Exception {//OP2
        //Pegar moeda origem;
        MapGson taxas = cambiar.getConversion("ARS");
        Map<String, Double> apreciacao = taxas.getConversionRates();
        //Pegar moeda destino e converter.
        double convert = apreciacao.get("USD");
        double resultado = ARS * convert;
        System.out.println("Valor em Dólar:" + resultado);
        return resultado;
    }

    public double USDtoCLP(double USD) throws Exception {//op3
        MapGson taxas = cambiar.getConversion("USD");
        Map<String, Double> apreciacao = taxas.getConversionRates();

        double convert = apreciacao.get("CLP");
        double resultado = USD * convert;
        System.out.println("\nValor em Pesos Chilenos:" + resultado);
        return resultado;
    }

    public double BRLtoBOB (double BRL) throws Exception{//OP4

        MapGson taxas = cambiar.getConversion("BRL");
        Map<String, Double> apreciacao = taxas.getConversionRates();

        double convert = apreciacao.get("BOB");
        double resultado = BRL * convert;
        System.out.println("Valor em Bolivianos:" + resultado);
        return resultado;
    }
    public double EURtoARS(double EUR) throws Exception{//OP5
        MapGson taxas = cambiar.getConversion("EUR");
        Map<String, Double> apreciacao = taxas.getConversionRates();

        double convert = apreciacao.get("ARS");
        double resultado = EUR * convert;
        System.out.println("Valor em Pesos Argentinos:   " + resultado);
        return resultado;
    }
    public double EURtoBRL(double EUR) throws Exception{//op6
        MapGson taxas = cambiar.getConversion("EUR");
        Map<String, Double> apreciacao = taxas.getConversionRates();

        double convert = apreciacao.get("BRL");
        double resultado = EUR * convert;
        System.out.println("Valor em Real:   " + resultado);
        return resultado;
    }}