package tree.traverse;

// left, right, current
public class PostOrder {

    public static void main(String[] args) {
        Node root = Node.insert(new int[]{3, 1, 4, 6, 2, 8, 9, 10, 11});

        PostOrder postOrder = new PostOrder();
        postOrder.postOrder(root);
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.getValue());
        }
    }

}
