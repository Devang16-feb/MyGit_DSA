// Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.

// Note: The output is written in postorder traversal.

import java.util.HashMap;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}


class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
        HashMap < Integer , Integer > map = new HashMap<>();
        
        for(int i = 0;i<inorder.length;i++){
            map.put (inorder[i] , i );
        }
        return split( inorder , 0,inorder.length-1 ,preorder , 0, map);
    }
    
    public static Node split( int []inorder , int instart, int inend , int[] preorder, int index ,HashMap<Integer , Integer> map ){
        Node root = new Node (preorder[index]);
        
        int mid = map.get (root.data);
          if(mid>instart){
        root.left = split(inorder, instart , mid-1,preorder, index+1,map );
          }
          if(mid<inend){
                 root.right = split(inorder , mid+1, inend ,preorder ,index + mid - instart +1,map);
          }
      
    return root;
    }
}