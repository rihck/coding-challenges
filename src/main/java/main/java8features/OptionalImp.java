package main.java8features;

import java.util.Arrays;
import java.util.Optional;

/**
 * Source: https://www.youtube.com/watch?v=hmU2QEEc4sU
 */
public class OptionalImp {
    //Optional Veio para facilitar Null Checks

    // PS: Não use como input de métodos, só como retorno. Se for usar como Input, cria uma sobrecarga.

    public static void main(String[] args) {

        //////// -> Principais métodos do Optional <- \\\\\\\\\\
        // Como criar um optional de um valor não nulo
        Optional<Integer> optionalInt = Optional.of(1);//Criando de um valor que você sabe que não vai ser nulo (se fizer isso vai lançar RunTime exception)

        // Como criar um optional de um valor que pode ser nulo
        Optional.ofNullable(null); //Em casos de nulo, cria um Option Empty.

        // Criar um Optional vazio
        Optional.empty();

        //// Métodos de acesso do Optional

        //Forma mais basica de acessar o valor do Optional MAS LANÇA UMA EXCEPTION se tiver VAZIO
        optionalInt.get();

        // Saber se o Optional estávazio
        optionalInt.isPresent();

        // Se o optional estiver vazio, retornar outro valor do mesmo tipo do Optional
        optionalInt.orElse(2);

        // Consegue colocar uma função/lógica para retornar um valor do mesmo tipo do Optional
        optionalInt.orElseGet(() -> 3 + 4);

        // Lança exception se não tiver nada no Option
        optionalInt.orElseThrow(() -> new RuntimeException());


        /////////// -> Usando em junção com Streams <- \\\\\\\\\\

        // Só imprime se de fato tiver valor no Optional
        Arrays.asList(1, 2, 3).stream()
                .findFirst()
                .ifPresent((a) -> System.out.println(a));
    }
}
