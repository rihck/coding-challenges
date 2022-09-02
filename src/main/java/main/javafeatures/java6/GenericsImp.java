package main.javafeatures.java6;

public class GenericsImp {

    public static void main(String[] args) {
        Generic<String> generic = new Generic<>();
        generic.add("a");

        System.out.println(generic.getValue());

        Generic<Integer> generic2 = new Generic<>();
        generic2.add(2);

        System.out.println(generic2.getValue());
    }

    static class Generic<T>{
        private T value;

        public void add(T value){
            this.value = value;
        }

        public T getValue(){
            return value;
        }

    }
}
