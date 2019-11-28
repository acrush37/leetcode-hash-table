package medium;

import java.util.*;
import java.util.stream.Stream;

/*
    Given a binary tree, return the vertical order traversal of its nodes values.

    For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

    Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
    we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

    If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

    Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 */
public class VerticalOrderTraversalOfBinaryTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        VerticalOrderTraversalOfBinaryTree verticalOrderTraversalOfBinaryTree = new VerticalOrderTraversalOfBinaryTree();
        System.out.println(verticalOrderTraversalOfBinaryTree.verticalTraversal(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int k, int n, int[] f, TreeNode root, Map<Integer, List<Integer>> m) {

        if (root == null) return;
        List<Integer> list = m.get(n);
        if (list == null) list = new ArrayList<>();
        f[root.val] = k;
        list.add(root.val);
        m.put(n, list);
        dfs(k+1,n-1, f, root.left, m);
        dfs(k+1,n+1, f, root.right, m);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer, List<Integer>> m = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int[] f = new int[1000];
        dfs(0, 0, f, root, m);

        for (int i = -999; i <= 999; i++) {

            List<Integer> list = m.get(i);

            if (list != null) {
                list.sort((x, y) -> f[x] == f[y] ? x - y : f[x] - f[y]);
                result.add(list);
            }
        }

        return result;
    }

}
