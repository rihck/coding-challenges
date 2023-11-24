package main.datadog;

public class Node { String value;
   Node right;
   Node left;

    public Node(String value){
        this.value = value;
    }

    public Node(String value, Node left, Node right){
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

    public static Node createDefaultTree(){
        //         a
//          b              c
//      d      e        f     g

        Node d = new Node("d");
        Node e = new Node("e");

        Node f = new Node("f");
        Node g = new Node("g");

        Node b = new Node("b", d, e);
        Node c = new Node("c", f, g);

        Node a = new Node("a", b, c);

        return a;
    }
}
