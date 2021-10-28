package cadastroEscola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Historico implements Serializable {
	
	private List<Notas> listNotas = new ArrayList<>();
	private List<Turma> listTurma = new ArrayList<>();
	private Aluno aluno;
		
	public Historico(Notas nota, Turma turma, Aluno aluno) {	
		this.listNotas.add(nota);
		this.listTurma.add(turma);
		this.aluno = aluno;
	}
	
	public List<Notas> getListNotas() {
		return listNotas;
	}

	public List<Turma> getListTurma() {
		return listTurma;
	}
	
	@Override
	public String toString() {
		
		return "\nAluno: " + this.aluno + " TURMA: " + this.listTurma + " Notas: " + this.listNotas;
		
	}
	
}
