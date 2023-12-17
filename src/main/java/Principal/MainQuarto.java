package Principal;

import Classes.Quarto;
import Services.ClienteService;
import Services.QuartoService;

import java.util.List;
import java.util.Scanner;

public class MainQuarto {
    public static void main() {

        //nao entendi service
        QuartoService quartoService = new QuartoService();
        ClienteService clienteService = new ClienteService();

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
            System.out.println("4 - Listar todos quarto");
            System.out.println("5 - Voltar");

            escolha = input.nextInt();

            switch(escolha) {
                case 1: {
                    System.out.println("Informe o numero do quarto: \n");
                    numero = input.nextInt();
                    System.out.println("Informe o valor da diária desse quarto: \n");
                    valorDiaria = input.nextInt();
                    Quarto novoQuarto = new Quarto(numero, valorDiaria);
                    //quartoService.inserir(quarto)
                }
                case 2: {
                    System.out.println("O que você deseja alterar: \n");
                    System.out.println("1 - Valor da diária");
                    System.out.println("2 - Cliente no quarto");
                    int escolha2 = input.nextInt();

                    switch (escolha2) {
                        case 1: {
                            System.out.println("Informe o numero do quarto \n");
                            numero = input.nextInt();
                            System.out.println("Informe o novo valor da diária \n");
                            valorDiaria = input.nextInt();

                            //quarto = quartoService.recuperarQuartoPorNumero(numero)
                            quarto.setValorDiaria(valorDiaria);

                        }
                        case 2: {
                            System.out.println("Informe o numero do quarto \n");
                            numero = input.nextInt();
                            System.out.println("Informe o nome do novo Cliente \n");
                            //cliente = clienteService.recupearPorNome;
                        }
                    }

                }
                case 3: {
                    System.out.println("Informe o numero do quarto \n");
                    numero = input.nextInt();
                    //quartoService.remover(numero);
                }
                case 4: {
//                    List<Quarto> quartos = quartoService.recuperarTodos();
//                    for (Quarto q : quartos) {
//                        System.out.println(quarto);
//                    }
                }
                case 5: {
                    continua = false;
                }
                default: System.out.println("Opção Invalida");
            }
        }

    }
}
