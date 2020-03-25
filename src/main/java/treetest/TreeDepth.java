package treetest;

import static com.google.common.primitives.Ints.max;

/**
 * Created by chayang on 2017/10/25.
 * 求二叉树深度
 */
public class TreeDepth {


    /**
     * 如果是用非递归方式，则可以采用层次遍历
     * 层次遍历完成后，不仅可以知道二叉树的深度，还可以知道二叉树的宽度
     */

    public static int getDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.getLeftChild());
        int rightDepth = getDepth(node.getRightChild());
        return max(leftDepth, rightDepth) + 1;// leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;

    }

    public static void main(String[] args) {
        int[] a = {2, 8, 7, 4, 9, 3, 1, 6, 7, 5};
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.buildTree(a);
        int depth = getDepth(myBinaryTree.getRoot());
        System.out.println(depth);

    }
}
