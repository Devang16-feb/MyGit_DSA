// Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

// Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.

// Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.

// Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.

// Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

import java.util.ArrayList;
import java.util.Collections;

class Solution 
{
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;
        result.add(node.data);
        if(node.left==null&&node.right==null)
        {
            return result;
        }
        
        // Collect left boundary excluding leaf nodes
        left(node.left, result);
        
        // Collect leaf nodes
        bottom(node, result);

        // Collect right boundary excluding leaf nodes in reverse
        ArrayList<Integer> rightBoundary = new ArrayList<>();
        right(node.right, rightBoundary);
        Collections.reverse(rightBoundary);

        result.addAll(rightBoundary);
        return result;
    }

    public void left(Node root, ArrayList<Integer> result) {
        while (root != null) {
            if (!isLeaf(root)) result.add(root.data);
            root = (root.left != null) ? root.left : root.right;
        }
    }

    public void right(Node root, ArrayList<Integer> result) {
        while (root != null) {
            if (!isLeaf(root)) result.add(root.data);
            root = (root.right != null) ? root.right : root.left;
        }
    }

    public void bottom(Node root, ArrayList<Integer> result) {
        if (root == null) return;
        if (isLeaf(root)) result.add(root.data);
        bottom(root.left, result);
        bottom(root.right, result);
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}