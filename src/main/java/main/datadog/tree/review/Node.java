package main.datadog.tree.review;

public class Node<T> {
    T value;
   Node<T> right;
   Node<T> left;

    public Node(T value){
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right){
        this.value = value;
        this.right = right;
        this.left = left;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", right=" + right +
                ", left=" + left +
                '}';
    }

    public static Node<String> createDefaultStringTree(){
        //         a
//          b              c
//      d      e        f     g

        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");

        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");

        Node<String> b = new Node<>("b", d, e);
        Node<String> c = new Node<>("c", f, g);

        Node<String> a = new Node<>("a", b, c);

        return a;
    }

    public static Node<Integer> createDefaultIntegerTree(){
        //         3
//          11              4
//      4      2        ?     1

        Node<Integer> four = new Node<>(4);
        Node<Integer> two = new Node<>(2);
        Node<Integer> eleven = new Node<>(11, four, two);

        Node<Integer> one = new Node<>(1);
        Node<Integer> four2 = new Node<>(4, null, one);

        Node<Integer> three = new Node<>(3, eleven, four2);

        return three;
    }

    public static Node<Integer> createIntegerTreeToCalculateRootToLeaft(){
        /*
                   5
           11            3
        4     2      null   1
      */

        Node<Integer> four = new Node<>(4);
        Node<Integer> two = new Node<>(2);
        Node<Integer> eleven = new Node<>(11, four, two);

        Node<Integer> one = new Node<>(1);
        Node<Integer> three = new Node<>(3, null, one);

        Node<Integer> five = new Node<>(5, eleven, three);
        return five;
    }
}
