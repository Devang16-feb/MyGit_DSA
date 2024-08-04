
class node<T>
{
    public T data;
    public node<T> next; // Reference 

    public node(T no)
    {
        this.data = no;
        this.next = null;
    }
}

class Singly<T>
{
    public node<T> First;
    public int iCount;

    public Singly()
    {
        System.out.println("Object of SinglyLL gets created succefully");
        First = null;
        iCount = 0;
    }

    public void Display()
    {
        node<T> temp = First;
        
        while(temp != null)
        {
            System.out.print("| "+temp.data+" | -> ");
            temp = temp.next;
        }
        System.out.print("| null |\n");
    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(T No)
    {
        node<T> newn = null;
        newn = new node<T>(No);

        if(First == null)
        {
            First = newn;
        }
        else
        {
            newn.next = First;
            First = newn;
        }
        iCount++;
    }

    public void InsertLast(T No)
    {
        node<T> newn = null;
        node<T> temp = null;

        newn = new node<T>(No);

        if(First == null)
        {
            First = newn;
        }
        else
        {
            temp = First;

            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
        }
        iCount++;
    }

    public void InsertAtPos(T No, int iPos)
    {
        node<T> newn = null;
        node<T> temp = null;
        int i = 0;

        if(iPos<1 || iPos>iCount+1)
        {
           System.out.println("Invalid Position !!");
           return;
        }

        if(iPos == 1)
        {
            InsertFirst(No);
        }
        else if(iPos == iCount+1)
        {
            InsertLast(No);
        }
        else
        {
            temp = First;
            newn = new node<T>(No);

            for(i=1; i<iPos-1; i++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;

            iCount++;
        }

    }

    public void DeleteFirst()
    {
        if(First == null)
        {
            System.out.print("LL is Already Empty !!");
            return;
        }
        else if(First.next == null)
        {
            First = null;
        }
        else
        {
            First = First.next;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        node<T> temp = null;

        if(First == null)
        {
            System.out.print("LL is Already Empty !!");
            return;
        }
        else if(First.next == null)
        {
            First = null;
        }
        else
        {
            temp = First;

            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
        }
        iCount--;
    }
    public void DeleteAtPos(int iPos)
    {
        node<T> temp1 = null;
        node<T> temp2 = null;
        int i = 0;
    
        if(iPos<1 || iPos>iCount)
        {
           System.out.println("Invalid Position !!");
           return;
        }
    
        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == iCount+1)
        {
            DeleteLast();
        }
        else
        {
            temp1 = First;
    
            for(i=1; i<iPos-1; i++)
            {
                temp1 = temp1.next;
            }
            temp2 = temp1.next;
            temp1.next = temp2.next;

            iCount--;
        }
    
    }
}
class SinglyLL_G
{
    public static void main(String[] args) 
    {
        Singly<Integer> Aobj = new Singly<Integer>();
        int iRet = 0;

        Aobj.InsertFirst(51);
        Aobj.InsertFirst(21);
        Aobj.InsertFirst(11);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are :"+iRet);

        Aobj.InsertLast(111);
        Aobj.InsertLast(121);
        Aobj.InsertLast(151);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are :"+iRet);

        Aobj.InsertAtPos(91, 4);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are :"+iRet);

        Aobj.DeleteFirst();

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are :"+iRet);

        Aobj.DeleteLast();

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are :"+iRet);

        Aobj.DeleteAtPos(3);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are :"+iRet);

    }
}