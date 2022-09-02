package main.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaImp {

    public static void main(String[] args) {
        /**
         * Podemos usar Lambad em qualquer interface que só tenha um método
         * Lambda é uma função anonima que veio para substituir classes anonimas
         */

        //Como era antes do Java 8
        // Precisavamos usar uma classe anonima para sobrescrever o método Run
            // -> Partindo do principio que pra criar uma Thread precisamos passar uma classe que implementa Runable
            // fazemos isso pra não precisarmos criar uma classe concreta só para isso
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running thread");
            }
        }).run();


        // No Java 8 eles introduziram Lambda para deixar mais enxuto/menos verboso
        new Thread(() -> System.out.println("Running thread")).run();
        //PS: Para isso funcionar a Interface precisa ter somente um método abstrato, só assim o Java sabe qual método da interface fazer o Override
            // Para garantir isso você pode usar a notação "FunctionalInterface", não é obrigatório mas não te deixa ter mais de 1 método abstrato.


        //Mas o motivo por trás disso foi a API de Streams, que tem N métodos inbutidos que são baseados em Interface
        List<Integer> list = Arrays.asList(1, 2, 3);


        // Como ficariam esse métodos com Stream e sem Lambda
        list.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer <= 2;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });

        // Com Lambda
        list.stream()
                .filter(n -> n <= 2)
                .forEach(n -> System.out.println(n));

    }

}
