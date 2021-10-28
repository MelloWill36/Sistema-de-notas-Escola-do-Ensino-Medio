package cadastroEscola;

import java.io.IOException;
import java.util.Scanner;

public class main {

	static Escola escola = new Escola();

	private int estado = 0;

	public static void main(String[] args) throws IOException {

		main main = new main();
		System.out.println("Sistema de notas Escola do Ensino Médio");

		do {
			switch (main.estado) {
			case 0:
				menulogin(main);
				break;
			case 1:
				menuCompleto(main);
				break;
			}
		} while (true);
	}

	private static int entradaDados(String msg) {
		Scanner tecladoEscolha = new Scanner(System.in);
		System.out.println(msg);
		int escolhaTurma = tecladoEscolha.nextInt();
		return (escolhaTurma);
	}

	private static boolean validaEntrada(int escolha, int size) {

		if (escolha > 0 && escolha <= size) {
			return true;

		} else {
			System.out.println("Digite uma opção válida!");
			return false;
		}
	}

	private static int entradaDados2(String msg) {
		Scanner tecladoEscolha2 = new Scanner(System.in);
		System.out.println(msg);
		int escolhaTurma2 = tecladoEscolha2.nextInt();
		return (escolhaTurma2);
	}

	private static boolean validaEntrada2(int escolha2, int size) {

		if (escolha2 > 0 && escolha2 <= size) {
			return true;

		} else {
			System.out.println("Digite uma opção válida!");
			return false;
		}
	}

	static void menulogin(main main) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite seu Login: ");
		String nome = teclado.nextLine();

		System.out.println("Digite sua Senha: ");
		String senha = teclado.nextLine();

