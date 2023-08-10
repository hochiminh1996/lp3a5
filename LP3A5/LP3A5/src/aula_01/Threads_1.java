package aula_01;

//criando uma thread
public class Threads_1 {

	// a 1º thread a ser executada é a main
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		// uma classe abstrata que te diz a thread que está em execuçao

		System.out.println(t.getName());
		// retorna o nome da thread. No caso, é main

		// criando uma nova thread (ou linha de execução). É necessário passar um arg
		Thread t1 = new Thread(new MeuRunnable());
		// estamos passando uma instância da classe(meurunnable) q implementa a
		// interface runnable

		t1.run();// vai chamar a implementação feita na classe (meurunnable)
		// se não tiver o start, ele vai executar dentro da thread main(principal)
		t1.start();
		// inicia a thread que foi criada. Sem o start ele não cria de fato uma nova
		// thread. Apenas vai executar a implementação run dentro da thread main
		// e não queremos isso.

		// OBSERVAÇÃO -> Até a linha 22 quem está executando é a thread main.
		// HÁ DUAS LINHAS DE EXECUÇÃO. A partir da linha 22, quem está em execução é a
		// nossa nova thread (t1). A thread main é criada por padrão pelo java

		// criando uma nova thread
		Thread t2 = new Thread(new MeuRunnable());
		t2.start();

		Thread t3 = new Thread(new MeuRunnable());
		t3.start();

		// note que está sendo criado múltiplas threads que são executadas de forma
		// paralela. Além disso, o run está retornando o nome de cada uma delas.

	}
}
