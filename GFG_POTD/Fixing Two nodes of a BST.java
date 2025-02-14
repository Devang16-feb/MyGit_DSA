// Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
// Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original Binary search tree(BST).

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution 
{
    Node First, Sec, prev, temp;
    
    void inorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        
        inorder(root.left);

        // Null check for prev before accessing its data
        if(prev != null && root.data < prev.data)
        {
            if(First == null)
            {
                First = prev;
                temp = root;               
            }
            else
            {
                Sec = root;
            }
        }
        
        prev = root; // Move prev pointer

        inorder(root.right);
    }

    void correctBST(Node root) 
    {
        First = Sec = temp = null;
        prev = new Node(Integer.MIN_VALUE); // Dummy node to avoid NullPointerException
        
        int iTemp = 0;
        inorder(root);
        
        if(First != null && Sec != null)
        {
            iTemp = First.data;
            First.data = Sec.data;
            Sec.data = iTemp;
        }
        else if(First != null && temp != null)
        {
            iTemp = First.data;
            First.data = temp.data;
            temp.data = iTemp; 
        }
        // code here.
    }
}