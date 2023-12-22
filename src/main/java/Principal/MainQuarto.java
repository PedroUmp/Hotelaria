package Principal;

import Classes.Quarto;
import Exceptions.EntidadeNaoEncontradaException;
import Services.ClienteService;
import Services.QuartoService;

import java.util.List;
import java.util.Scanner;

public class MainQuarto {
    public static void main() throws EntidadeNaoEncontradaException {

        //nao entendi service
        QuartoService quartoService = new QuartoService();

        int id;
        int numero;
        int valorDiaria;
        Quarto quarto = new Quarto();

        boolean continua = true;
        int escolha;
        Scanner input = new Scanner(System.in);

        while (continua) {
            System.out.println('\n' + "========================================================");
            System.out.println('\n' + "O que você deseja fazer?");
            System.out.println('\n' + "1 - Cadastrar um quarto");
            System.out.println("2 - Alterar o quarto");
            System.out.println("3 - Remover um quarto");
            System.out.println("4 - Listar todos os quartos");
            System.out.println("5 - Voltar");

            escolha = input.nextInt();

            switch (escolha) {
                case 1: {
                    System.out.println("Informe o numero do quarto: \n");
                    numero = input.nextInt();
                    System.out.println("Informe o valor da diária desse quarto: \n");
                    valorDiaria = input.nextInt();
                    Quarto novoQuarto = new Quarto(numero, valorDiaria);
                    quartoService.incluir(novoQuarto);
                    break;
                }

                case 2: {
                    System.out.println("Informe o id do quarto \n");
                    id = input.nextInt();

                    try {
                        quarto = quartoService.recuperarQuartoPorId(id);
                    } catch (EntidadeNaoEncontradaException e) {
                        System.out.println("Cliente não está na base de dados");
                        break;
                    }

                        System.out.println("O que você deseja alterar: \n");
                        System.out.println("1 - Valor da diária");
                        System.out.println("2 - Número do quarto");
                        int escolha2 = input.nextInt();

                        switch (escolha2) {
                            case 1: {
                                System.out.println("Informe o novo valor da diária \n");
                                valorDiaria = input.nextInt();
                                quarto.setValorDiaria(valorDiaria);
                                break;
                            }
                            case 2: {
                                System.out.println("Informe o novo número do quarto \n");
                                numero = input.nextInt();
                                quarto.setNumero(numero);
                                break;
                            }
                        }
                        break;
                    }

                    case 3: {
                        System.out.println("Informe o id do quarto \n");
                        numero = input.nextInt();
                        quartoService.removerQuarto(numero);
                        break;
                    }

                    case 4: {
                        quartoService.imprimirQuartos();
                        break;
                    }

                    case 5: {
                        continua = false;
                        break;
                    }

                    default:
                        System.out.println("Opção Invalida");
                        break;
                }
            }
        }

    }

