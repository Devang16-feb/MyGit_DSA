class Solution 
{
    int height(Node node) 
    {
         if(node == null) return -1;
         
        else return Math.max(height(node.left), height(node.right)) + 1;
    }
}