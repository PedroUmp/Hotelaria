package Principal;

import Exceptions.EntidadeNaoEncontradaException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EntidadeNaoEncontradaException {

        Scanner input = new Scanner(System.in);
        int escolha;
        boolean continua = true;

        while(continua) {

        System.out.println("Qual classe você deseja tratar: ");
        System.out.println("1 - Cliente");
        System.out.println("2 - Quarto");
        System.out.println("3 - Hospedagem");
        System.out.println("4 - Ocupação");
        System.out.println("5 - Fechar programa");

        escolha = input.nextInt();

            switch (escolha) {
                case 1: {
                    MainCliente.main();
                    System.out.println(escolha);
                    break;
                }
                case 2: {
                    MainQuarto.main();
                    break;
                }
                case 3: {
                    MainHospedagem.main();
                    break;
                }
                case 4: {
                    MainOcupacao.main();
                    break;
                }
                case 5: {
                    continua = false;
                }
                default:
                    System.out.println("Opção invalida");
            }
        }

    }
}