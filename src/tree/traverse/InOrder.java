package tree.traverse;

//left, current, right
public class InOrder {

    public static void main(String[] args) {
        Node root = Node.insert(new int[]{3, 1, 4, 6, 2, 8, 9, 10, 11});

        InOrder inOrder = new InOrder();
        inOrder.inOrder(root);
    }

    public void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.println(node.getValue());

        if (node.right!= null) {
            inOrder(node.right);
        }
    }
}
