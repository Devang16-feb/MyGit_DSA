
class Search_Element_Rec
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
        Node newn = null;
        Node temp = null;

        newn = new Node(val);
        if(root == null)
        {
            root = newn;
        }
        else
        {
            temp = root;
            while(true) // unconditional Loop
            {
                if(temp.data > val)
                {
                    if(temp.lchild == null)
                    {
                        temp.lchild = newn;
                        break;
                    }
                    temp = temp.lchild;
                }
                else if(temp.data < val)
                {
                    if(temp.rchild == null)
                    {
                        temp.rchild = newn;
                        break;
                    }
                    temp = temp.rchild;
                }
                else
                {
                    System.out.println("Element is already present");
                    break;
                }
            }
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

    public static int CountElement(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        return 1 + CountElement(root.lchild) + CountElement(root.rchild);
    }

    public static boolean Searchelement(Node root, int val)
    {
        Node temp = root;

        while(temp != null)
        {
            if(temp.data == val)
            {
                return true;
            }
            else if(temp.data > val)
            {
                temp = temp.lchild;
            }
            else
            {
                temp = temp.rchild;
            }
        }
        return false;
    }

    private static boolean flag = false;
    public static boolean search_Rec(Node root, int val)
    {
        if(root != null)
        {
            if(root.data == val)
            {
                flag = true;
                return flag;
            }

            search_Rec(root.lchild, val);
            search_Rec(root.rchild, val);
        }
        return flag;
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
        
        int count = CountElement(root);
        System.out.println("Number of elements: " + count);

        if(Searchelement(root, 4) == true)
        {
            System.out.println("Element is present");
        }
        else
        {
            System.out.println("Element is not present");
        }

        if(search_Rec(root, 9) == true)
        {
            System.out.println("Element is present");
        }
        else
        {
            System.out.println("Element is not present");
        }
    }
}