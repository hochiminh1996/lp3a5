# Linguagem de Programação III
<p align="justify">Bem-vindo à disciplina de Linguagem de Programação III no Instituto Federal de São Paulo (IFSP), ministrada pelo professor Wendel Marcos dos Santos. Nesta disciplina, exploraremos os conceitos avançados de concorrência e paralelismo no contexto da linguagem de programação Java.
</p>

<h2>Objetivos</h2>
<p>O objetivo principal desta disciplina é fornecer aos alunos uma compreensão aprofundada dos conceitos de concorrência e paralelismo e como eles podem ser aplicados na linguagem Java. Durante o curso, os alunos terão a oportunidade de aprender sobre:
</p>

* <strong>Concorrência e Paralelismo:</strong> Entender a diferença entre concorrência e paralelismo, bem como a importância desses conceitos no desenvolvimento de software moderno.
* <strong>Threads e Multithreading:</strong> Explorar a criação, gerenciamento e sincronização de threads em Java para executar tarefas concorrentes.
* <strong>Sincronização:</strong> Aprender técnicas para sincronizar o acesso a recursos compartilhados e evitar problemas como condições de corrida e deadlocks.
* <strong>Programação Paralela:</strong> Utilizar as facilidades oferecidas pelo Java para criar programas que executam tarefas em paralelo, tirando proveito dos processadores multicore.

<h2>Conceitos básicos
</h2>
<p align="justify"><strong>O que é uma thread: </strong>Uma thread em Java é uma unidade básica de processamento dentro de um programa, que permite a execução concorrente de tarefas. Cada thread representa um fluxo de execução independente, permitindo que um programa realize várias operações ao mesmo tempo. Threads podem ser usadas para melhorar a eficiência, paralelizar tarefas e lidar com operações assíncronas, como interações de rede ou cálculos intensivos, sem bloquear a execução principal do programa.
</p>

Criando uma thread
```
public static void main(String[]args){

  Thread t = new Thread(new MinhaThread);
  t.run();//executa o método implementando na classe minhathread
  t.start();//inicia a thread que foi criada. Sem a chamada ao método start, o método run é executado
  //dentro da thread padrão. No caso, a padrão é a main.

  System.out.println("Nome da thread: "+Thread.currentThread().getName());
  //retorna o nome da thread que está em execução
}
```





