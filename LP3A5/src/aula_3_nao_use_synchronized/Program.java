package aula_3_nao_use_synchronized;

import java.util.ArrayList;
import java.util.List;

public class Program {
	private static List<String> lista = new ArrayList<>();
	// uma lista de string

	public static void main(String[] args) throws InterruptedException {
		MeuRunnable runnable = new MeuRunnable();

		Thread t0 = new Thread(runnable);// thread 01
		Thread t1 = new Thread(runnable);// thread 02
		Thread t2 = new Thread(runnable);// thread 03

		t0.start();// iniciando a thread 01 (paralelismo)
		t1.start();// iniciando a thread 02 (paralelismo)
		t2.start();// iniciando a thread 03 (paralelismo)

		Thread.sleep(500);
		// a thread atual ficará inativa por meio segundo. Isso dará tempo de executar
		// todos os processos que estiverem no paralelismo
		
		System.out.println(lista);//exibe a lista
	}

	// classe na main que implementa a interface runnable
	public static class MeuRunnable implements Runnable {

		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			//pegando o nome da thread
			
			lista.add("Inserindo na lista: ");
			System.out.println("Thread: "+name);
		}

	}
}
