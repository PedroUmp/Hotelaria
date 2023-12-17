package Principal;

import Classes.Cliente;
import Exceptions.EntidadeNaoEncontradaException;
import Services.ClienteService;

import java.util.List;
import java.util.Scanner;

public class MainCliente {
    public static void main() throws EntidadeNaoEncontradaException {

        ClienteService clienteService = new ClienteService();

        boolean continua = true;
        int escolha;
        Scanner input = new Scanner(System.in);

        String nome;
        int id;
        Cliente cliente = new Cliente();



        while (continua) {
            System.out.println('\n' + "========================================================");
            System.out.println('\n' + "O que você deseja fazer?");
            System.out.println('\n' + "1 - Cadastrar um cliente");
            System.out.println("2 - Alterar o nome de um cliente");
            System.out.println("3 - Remover um cliente");
            System.out.println("4 - Listar todos os clientes");
            System.out.println("5 - Voltar");

            escolha = input.nextInt();


            switch (escolha) {
                case 1: {
                    System.out.println("Qual o nome do cliente");
                    nome = input.next();
                    Cliente novoCliente = new Cliente(nome);
                    clienteService.incluir(novoCliente);
                    System.out.printf("Cliente %s inserido com sucesso", novoCliente.getNome());
                    break;
                }

                case 2: {
                    System.out.println("Informe o id do cliente: \n");
                    id = input.nextInt();
                    cliente = clienteService.recuperarClientePorId(id);
                    System.out.println("Qual será o novo nome");
                    nome = input.next();
                    cliente.setNome(nome);
                    break;
                }

                case 3: {
                    System.out.println("Remover por nome (1) ou por id (2)?");
                    int escolha2 = input.nextInt();

                    switch (escolha2) {

                        case 1: {
                            System.out.println("Informe o nome do cliente: \n");
                            nome = input.next();
                            try {
                                id = clienteService.recuperarPorNome(nome);
                                clienteService.removerCliente(id);
                            } catch (EntidadeNaoEncontradaException e) {
                                System.out.println("Cliente não está na base de dados");
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Informe o id do cliente: \n");
                            id = input.nextInt();
                            try {
                                clienteService.removerCliente(id);
                            } catch (EntidadeNaoEncontradaException e) {
                                System.out.println("Cliente não está na base de dados");
                                break;
                            }
                        }
                        break;
                    }
                }

                case 4: {
                    List<Cliente> clientes = clienteService.recuperarClientes();
                    for (Cliente c : clientes) {
                        System.out.println(c);
                    }
                    break;
                }
                case 5: {
                    continua = false;
                    break;
                }
                default: System.out.println("Opção Invalida");
            }
        }

    }
}