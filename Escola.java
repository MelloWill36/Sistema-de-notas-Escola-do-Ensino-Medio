package cadastroEscola;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Escola {

	private List<Usuario> listUsuario = new ArrayList<>(
			Arrays.asList(new Usuario("teste", "teste"), new Usuario("william", "123456"), new Usuario("1", "1")));

	private List<Turma> listTurma = new ArrayList<>();

	private List<Aluno> listAluno = new ArrayList<>();
	
	private List<String> nomes = new ArrayList<String>();

	private List<Historico> listHistorico = new ArrayList<>();

	public Escola(){
		deserialisable();
	}
	
	private void deserialisable(){
		
		try {
			FileInputStream fOutAluno= new FileInputStream("C:\\Users\\Usuario\\Desktop\\Estudos\\Java\\Estagio\\Orakolo\\src\\cadastroEscola\\serialized\\aluno.ser");
			FileInputStream fOutTurma = new FileInputStream("C:\\Users\\Usuario\\Desktop\\Estudos\\Java\\Estagio\\Orakolo\\src\\cadastroEscola\\serialized\\turma.ser");
			FileInputStream fOutHistorico = new FileInputStream("C:\\Users\\Usuario\\Desktop\\Estudos\\Java\\Estagio\\Orakolo\\src\\cadastroEscola\\serialized\\historico.ser");
			FileInputStream fOutNomes = new FileInputStream("C:\\Users\\Usuario\\Desktop\\Estudos\\Java\\Estagio\\Orakolo\\src\\cadastroEscola\\serialized\\nomes.ser");
			
			ObjectInputStream oOutAluno= new ObjectInputStream(fOutAluno);
			ObjectInputStream oOutTurma= new ObjectInputStream(fOutTurma);
			ObjectInputStream oOutHistorico = new ObjectInputStream(fOutHistorico);
			ObjectInputStream oOutNomes= new ObjectInputStream(fOutNomes);
				
			this.listAluno = (List<Aluno>) oOutAluno.readObject();
			this.listTurma = (List<Turma>) oOutTurma.readObject();
			this.listHistorico = (List<Historico>) oOutHistorico.readObject();
			this.nomes = (List<String>) oOutNomes.readObject();
			
			oOutAluno.close();
			oOutTurma.close();
			oOutAluno.close();
			oOutNomes.close();
					
		} catch (IOException erro1) {
			System.out.printf("Erro: %s\n", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s\n", erro2.getMessage());
		}
	}
	
	public void serialisable() throws IOException {
		
		try {
		FileOutputStream fOutAluno = new FileOutputStream("C:\\Users\\Usuario\\Desktop\\Estudos\\Java\\Estagio\\Orakolo\\src\\cadastroEscola\\serialized\\aluno.ser");
		FileOutputStream fOutTurma = new FileOutputStream("C:\\Users\\Usuario\\Desktop\\Estudos\\Java\\Estagio\\Orakolo\\src\\cadastroEscola\\serialized\\turma.ser");
		FileOutputStream fOutHistorico = new FileOutputStream("C:\\Users\\Usuario\\Desktop\\Estudos\\Java\\Estagio\\Orakolo\\src\\cadastroEscola\\serialized\\historico.ser");
		FileOutputStream fOutNomes = new FileOutputStream("C:\\Users\\Usuario\\Desktop\\Estudos\\Java\\Estagio\\Orakolo\\src\\cadastroEscola\\serialized\\nomes.ser");
		
		ObjectOutputStream oOutAluno = new ObjectOutputStream(fOutAluno);
		ObjectOutputStream oOutTurma = new ObjectOutputStream(fOutTurma);
		ObjectOutputStream oOutHistorico = new ObjectOutputStream(fOutHistorico);
		ObjectOutputStream oOutNomes = new ObjectOutputStream(fOutNomes);
		
		oOutAluno.writeObject(this.listAluno);
		oOutTurma.writeObject(this.listTurma);
		oOutHistorico.writeObject(this.listHistorico);
		oOutNomes.writeObject(this.nomes);
		
		oOutAluno.close();
		oOutTurma.close();
		oOutHistorico.close();
		oOutNomes.close();
		
		} catch (IOException erro1) {
			System.out.printf("Erro: %s\n", erro1.getMessage());
		} 
	}
	
	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

	public List<Turma> getListTurma() {
		return listTurma;
	}

	public void setListTurma(List<Turma> listTurma) {
		this.listTurma = listTurma;
	}

	public List<Aluno> getListAluno() {
		return listAluno;
	}

	public void setListAluno(List<Aluno> listAluno) {
		this.listAluno = listAluno;
	}

	public boolean login(String nomeUser, String senhaUser) {
		for (int i = 0; i < listUsuario.size(); i++) {
			Usuario user = listUsuario.get(i);
			if (user.getnome().equals(nomeUser) && user.getsenha().equals(senhaUser)) {
				System.out.println("LOGADO!\n");
				return true;
			}
		}
		System.out.println("Senha Inválida, tente novamente!");
		return false;
	}

	private boolean noContains(Turma turma) {
		for(int i=0; i<listTurma.size();i++) {
			if(turma.getAnoAcademico().equals(listTurma.get(i).getAnoAcademico()) &&
				turma.getTurmaID().equals(listTurma.get(i).getTurmaID()) &&
				turma.getAnoLetivo() == listTurma.get(i).getAnoLetivo())				
				return false;
			}	
		return true;
	}
	
	public void criaTurma(int anoLetivo, String anoAcademico, String turmaID) {			
		Turma turma = new Turma(anoLetivo, anoAcademico, turmaID);
		if(noContains(turma)) {
			this.listTurma.add(turma);
			System.out.println("Turma criada com sucesso!");
			return;
		}
		System.out.println("Turma já existente!");
	}

	public void criaAluno(String nomeAluno) {
		Aluno aluno = new Aluno(nomeAluno, null);
		this.listAluno.add(aluno);
		this.nomes.add(nomeAluno);
	}

	public void mostraTurma() {
		for (int i = 0; i < listTurma.size(); i++) {
			System.out.println("[" + (i + 1) + "] - " + this.listTurma.get(i));
		}
	}
	
	public void mostraAluno() {
		for (int i = 0; i < this.listAluno.size(); i++) {
			System.out.println("[" + (i + 1) + "] - " + this.listAluno.get(i));
		}
	}

	public void mostraAlunoTurma(Turma turma) {		
		for (int i = 0; i < turma.getlistAlunos().size(); i++) {
			System.out.println("[" + (i + 1) + "] - " + turma.getlistAlunos().get(i).getNomeAluno());					
		}
	}

	public void addNota(Turma turma) {
		for (int i = 0; i < this.listTurma.get(i).getlistAlunos().size(); i++) {
			System.out.println("Aluno: " + turma.getlistAlunos().get(i).getNomeAluno());
		}
	}

	public void addHistorico(Notas nota, Turma turma, Aluno aluno) {
		this.listHistorico.add(new Historico(nota, turma, aluno));
	}
	
	public void calculaMedia() {
		for(int i = 0; i < this.listAluno.size(); i++ ) {
		}
	}
	
	public void mostraHistorico() {
		for (int i = 0; i < this.listHistorico.size(); i++) {
			System.out.println(this.listHistorico.get(i));
		}
	}
	
	public void nomeAlunos() {
		
		Collections.sort(nomes);
	
		for(int i = 0; i < this.nomes.size(); i++) {
			  System.out.println("[" + (i + 1) + "] - " + this.nomes.get(i));

		}			
	}	
}