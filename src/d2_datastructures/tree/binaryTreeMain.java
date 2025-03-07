package d2_datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class binaryTreeMain {
    public static void main(String[] args) {
        /*
                   1
                /     \
               2       3
              / \     /
             4   5   6
            / \   \
           7   8   9
         */

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(7),
                                new TreeNode(8)),
                        new TreeNode(5,
                                null,
                                new TreeNode(9))),
                new TreeNode(3,
                        new TreeNode(6),
                        null));

        root.preorder2(root);
        System.out.println();
        root.inorder2(root);
        System.out.println();
        root.postorder2(root);
        System.out.println();
        root.levelOrder(root);

    }
}


class TreeNode {
    private final int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void addNode(int data) {

    }

    public void removeNode() {

    }

    //先序遍历
    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node);
        preorder(node.left);
        preorder(node.right);

    }

    //中序遍历
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node);
        inorder(node.right);
    }

    //后序遍历
    public void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node);
    }

    //非递归
    //先序遍历
    public void preorder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        TreeNode pop = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                System.out.print(cur);
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    pop = stack.pop();
                } else if (peek.right == pop) {
                    pop = stack.pop();
                } else {
                    cur = peek.right;
                }
            }
        }
    }

    //中序遍历
    public void inorder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        TreeNode pop = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    System.out.print(peek);
                    pop = stack.pop();
                } else if (peek.right == pop) {
                    pop = stack.pop();
                } else {
                    System.out.print(peek);
                    cur = peek.right;
                }
            }
        }
    }

    //后序遍历
    public void postorder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        TreeNode pop = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    pop = stack.pop();
                    System.out.print(pop);
                } else if (peek.right == pop) {
                    pop = stack.pop();
                    System.out.print(pop);
                } else {
                    cur = peek.right;
                }
            }
        }
    }

    //层次遍历
    public void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll);
                assert poll != null;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return this.data + "\t";
    }
}

