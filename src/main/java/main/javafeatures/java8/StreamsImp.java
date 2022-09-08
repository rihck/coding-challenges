package main.javafeatures.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Source:
 *  - https://rinaldo.dev/java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo/
 *  - https://www.youtube.com/watch?v=1febjDMVMnc
 */
public class StreamsImp {
    public static void main(String[] args) {

        // Streams é uma feature nova implementada em todas collections que possui métodos para facilitar manipulações de estruturas de dados

        List<Integer> list = Arrays.asList(1, 2, 3);

        //Temos 2 tipos de operações (métodos) na Stream
           // - Intermediários: Que são chamados e voltam uma stream modificada, assim você consegue concatenar outras chamadas de Stream
           // - Terminais/Finais: Que ao chamadar não voltam uma Stream e você não consegue concatenar mais chamadas, ela "morre ali"
        list.stream()
                .limit(2) //Intermediario
                .map(e -> e * 2) //Intermediario
                .distinct() //Intermediario
                .forEach(n -> System.out.println(n)); //Terminal -> Stream Não pode ser reutilizada, mesmo se estrair pra uma variável, vai lançar exception

        // OBS Importante!!!: A Lista ORIGINAL NÃO É MODIFICADA, permanece a mesma depois de todas manipulações de Streams, você precisa converter o Stream em uma collection nova.

        // Operações Terminais populares
        list.stream().collect(Collectors.toList()); //You can collect to: set, map (groupingBy -> Util quando quer agrupar coisas como, clientes por um atributo especifico) and so on

        // Juntar valores em uma Stringzona: Collectors.joining -> Pode ter separador, sufixo, prefixo, etc

        list.stream().count();
        list.stream().max(Comparator.naturalOrder());
        list.stream().min(Comparator.reverseOrder());

        //Just playing around comparing anonymous class and lambda sort implementation
        list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        list.stream().sorted((o1, o2) -> {
            if (o1 < o2)
                return -1;
            if (o1 > o2)
                return 1;

            return 0;
        });

    }
}
