package view;


import java.util.concurrent.Semaphore;
import controller.ThreadCruzamento;

public class Principal {
	
	public static void main(String[] args) {
		
		int permissoes = 3;
		
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idCar = 0; idCar < 4; idCar++){
			
			Thread tCruzamento = new ThreadCruzamento(idCar, semaforo);
			
			tCruzamento.start();
			
		}
		
		
	}
	

}
