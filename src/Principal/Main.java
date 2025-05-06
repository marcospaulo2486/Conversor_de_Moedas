
import Modelagem.Calculo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Calculo conversor = new Calculo();
        String opcao = "";

        while (!opcao.equalsIgnoreCase("7")) {
            System.out.println("""
                    *****************************************************************
                    Bem vindo ao Conversor de Moedas, Insira sua opção conforme
                    o número listado:
                    1 - Dollar => Real;
                    2 - Peso Argentino => Dollar;
                    3 - Dollar => Peso Chileno.
                    4 - Real => Peso Boliviano.
                    5 - Euro => Peso Argentino.
                    6 - Euro => Real.
                    7 - Sair.
                    
                    *****************************************************************
                    """);

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextLine();

            // Verificamos a opção selecionada
            switch (opcao) {
                case "1" -> System.out.println("Você escolheu: Dollar => Real");
                case "2" -> System.out.println("Você escolheu: Peso Argentino => Dollar");
                case "3" -> System.out.println("Você escolheu: Dollar => Peso Chileno");
                case "4" -> System.out.println("Você escolheu: Real => Peso Boliviano");
                case "5" -> System.out.println("Você escolheu: Euro => Peso Argentino");
                case "6" -> System.out.println("Você escolheu: Euro => Real");
                case "7" -> {
                    System.out.println("Encerrando o programa. Até logo!");
                    break;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

            try {
                if (!opcao.equals("7") && !opcao.isEmpty()) {
                    double valor = 0;
                    if (!opcao.matches("[1-7]")) {
                        continue; // Pula para a próxima iteração se a opção for inválida
                    }

                    System.out.print("Digite o valor a ser convertido: ");
                    valor = scanner.nextDouble();
                    scanner.nextLine(); // Consome a nova linha pendente

                    switch (opcao) {
                        case "1" -> {
                            System.out.printf("Você inseriu o valor: %.2f USD para converter em BRL\n", valor);
                            conversor.USDtoBRL(valor);
                        }
                        case "2" -> {
                            System.out.printf("Você inseriu o valor: %.2f ARS para converter em USD\n", valor);
                            conversor.ARStoUSD(valor);
                        }
                        case "3" -> {
                            System.out.printf("Você inseriu o valor: %.2f USD para converter em CLP\n", valor);
                            conversor.USDtoCLP(valor);
                        }
                        case "4" -> {
                            System.out.printf("Você inseriu o valor: %.2f BRL para converter em BOB\n", valor);
                            conversor.BRLtoBOB(valor);
                        }
                        case "5" -> {
                            System.out.printf("Você inseriu o valor: %.2f EUR para converter em ARS\n", valor);
                            conversor.EURtoARS(valor);
                        }
                        case "6" -> {
                            System.out.printf("Você inseriu o valor: %.2f EUR para converter em BRL\n", valor);
                            conversor.EURtoBRL(valor);
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite apenas números.");
                scanner.nextLine(); // Limpa o buffer do scanner
            } catch (RuntimeException e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
        scanner.close();
    }
}