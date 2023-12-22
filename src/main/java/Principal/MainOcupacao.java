package Principal;

import Classes.Cliente;
import Classes.Ocupacao;
import Classes.Quarto;
import Exceptions.EntidadeNaoEncontradaException;
import Services.ClienteService;
import Services.OcupacaoService;
import Services.QuartoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainOcupacao {
    public static void main() throws EntidadeNaoEncontradaException, ParseException {

        OcupacaoService ocupacaoService = new OcupacaoService();
        QuartoService quartoService = new QuartoService();
        ClienteService clienteService = new ClienteService();

        boolean continua = true;
        Scanner input = new Scanner(System.in);
        int escolha;
        int escolha2;

        Cliente cliente;
        Quarto quarto;
        Ocupacao ocupacao;
        int id;
        Date data;
        String inputData;

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        while (continua) {
            System.out.println("========================================================");
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Cadastrar uma ocupação");
            System.out.println("2 - Alterar uma Ocupação");
            System.out.println("3 - Remover uma ocupação");
            System.out.println("4 - Lista as ocupações");
            System.out.println("5 - Voltar");

            escolha = input.nextInt();
            switch (escolha) {
                case 1: {
                    System.out.println("1: Cadastrar através de um cliente já existente");
                    System.out.println("2: Cadastrar através de um quarto já existente");
                    System.out.println("3: Cadastrar através de clientes e quartos existentes");
                    System.out.println("4: Cadastrar sem clientes e quartos");
                    escolha2 = input.nextInt();

                    switch (escolha2) {
                        case 1: {
                            System.out.println("Os seguintes clientes estão na base de dados:");
                            clienteService.imprimirClientes();
                            System.out.println("Qual o id do Cliente");
                            id = input.nextInt();
                            try {
                                cliente = clienteService.recuperarClientePorId(id);
                            } catch (EntidadeNaoEncontradaException e) {
                                System.out.println("Cliente não encontrado");
                                break;
                            }

                            System.out.println("Qual a data de início (dd/MM/yyyy)?");
                            String inputDataInicio = input.next();

                            System.out.println("Qual a data de término (dd/MM/yyyy)?");
                            String inputDataFim = input.next();

                            try {
                                Date dataInicio = formatoData.parse(inputDataInicio);
                                Date dataFim = formatoData.parse(inputDataFim);

                                ocupacao = new Ocupacao(cliente, dataInicio, dataFim);
                                ocupacaoService.incluirOcupacao(ocupacao);
                                System.out.println("Ocupação criada com sucesso!");
                            } catch (ParseException ex) {
                                System.out.println("Formato de data inválido. Certifique-se de inserir no formato correto (dd/MM/yyyy).");
                                break;
                            }
                            break;

                        }

                        case 2: {
                            System.out.println("Os seguintes quartos estão na base de dados:");
                            quartoService.imprimirQuartos();
                            System.out.println("Qual o id do quarto");
                            id = input.nextInt();
                            try {
                                quarto = quartoService.recuperarQuartoPorId(id);
                            } catch (EntidadeNaoEncontradaException e) {
                                System.out.println("Quarto não encontrado");
                                break;
                            }

                            System.out.println("Qual a data de início (dd/MM/yyyy)?");
                            String inputDataInicio = input.next();

                            System.out.println("Qual a data de término (dd/MM/yyyy)?");
                            String inputDataFim = input.next();

                            try {
                                Date dataInicio = formatoData.parse(inputDataInicio);
                                Date dataFim = formatoData.parse(inputDataFim);


                                ocupacao = new Ocupacao(quarto, dataInicio, dataFim);
                                ocupacaoService.incluirOcupacao(ocupacao);
                                System.out.println("Ocupação criada com sucesso!");
                            } catch (ParseException ex) {
                                System.out.println("Formato de data inválido. Certifique-se de inserir no formato correto (dd/MM/yyyy).");
                                break;
                            }

                            break;
                        }

                        case 3: {
                            System.out.println("Os seguintes clientes estão na base de dados:");
                            clienteService.imprimirClientes();
                            System.out.println("Qual o id do Cliente");
                            id = input.nextInt();

                            try {
                                cliente = clienteService.recuperarClientePorId(id);
                            } catch (EntidadeNaoEncontradaException e) {
                                System.out.println("Cliente não encontrado");
                                break;
                            }

                            System.out.println("Qual o id do quarto");
                            System.out.println("Os seguintes quartos estão na base de dados:");
                            quartoService.imprimirQuartos();
                            id = input.nextInt();
                            try {
                                quarto = quartoService.recuperarQuartoPorId(id);
                            } catch (EntidadeNaoEncontradaException k) {
                                System.out.println("Quarto não encontrado");
                                break;
                            }

                            System.out.println("Qual a data de início (dd/MM/yyyy)?");
                            String inputDataInicio = input.next();

                            System.out.println("Qual a data de término (dd/MM/yyyy)?");
                            String inputDataFim = input.next();

                            try {
                                Date dataInicio = formatoData.parse(inputDataInicio);
                                Date dataFim = formatoData.parse(inputDataFim);

                                ocupacao = new Ocupacao(cliente, quarto, dataInicio, dataFim);
                                ocupacaoService.incluirOcupacao(ocupacao);
                                System.out.println("Ocupação criada com sucesso!");
                            } catch (ParseException ex) {
                                System.out.println("Formato de data inválido. Certifique-se de inserir no formato correto (dd/MM/yyyy).");
                            }
                            break;
                        }

                        case 4: {
                            System.out.println("Qual a data de início (dd/MM/yyyy)?");
                            String inputDataInicio = input.next();

                            System.out.println("Qual a data de término (dd/MM/yyyy)?");
                            String inputDataFim = input.next();

                            try {
                                Date dataInicio = formatoData.parse(inputDataInicio);
                                Date dataFim = formatoData.parse(inputDataFim);

                                ocupacao = new Ocupacao(dataInicio, dataFim);
                                ocupacaoService.incluirOcupacao(ocupacao);
                                System.out.println("Ocupação criada com sucesso!");
                            } catch (ParseException ex) {
                                System.out.println("Formato de data inválido. Certifique-se de inserir no formato correto (dd/MM/yyyy).");
                                break;
                            }
                            break;

                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Qual o id da ocupacao que você quer alterar?");
                    id = input.nextInt();
                    try {
                        ocupacao = ocupacaoService.recuperarOcupacaoPorId(id);
                    } catch (EntidadeNaoEncontradaException e) {
                        System.out.println("Essa ocupação não está na base de dados");
                        break;
                    }

                    System.out.println("O que você deseja alterar?");
                    System.out.println("1: Cliente associado");
                    System.out.println("2: Quarto associado");
                    System.out.println("3: Data de início");
                    System.out.println("4: Data de término");
                    escolha2 = input.nextInt();

                    switch (escolha2) {
                        case 1: {
                            System.out.println("Os seguintes clientes estão na base de dados:");
                            clienteService.imprimirClientes();
                            System.out.println("Qual o id do novo cliente?");
                            id = input.nextInt();
                            cliente = clienteService.recuperarClientePorId(id);
                            ocupacao.setCliente(cliente);
                            break;
                        }
                        case 2: {
                            System.out.println("Os seguintes quartos estão na base de dados:");
                            quartoService.imprimirQuartos();
                            System.out.println("Qual o id do novo quarto?");
                            id = input.nextInt();
                            quarto = quartoService.recuperarQuartoPorId(id);
                            ocupacao.setQuarto(quarto);
                            break;
                        }
                        case 3: {
                            System.out.println("Qual a nova data de início?");
                            inputData = input.next();
                            try {
                                data = formatoData.parse(inputData);
                            } catch (ParseException ex) {
                                System.out.println("Formato de data inválido");
                                break;
                            }
                            ocupacao.setDataInicio(data);
                            break;
                        }
                        case 4: {
                            System.out.println("Qual a nova data de fim?");
                            inputData = input.next();
                            try {
                                data = formatoData.parse(inputData);
                            } catch (ParseException ex) {
                                System.out.println("Formato de data inválido");
                                break;
                            }
                            ocupacao.setDataFinal(data);
                            break;
                        }
                    }

                    break;
                }
                case 3: {
                    System.out.println("Qual o id da ocupação que você quer remover?");
                    id = input.nextInt();
                    try {
                    ocupacaoService.removerOcupacao(id);
                    } catch (EntidadeNaoEncontradaException e) {
                        System.out.println("Essa ocupação não está na base de dados");
                        break;
                    }

                    break;
                }
                case 4: {
                    ocupacaoService.imprimirOcupacoes();
                    break;
                }
                case 5: {
                    continua = false;
                    break;
                }
                default: {
                    System.out.println("Opção inválida");
                    break;
                }
            }
        }
    }
}



