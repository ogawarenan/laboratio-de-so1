package controller;


import java.util.concurrent.Semaphore;


public class ThreadCruzamento extends Thread {

	private int idCar;
	private Semaphore semaforo;
	private static int chegadaCruzamento;
	private static int saidaCruzamento;
	
	
    public ThreadCruzamento(int idCar, Semaphore semaforo) {

		this.idCar = idCar;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {
		
		carroAndando();
		
		try {
			semaforo.acquire();
			saidaCruzamento();
			sentidoCruzamento();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
		  // libera o semaforo
			
			semaforo.release();
		}
		
	}

	private void carroAndando() {
		
		int distFinal = 200;
		int disPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 7) + 10);
		int tempo = 30;

		while (disPercorrida < distFinal) { 
	    // colocando o carro em movimento
			
			disPercorrida += deslocamento;
			
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		chegadaCruzamento++;
		// a primeira thread que incrementar foi a que chegou primeiro no cruzamento

		System.out.println("Carro #" + idCar + " foi o  " + chegadaCruzamento + "o. a chegar no cruzamento.");
		
	}
	

	private void saidaCruzamento() {
		
		saidaCruzamento++;
		System.out.println("Carro #" + idCar + " foi o " + saidaCruzamento + "o. a sair do cruzamento.");
		
	}
	

	private void sentidoCruzamento() {
		
		switch (saidaCruzamento) {
		
		case 1:
			
		    System.out.println("Carro #" + idCar + " saiu do cruzamento pela 1º saída.");
			break;

		case 2:
			
		    System.out.println("Carro #" + idCar + " saiu do cruzamento pela 2º saída.");
			break;
			
		case 3:
			
			System.out.println("Carro #" + idCar + " saiu do cruzamento pela 3º saída.");
			break;
			
		case 4:
			
			System.out.println("Carro #" + idCar + " saiu do cruzamento pela 4º saída.");
			break;

	  }
		
		
	}
	
}
