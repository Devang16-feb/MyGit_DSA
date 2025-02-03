// Recusive Approch:

class Insert_Display 
{
    public static class Node
    {
        int data;
        Node lchild;
        Node rchild;
    
        Node(int iValue)
        {
            data = iValue;
            lchild = null;
            rchild = null;
        }
    }
    public static Node insert(Node root, int val)
    {
        if(root == null)
        {
            root = new Node(val);
            return root;
        }

        if(root.data > val)
        {
            //left subtree insert
            root.lchild = insert(root.lchild, val); // left child ka Pointer hame return  ho jayenga
        }
        else
        {
            root.rchild = insert(root.rchild, val);
        }
        return root;
    }
    public static void inorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.lchild);
        System.out.print(root.data+" ");
        inorder(root.rchild);
        
    }
    public static void main(String[] args) 
    {
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0; i<values.length; i++)
        {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
    }
}
