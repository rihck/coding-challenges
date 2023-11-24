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

    public static Node<String> createDefaultTree(){
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
}
