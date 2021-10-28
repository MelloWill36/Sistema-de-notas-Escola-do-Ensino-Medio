package cadastroEscola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno implements Serializable {
	private String nomeAluno;
	private int idAluno;
	private List<Historico> listHistorico = new ArrayList<>();
	
	public Aluno(String nomeAluno, List<Historico> listHistorico) {
		
		this.nomeAluno = nomeAluno;
		this.idAluno++;
		this.listHistorico = listHistorico;
		
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	
	public List<Historico> getListHistorico() {
		return listHistorico;
	}


	public void setListHistorico(List<Historico> listHistorico) {
		this.listHistorico = listHistorico;
	}
	
	@Override
	public String toString() {
		return this.nomeAluno.toUpperCase().strip();	
	}
}
