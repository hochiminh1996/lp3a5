package aula_2_synchronized_part3;

import java.util.Locale;

import aula_01.MeuRunnable;

public class Synchronized_1 {
	private static int i = 0;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		// uso correto de synchronized e paralelismo
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
			int j;
			synchronized (this) {
				i++;
				j = i * 2;
				
				
				/*
				 * para não aplicar o Synchronized no método inteiro - o que mataria o
				 * paralelismo das thread (algo importante) - e acabar com a competição por
				 * recurso, ou seja, permitindo apenas um acesso por instância; aplicamos o
				 * Synchronized apenas nas variáveis (recursos) desejadas. Nesse sentido, o
				 * paralelismo continua e mantemos o controle sobre o recurso, ou seja, um
				 * acesso por vez.
				 */
			}

			/*
			 * As threads serão executadas em paralelo. No entanto, os seus recursos serão
			 * acessados apenas uma vez por instância :)
			 * 
			 * O pulo do gato é aplicar synchronized nos recursos que estão em disputa. E
			 * por recurso, podemos entender uma varíavel, um array, um banco, uma api, um
			 * disco e etc. E, no final, você preserva o paralelismo
			 * 
			 * (ISOLA O RECURSO)
			 * 
			 */

			Double jElevado = Math.pow(j, 100);
			Double raizJ = Math.sqrt(jElevado);
			System.out.printf("Raiz: %.2f\n", raizJ);

		}

	}

}
