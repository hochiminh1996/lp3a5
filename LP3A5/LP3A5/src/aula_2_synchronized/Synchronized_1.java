package aula_2_synchronized;

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
		public void run() {
			i++;// a variável i é acessada por 5 threads diferentes. Implica em concorrência
			System.out.println(Thread.currentThread().getName() + " :" + i);

			/*
			 * As threads irão executar o i++ de acordo com a preferência da cpu. Observe
			 * que as threads são executadas de forma desorganizada e imprimirá valores fora
			 * de ordem. Além disso, haverá casos em que nenhuma tread vai imprimir 0 ou 1
			 * ou 2 ou 3 ou 4. Isso quando não repetira valores. A impressão desordenada
			 * desses valores ocorre por causa da competição por recursos entre as threads
			 * 
			 * Não há garantias, nesse contexto, de quem irá executar primeiro.
			 */
		}

	}

}
