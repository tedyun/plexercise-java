class TreeNode {
    public TreeNode lChild;
    public TreeNode rChild;
    public int content;
    public int lSize;
    public int rSize;

    public TreeNode(int content) {
        this.content = content;
        lChild = null;
        rChild = null;
        lSize = 0;
        rSize = 0;
    }
}

class BST {
    public TreeNode root;
    public BST() {
        root = null;
    }
    public void insert(int num) {
        if (root == null) {
            root = new TreeNode(num);
        } else {
            insert(root, num);
        }
    }
    protected void insert(TreeNode node, int num) {
        if (num <= node.content) {
            // increment the left size
            node.lSize++;
            // Go left
            if (node.lChild == null) {
                node.lChild = new TreeNode(num);
            } else {
                insert(node.lChild, num);
            }
        } else {
            // increment the right size
            node.rSize++;
            // Go right
            if (node.rChild == null) {
                node.rChild = new TreeNode(num);
            } else {
                insert(node.rChild, num);
            }
        }
    }

    public int rank(int num) {
        if (root == null) {
            return 0;
        } else {
            return rank(root, num, 0);
        }
    }

    protected int rank(TreeNode node, int num, int acc) {
        // acc is the accumulated rank so far
        if (num < node.content) {
            if (node.lChild == null) {
                return acc;
            } else {
                return rank(node.lChild, num, acc);
            }
        } else {
            // all left subtree and the node itself should be added to acc
            acc += node.lSize + 1;
            if (node.rChild == null) {
                return acc;
            } else {
                return rank(node.rChild, num, acc);
            }
        }
    }
}

public class BinarySearchTree {
    
    public static void main(String[] args) {
        int[] testArray = new int[] {6, 2, 3, 6, 7, 8, 23, 4, 5, 7, 14, 45, 10};
        BST tree = new BST();
        for (int i = 0; i < testArray.length; i++) {
            tree.insert(testArray[i]);
        }
        int findNum = 11;
        System.out.println("The rank of " + findNum + " is: " + tree.rank(findNum));
    }
}