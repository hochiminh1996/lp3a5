package aula_01;

public class MeuRunnable implements Runnable{
	// vai implementar uma interface chamada runnable, que possui apenas o método run
	//runnable significa executavel
	@Override
	public void run() {
		System.out.println("Olá, mundo!");
		System.out.println(Thread.currentThread().getName());
		//retorna o nome da thread que está em execuçaõ
		
	}
}
