package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;



import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		System.out.println("\nCriar Contas\n");
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1,"João da Silva", 1090f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas. gerarNumero (), 124, 1,"Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas. gerarNumero (), 125, 2,"Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas ();

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = sc.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				sc.nextLine();
				opcao=0;
			}

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "\n Criar Conta");

				System.out.println("Digite o nímero da AgÊncia: ");
				agencia = sc.nextInt();
				System.out.println("Digite o nome do titular: ");
				sc.skip("\\R?");
				titular=sc.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta(1-CC ou 2-CP);");
					tipo = sc.nextInt();
				}while(tipo < 1&& tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = sc.nextFloat();

				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = sc.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(),agencia, tipo, titular, saldo, limite));
				}
				case 2 ->{
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = sc.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia, tipo, titular, saldo, aniversario));
				}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE +"\n Listar todas as Contas");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE +"\n Buscar Conta por número");

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE +"\n Atualizar dados da Conta");

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE +"\n Apagar Conta");

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE +"\n Sacar");

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE +"\n Depositar");

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE +"\n Transferir");

				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida" + Cores.TEXT_RESET);

				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}
