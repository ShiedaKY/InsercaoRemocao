import java.util.ArrayList;
import java.util.List;

public class PrePosOrdem {
    private Node root;

    private class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    public void remove(int data) {
        root = removeRec(root, data);
    }

    private Node removeRec(Node root, int data) {
        if (root == null)
            return root;

        if (data < root.data)
            root.left = removeRec(root.left, data);
        else if (data > root.data)
            root.right = removeRec(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = removeRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;

        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }

        return minValue;
    }

    public void preorderTraversal() {
        List<Integer> traversal = new ArrayList<>();
        preorderTraversalRec(root, traversal);

        System.out.println("Percurso em pré-ordem:");
        for (int num : traversal) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private void preorderTraversalRec(Node root, List<Integer> traversal) {
        if (root != null) {
            traversal.add(root.data);
            preorderTraversalRec(root.left, traversal);
            preorderTraversalRec(root.right, traversal);
        }
    }

    public void postorderTraversal() {
        List<Integer> traversal = new ArrayList<>();
        postorderTraversalRec(root, traversal);

        System.out.println("Percurso em pós-ordem:");
        for (int num : traversal) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private void postorderTraversalRec(Node root, List<Integer> traversal) {
        if (root != null) {
            postorderTraversalRec(root.left, traversal);
            postorderTraversalRec(root.right, traversal);
            traversal.add(root.data);
        }
    }

    public static void main(String[] args) {
        int[] array = {50, 22, 35, 31, 20, 77, 80, 90, 65, 72};

        PrePosOrdem binaryTree = new PrePosOrdem();

        // Inserção dos elementos na árvore binária
        for (int num : array) {
            binaryTree.insert(num);
        }

        // Percurso em pré-ordem após as inserções
        binaryTree.preorderTraversal();

        // Percurso em pós-ordem após as inserções
        binaryTree.postorderTraversal();

        // Remoção de elementos da árvore binária
        binaryTree.remove(22);
        binaryTree.remove(35);
        binaryTree.remove(65);
        binaryTree.remove(72);

        // Percurso em pré-ordem após as remoções
        binaryTree.preorderTraversal();

        // Percurso em pós-ordem após as remoções
        binaryTree.postorderTraversal();
    }
}