		if (escola.login(nome, senha)) {
			main.estado = 1;
		}
	}

	static void menuCompleto(main main) throws IOException {

		do {

			System.out.println("\n***Selecione uma das opções do menu!***");
			System.out.println(   "\nOpcao 1 : Criar Nova Turma " 
								+ "\nOpcao 2 : Adicionar Novo Aluno"
								+ "\nOpcao 3 : Adicionar Alunos a Turma" 
								+ "\nOpcao 4 : Adicionar Nota a Aluno na Turma"
								+ "\nOpcao 5 : Gerar relatórios"
								+ "\nDigite 0 para SAIR");
			
			int opcao;
			Scanner scanner = new Scanner(System.in);
			opcao = scanner.nextInt();

			switch (opcao) {
			case 0:
				System.out.println("Efetuando LogOff");
				escola.serialisable();
				main.estado = 0;
				return;

			case 1:
				Scanner teclado, teclado2;
				teclado = new Scanner(System.in);
				teclado2 = new Scanner(System.in);

				System.out.println("Digite o ano letivo: ");
				int anoLetivo = teclado.nextInt();

				System.out.println("Digite o Ano Acadêmico: ");
				String anoAcademico = teclado2.nextLine().strip().toUpperCase();

				System.out.println("Digite o ID da Turma: ");
				String turmaID = teclado2.nextLine().strip().toUpperCase();

				escola.criaTurma(anoLetivo, anoAcademico, turmaID);
				break;

			case 2:
				Scanner tecladoAluno = new Scanner(System.in);

				System.out.println("Digite o nome do Aluno: ");
				String nomeAluno = tecladoAluno.nextLine().strip().toUpperCase();

				escola.criaAluno(nomeAluno);
				System.out.println("Aluno cadastrado com SUCESSO! ");
				break;

			case 3:
				escola.mostraTurma();
				int retornoTurma = entradaDados("Selecione a Turma:");
				boolean retValidacao = validaEntrada(retornoTurma, escola.getListTurma().size());

				if (retValidacao) {
					escola.mostraAluno();
					int retornoAluno = entradaDados("Selecione o aluno:");
					boolean retValidacaoAluno = validaEntrada(retornoAluno, escola.getListAluno().size());
					if (retValidacaoAluno) {
						Aluno xyz = escola.getListAluno().get(retornoAluno - 1);
						Turma asd = escola.getListTurma().get(retornoTurma - 1);
						asd.addListAluno(xyz);
						escola.getListTurma().set(retornoTurma - 1, asd);
						System.out.println("Cadastro de aluno na turma realizado com SUCESSO!");
						
					} else {
						System.out.println("Entrada Inválida!");
					}
				} else {
					System.out.println("Entrada Inválida!");
				}
				break;

			case 4:

				escola.mostraTurma();
				int retornoTurma2 = entradaDados("Selecione a Turma:");
							
				boolean retValidacao2 = validaEntrada(retornoTurma2, escola.getListTurma().size());
								
				if (retValidacao2) {
					escola.mostraAlunoTurma(escola.getListTurma().get(retornoTurma2-1));				
					int retornoAluno2 = entradaDados("Selecione o aluno:");		
					
					boolean retValidacaoAluno2 = validaEntrada(retornoAluno2, escola.getListTurma().get(retornoTurma2-1).getlistAlunos().size());									
					if (retValidacaoAluno2) {					
						Scanner tecladoNota;
						tecladoNota = new Scanner(System.in);
						
						System.out.println("Digite a PRIMEIRA nota: ");
						int nota1 = tecladoNota.nextInt();
	
						System.out.println("Digite a SEGUNDA nota: ");
						int nota2 = tecladoNota.nextInt();
	
						System.out.println("Digite a TERCEIRA nota: ");
						int nota3 = tecladoNota.nextInt();
	
						System.out.println("Digite a QUARTA nota: ");
						int nota4 = tecladoNota.nextInt();	
						
						int media = (nota1 + nota2 + nota3 + nota4) / 4;
						String status;
						Aluno xyz2 = escola.getListTurma().get(retornoTurma2 - 1).getlistAlunos().get(retornoAluno2 - 1);
						Turma asd2 = escola.getListTurma().get(retornoTurma2 - 1);
							
						if (nota1 >= 0 && nota2 >= 0 && nota3 >= 0 && nota4 >= 0 && 
								nota1 <= 100 && nota2 <= 100 && nota3 <= 100 && nota4 <= 100) {
						
							if(media > 70) {status = "APROVADO";}
							else if (media >= 50 && (media < 70)){status = "RECUPERAÇÃO";} 
							else {status = "REPROVADO";}
								
								escola.addHistorico(new Notas(nota1, nota2, nota3, nota4, media, status), asd2, xyz2);
								System.out.println("Nota cadastradas com sucesso!");
								
							} else {
								System.out.println("Digite notas maiores que 0!");
							}
							break;
					}
				}
				break;

			case 5:			
				System.out.println("Selecione o relatório desejado:\n"
						+ "[1] Digite 1 para ver todos os ALUNOS cadastrados;\n"
						+ "[2] Digite 2 para ver todas as TURMAS cadastradas;\n"
						+ "[3] Digite 3 para ver os HISTORICOS cadastrados;\n"
						+ "[0] Digite 0 para voltar ao menu PRINCIPAL.");
								
				Scanner tecladoRelatorio = new Scanner(System.in);
				int relatorioOpcao = tecladoRelatorio.nextInt();
								
					switch (relatorioOpcao) {
				  case 0:
					  menuCompleto(main);
					  break;
				  
				  case 1:
					  System.out.println("Alunos cadastrados: ");					  
					  escola.nomeAlunos();
					  menuCompleto(main);
					  break;
				  
				  case 2:
					  System.out.println("TURMAS cadastradas: ");
					  escola.mostraTurma();
					  menuCompleto(main);
					  break;
					  
				  case 3:
					  System.out.println("HISTORICOS cadastrados: ");
					  escola.mostraHistorico();
					  menuCompleto(main);
					  break;
				
				}while (true);
			}		
		} while (true);	
	}
}