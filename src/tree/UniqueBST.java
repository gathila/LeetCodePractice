package tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


public class UniqueBST {


    public static void main(String[] args) {

        UniqueBST ub = new UniqueBST();
        List<TreeNode> treeNodes = ub.generateAllPermutations(List.of(1, 2, 3));

        for (TreeNode root: treeNodes) {
            System.out.println("Tree view");
            ub.showPreOrder(root);
        }
    }

    private void showPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        showPreOrder(root.left);
        showPreOrder(root.right);
    }



    public List<TreeNode> generateTrees(int n) {

        List<Integer> list = IntStream.range(0, n + 1).boxed().toList();
        return generateAllPermutations(list);
    }

    public List<TreeNode> generateAllPermutations(List<Integer> original) {
        List<TreeNode> resultRoots = new ArrayList<>();

        for (int i=0; i<original.size(); i++) {
            TreeNode root = new TreeNode(original.get(i));
            List<TreeNode> leftNodes = Collections.emptyList();
            List<TreeNode> rightNodes = Collections.emptyList();
            if (i-1 >= 0) {
                List<Integer> leftValues = new ArrayList<>(original.subList(0, i));
                leftNodes = generateAllPermutations(leftValues);
            }
            if (i+1 < original.size()) {
                List<Integer> rightValues = new ArrayList<>(original.subList(i+1, original.size()));
                rightNodes = generateAllPermutations(rightValues);
            }

            if (!leftNodes.isEmpty() && !rightNodes.isEmpty()) {
                for (TreeNode leftNode: leftNodes) {
                    for (TreeNode rightNode: rightNodes) {
                        TreeNode rt = new TreeNode(root.val);
                        rt.left = leftNode;
                        rt.right = rightNode;
                        resultRoots.add(rt);
                    }
                }
            }  else if (!leftNodes.isEmpty()) {
                for (TreeNode leftNode : leftNodes) {
                    TreeNode rt = new TreeNode(root.val);
                    rt.left = leftNode;
                    resultRoots.add(rt);
                }

            } else if (!rightNodes.isEmpty()) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode rt = new TreeNode(root.val);
                    rt.right = rightNode;
                    resultRoots.add(rt);
                }
            } else {
                resultRoots.add(root);
            }
        }

        return resultRoots;
    }
}
