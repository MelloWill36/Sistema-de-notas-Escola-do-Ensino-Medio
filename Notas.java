package cadastroEscola;

import java.io.Serializable;

public class Notas implements Serializable {
	private int nota1;
	private int nota2;
	private int nota3;
	private int nota4;
	private int media;
	private String status;
	
	
	public Notas(int nota1, int nota2, int nota3, int nota4, int media, String status) {
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.media = media;
		this.status = status;
	}
	
	public int getNota1() {
		return nota1;
	}
	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}
	public int getNota2() {
		return nota2;
	}
	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}
	public int getNota3() {
		return nota3;
	}
	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}
	public int getNota4() {
		return nota4;
	}
	public void setNota4(int nota4) {
		this.nota4 = nota4;
	}
	public int getMedia() {
		return media;
	}
	public void setMedia(int media) {
		this.media = media;
	}
 
	public String getStatus() {
		return status;
	}
	
	public void statusAluno() {
	}
	
	@Override
	public String toString() {
		
		return "Notas: " + this.getNota1() +", "+getNota2() +", "+ getNota3() +", " + getNota4()+ " Media:" + getMedia() + " Status: "+ getStatus();
		
	}
}
