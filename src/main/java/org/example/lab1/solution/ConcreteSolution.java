package org.example.lab1.solution;

import org.example.lab1.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConcreteSolution implements Solution{
    @Override
    public List<List<Integer>> pathSum(TreeNode<Integer> root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode<Integer>> nodeStack = new Stack<>();
        Stack<List<Integer>> pathStack = new Stack<>();
        nodeStack.push(root);
        pathStack.push(new ArrayList<>());

        while (!nodeStack.isEmpty()) {
            TreeNode<Integer> node = nodeStack.pop();
            List<Integer> currentPath = pathStack.pop();
            currentPath.add(node.val);

            if (node.left == null && node.right == null && sum(currentPath) == targetSum) {
                result.add(currentPath);
            }

            if (node.right != null) {
                nodeStack.push(node.right);
                List<Integer> rightPath = new ArrayList<>(currentPath);
                pathStack.push(rightPath);
            }

            if (node.left != null) {
                nodeStack.push(node.left);
                List<Integer> leftPath = new ArrayList<>(currentPath);
                pathStack.push(leftPath);
            }
        }

        return result;
    }
    private int sum(List<Integer> path) {
        int total = 0;
        for (int num : path) {
            total += num;
        }
        return total;
    }
}
