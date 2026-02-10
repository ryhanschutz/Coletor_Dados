package Logica_Automacao;//package Logica_Automacao;
import java.util.Random;

/*
    PROJETO: Coletor de Dados de automação
    OBJETIVO: Exemplificar a coleta, tratamento e validação de dados industriais.

*/

public class Main {
    //O metodo "Main" é o ponto de partida. Tudo começa aqui!

    public static void main(String[] args) {
    //Exibissão do cabeçalho: Simula a inicialização do sistema

        System.out.println("=============================");
        System.out.println("SISTEMA DE MONITORAMENTO INDUSTRIAL - V01");
        System.out.println("=============================");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Lendo os dados do processo - Ciclo:" + i + ".");

            double valorTemperatura = lerSensor("Temperatura Forno 01");

            validarDadosSec("Temperatura", valorTemperatura, 20, 80);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Erro no temporizador");
            }

        }
    }
    public static double lerSensor (String tag) {
        Random gerador = new Random();

        //Gerar de fato um numero entre 10.0 e 100.

        double valorlid = 10 + ( 100 - 10) * gerador.nextDouble();

        return valorlid;
    }
    public static void validarDadosSec(String nomeSensor, double valor, double min, double max) {

        System.out.printf("Sensor: %s | Valor atual: %.2fC", nomeSensor, valor);

        if (valor >= min && valor <= max) {
            System.out.println(">> OPERAÇÃO NORMAL<<");

        } else {
            System.out.println(">> FORA DOS NÍVEIS DE SEGURANÇA<<");
        }
    }
}