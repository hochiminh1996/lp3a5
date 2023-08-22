package aula_3_nao_use_synchronized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	private static List<String> lista = new ArrayList<>();
	// uma lista de string

	public static void main(String[] args) throws InterruptedException {
		lista = Collections.synchronizedList(lista);
		// sobrescreve nosso objeto lista e o definimos, via synchronizedList, que esse
		// recurso será acessado exclusivamente uma vez por thread. Ou seja, limitando a
		// competição e usando normalmente o conceito de paralelismo

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
