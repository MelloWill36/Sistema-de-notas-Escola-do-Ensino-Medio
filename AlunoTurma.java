package cadastroEscola;

import java.util.HashMap;
import java.util.List;

public class AlunoTurma {

	private HashMap<Turma, List<Aluno>> registroTurmas;

	public void RegistroTurmas() {
		this.registroTurmas = new HashMap<>();
		}
	
	public void addRegistro (Turma turma, List<Aluno> alunos){
		registroTurmas.put(turma, alunos);
	}
	
	public boolean turmaExiste(Turma turma) {
		if(this.registroTurmas.containsKey(turma)){
			return false;
		}
		return true;
	}
}
