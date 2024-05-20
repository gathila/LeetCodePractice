package tree.traverse;

//current, left, right
public class PreOrder {

    public static void main(String[] args) {
        Node root = Node.insert(new int[]{3, 1, 4, 6, 2, 8, 9, 10, 11});

        PreOrder preOrder = new PreOrder();
        preOrder.preOrder(root);
    }

    private void preOrder(Node root) {
        System.out.println(root.getValue());

        if (root.left!= null) {
            preOrder(root.left);
        }

        if (root.right!= null) {
            preOrder(root.right);
        }
    }

}
