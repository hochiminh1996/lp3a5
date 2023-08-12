package aula_2_synchronized_part2;

import aula_01.MeuRunnable;

public class Synchronized_1 {
	static int i = -1;

	public static void main(String[] args) {

		MeuRunnable runable = new MeuRunnable();

		// criando threads
		Thread t0 = new Thread(runable);
		Thread t1 = new Thread(runable);
		Thread t2 = new Thread(runable);
		Thread t3 = new Thread(runable);
		Thread t4 = new Thread(runable);

		// inicializando uma thread. Observe o paralelismo : execução simultânea
		// de múltiplas tarefas
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

	public static class MeuRunnable implements Runnable {

		// o método run está sendo executado em paralelo por 5 threads
		@Override
		public synchronized void run() {
			i++;// a variável i é acessada por 5 threads diferentes. Implica em concorrência
			System.out.println(Thread.currentThread().getName() + " :" + i);

			/*
			 * A palavra synchronized delimita que apenas uma thread pode executar uma
			 * instância de meurunnable por vez. Logo, ele imprimirá a ordem correta de (i)
			 * Afinal, elas não estão mais competindo simultaneamente pelo recurso (i)
			 * 
			 */

		}

	}

}
