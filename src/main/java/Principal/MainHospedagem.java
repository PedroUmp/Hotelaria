package Principal;

import Classes.Hospedagem;
import Classes.Ocupacao;
import Exceptions.EntidadeNaoEncontradaException;
import Services.HospedagemService;
import Services.OcupacaoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainHospedagem {
    public static void main() throws EntidadeNaoEncontradaException {

        HospedagemService hospedagemService = new HospedagemService();
        OcupacaoService ocupacaoService = new OcupacaoService();


        boolean continua = true;
        Scanner input = new Scanner(System.in);
        int escolha;
        int escolha2;

        int id;
        Ocupacao ocupacao;
        Hospedagem hospedagem;
        float valor;
        Date data;
        String inputData;

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");


        while(continua) {
            System.out.println("========================================================");
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Cadastrar uma hospedagem");
            System.out.println("2 - Alterar uma hospedagem");
            System.out.println("3 - Remover uma hospedagem");
            System.out.println("4 - Listar as hospedagem");
            System.out.println("5 - Voltar");
            escolha = input.nextInt();

            switch (escolha) {
                case 1: {
                    System.out.println("1: Cadastrar através de uma ocupação já existente (recomendado)");
                    System.out.println("2: Cadastrar sem ocupação");
                    escolha2 = input.nextInt();

                    switch (escolha2) {
                        case 1: {
                            System.out.println("As seguintes ocupações estão na base de dados");
                            ocupacaoService.imprimirOcupacoes();
                            System.out.println("Qual o id da ocupação?");
                            id = input.nextInt();
                            try {
                                ocupacao = ocupacaoService.recuperarOcupacaoPorId(id);
                            } catch (EntidadeNaoEncontradaException e) {
                                System.out.println("Essa ocupação não está na base de dados");
                                break;
                            }

                            System.out.println("Qual o valor da hospedagem");
                            valor = input.nextFloat();

                            System.out.println("Qual a data de pagamento?");
                            inputData = input.next();

                            try {
                                data = formatoData.parse(inputData);
                            } catch (ParseException e) {
                                System.out.println("Formato de data inválido");
                                break;
                            }

                            hospedagem = new Hospedagem(valor, data, ocupacao);
                            hospedagemService.incluirHospedagem(hospedagem);
                            break;
                        }
                        case 2: {
                            System.out.println("Qual o valor da hospedagem");
                            valor = input.nextFloat();

                            System.out.println("Qual a data de pagamento?");
                            inputData = input.next();

                            try {
                                data = formatoData.parse(inputData);
                            } catch (ParseException e) {
                                System.out.println("Formato de data inválido");
                                break;
                            }

                            hospedagem = new Hospedagem(valor, data);
                            hospedagemService.incluirHospedagem(hospedagem);
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Qual o id da hospedagem que você quer modificar?");
                    id = input.nextInt();
                    hospedagem = hospedagemService.recuperarHospedagemPorId(id);

                    System.out.println("O que você quer alterar?");
                    System.out.println("1: Valor");
                    System.out.println("2: Data de pagamento");
                    System.out.println("3: Ocupação: ");
                    escolha2 = input.nextInt();

                    switch (escolha2) {
                        case 1: {
                            System.out.println("Qual o novo valor?");
                            valor = input.nextFloat();
                            hospedagem.setValor(valor);
                            break;
                        }
                        case 2: {
                            System.out.println("Qual a nova data de pagamento?");
                            inputData = input.next();

                            try {
                                data = formatoData.parse(inputData);
                            }catch (ParseException e) {
                                System.out.println("Formato de data inválido");
                                break;
                            }
                            hospedagem.setData(data);
                            break;
                        }
                        case 3: {
                            ocupacaoService.imprimirOcupacoes();
                            System.out.println("Qual a nova ocupação?");
                            id = input.nextInt();
                            ocupacao = ocupacaoService.recuperarOcupacaoPorId(id);
                            hospedagem.setOcupacao(ocupacao);
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    hospedagemService.imprimirHospedagem();
                    System.out.println("Digite o id da hospedagem que você quer remover");
                    id = input.nextInt();
                    try {
                        hospedagemService.removerHospedagem(id);
                    } catch (EntidadeNaoEncontradaException e) {
                        System.out.println("Essa hospedagem não está no banco de dados");
                        break;
                    }
                    break;
                }
                case 4: {
                    hospedagemService.imprimirHospedagem();
                    break;
                }
                case 5: {
                    continua = false;
                    break;
                }
                default: {
                    System.out.println("Opção inválida");
                }
            }

        }
    }
}
