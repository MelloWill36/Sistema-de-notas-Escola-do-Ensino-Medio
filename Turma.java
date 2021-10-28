package cadastroEscola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable{

	private int anoLetivo;
	private String anoAcademico;
	private String turmaID;
	private List<Aluno> listAlunos;

	public Turma(int anoLetivo, String anoAcademico, String turmaID) {
		this.anoLetivo = anoLetivo;
		this.anoAcademico = anoAcademico;
		this.turmaID = turmaID;
		this.listAlunos = new ArrayList<>();
	}

	public int getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public String getAnoAcademico() {
		return anoAcademico;
	}

	public void setAnoAcademico(String anoAcademico) {
		this.anoAcademico = anoAcademico;
	}

	public String getTurmaID() {
		return turmaID;
	}

	public void turmaID(String turmaID) {
		this.turmaID = turmaID;
	}

	public List<Aluno> getlistAlunos() {
		return this.listAlunos;
	}

	public void addListAluno(Aluno aluno) {
		this.listAlunos.add(aluno);
	}

	@Override
	public String toString() {
		return "TURMA: " + this.anoAcademico + "º " + this.turmaID + " - " + anoLetivo;
	}
}
