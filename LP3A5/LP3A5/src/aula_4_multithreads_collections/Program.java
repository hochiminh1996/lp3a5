package aula_4_multithreads_collections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Implementando threads em listas. (específico para listas)
 * 
 * A implementação em listas é um pouco diferente. Afinal, quando inserimos os valores, 
 * o sistema diz que eles foram inseridos. No entanto, ao executar a thread mais de 3 vezes,
 * nota-se que as vezes ela insere 1, 2 ou até 3. Nunca todas, justamente por causa da competição por recursos
 * 
 * 
 * Collections.synchronized(lista);
 * A inserção será feita corretamente com a subrescrita da lista padrão
 * */

public class Program {
	private static List<String> lista = new CopyOnWriteArrayList<>();
	// uma lista de string. CopyOnWriteArrayList é uma coleção específica de
	// thread-safe. Ou seja, ela é ideal para o uso de multithreads em lista.
	// Impedindo a competição
	// desenfreada por recursos.

	// Concorrência Segura: É segura para operações de leitura concorrentes, pois
	// essas operações não bloqueiam umas às outras.

	// Observação :é mais pesada porque ela faz uma cópia toda vez que há uma
	// modificação no array.
	// Ou seja, se você for usar muita inserção e remoção no array, NÃO A USE por
	// uma questão desempenho. Use em cenários com pouca ou nenhuma alteração na lista

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
		// todos os processos que estiverem no paralelismo (não é uma boa prática).

		System.out.println(lista);// exibe a lista
	}

	// classe na main que implementa a interface runnable
	public static class MeuRunnable implements Runnable {

		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			// pegando o nome da thread

			lista.add("Inserindo na lista: ");
			System.out.println("Thread: " + name);
		}

	}
}
