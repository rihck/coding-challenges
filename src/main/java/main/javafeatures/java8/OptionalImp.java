package main.javafeatures.java8;

import java.util.Arrays;
import java.util.Optional;

/**
 * Source: https://www.youtube.com/watch?v=hmU2QEEc4sU
 */
public class OptionalImp {
    //Optional Veio para facilitar Null Checks
    // PS: Não use como input de métodos, só como retorno. Se for usar como Input, cria uma sobrecarga.

    public static void entendimentoAdicionalOrElseAndOrElseGet(){
        /**
         * orElseGet
         *  - Parametro: Espera um Lambda (Supplier)
         *  - Execução: Lambda SÓ É executada SE O OPTIONAL estiver VAZIO
         *
         * orElse
         *  - Parametro: Espera uma instrução, não aceita LAMBDA MAS aceita uma referencia pra um método por exemplo (então não podemos conlfuir
         *  que a diferença entre o ElseGet é que esse só aceita constante)
         *  - Execução: Mesmo que só retorne se o Optinal estiver vazio, o que tem dentro é executado e fica "carregado" para se
         *  for necessário retornar (se o Optional estiver vazio)
         */

        // Optional vazio, então os dois métodos são executados
        System.out.println("Empty Optional Scenario");
        Optional<Object> emptyOptional = Optional.empty();
        Object orElseReturn = emptyOptional.orElse(metodo1());
        Object orElseGetReturn = emptyOptional.orElseGet(() -> metodo2());


        // Optinal não vazio, cai naquele cenário do "orElse" ser executado mesmo assim (sempre), pra ficar "disponível" se fosse necessário
        System.out.println("NOT Empty Optional Scenario");
        Optional<String> notEmptyOptional = Optional.of("hello");
        String orElseReturn2 = notEmptyOptional.orElse(metodo1()); //Apesar de não ter precisado retornar o valor do método1, ele foi executado
        String orElseGetReturn2 = notEmptyOptional.orElseGet(() -> metodo2()); //Ele não foi executado, porque só é executado SE FOR NECESSÁRIO

        System.out.println("Fim Comparação orElse e orElseGet");

    }
    public static void main(String[] args) {

        //////// -> Principais métodos do Optional <- \\\\\\\\\\
        // Como criar um optional de um valor não nulo
        Optional<Integer> optionalInt = Optional.of(1);//Criando de um valor que você sabe que não vai ser nulo (se fizer isso vai lançar RunTime exception)
        //PS: As vezes queremos lançar excessão se o Optional for vazio, caso o dado seja necessário para continuar o fluxo não queremos "camuflar a inconsistencia" e sim forçar a parada do programa.

        // Como criar um optional de um valor que pode ser nulo
        Optional.ofNullable(null); //Em casos de nulo, cria um Option Empty.

        // Criar um Optional vazio
        Optional.empty();

        //// Métodos de acesso do Optional

        //Forma mais basica de acessar o valor do Optional MAS LANÇA UMA EXCEPTION se tiver VAZIO
        optionalInt.get();

        // Saber se o Optional estávazio
        optionalInt.isPresent();

        entendimentoAdicionalOrElseAndOrElseGet();
        // Se o optional estiver vazio, retornar outro valor do mesmo tipo do Optional e SEMPRE EXECUTADO em caso de método como parametro
        Integer integer = optionalInt.orElse(2);

        // Consegue colocar uma função/lógica para retornar um valor do mesmo tipo do Optional e SÓ EXECUTADO SE optional estiver de fato EMPTY
        Integer integer1 = optionalInt.orElseGet(() -> 3 + 4);

        // Lança exception se não tiver nada no Option
        optionalInt.orElseThrow(() -> new RuntimeException());


        /////////// -> Usando em junção com Streams <- \\\\\\\\\\

        // Só imprime se de fato tiver valor no Optional
        Arrays.asList(1, 2, 3).stream()
                .findFirst()
                .ifPresent((a) -> System.out.println(a));
    }

    public static String metodo1(){
        System.out.println("metodo1 executado");
        return "metodo1 executado";
    }

    public static String metodo2(){
        System.out.println("metodo2 executado");
        return "metodo2 executado";
    }
}
