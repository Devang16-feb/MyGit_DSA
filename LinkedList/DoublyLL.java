
class node
{
    public int data;
    public node next;
    public node prev;

    public node(int iValue)
    {
        data = iValue;
        next = null;
        prev = null;
    }
}

class Doubly
{
    private node First;
    private int iCount;

    public Doubly()
    {
        First = null;
        iCount = 0;
    }

    public void Display()
    {
        node temp = First;
        
        System.out.print("| null | <=>");
        while(temp != null)
        {
            System.out.print("| "+temp.data+" | <=>");
            temp = temp.next;
        }
        System.out.print("| null |\n");
    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(int No)
    {
        node newn = null;
        
        newn = new node(No);

        if(First == null)
        {
            First = newn;
        }
        else
        {
            First.prev = newn;
            newn.next = First;
            First = newn;
        }
        iCount++;
    }

    public void InsertLast(int No)
    {
        node newn = null;
        node temp = null;
        
        newn = new node(No);

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
            newn.prev = temp;
            temp.next = newn;
        }
        iCount++;
    }
    public void InsertAtPos(int No, int iPos)
    {
        node newn = null;
        node temp = null;
        int i = 0;

        if(iPos<1 || iPos>iCount+1)
        {
            System.out.println("Invalid Position \n");
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
            newn = new node(No);

            for(i=1; i<iPos-1; i++)
            {
                temp = temp.next;
            }
            temp.next.prev = newn;
            newn.next = temp.next;
            newn.prev = temp;
            temp.next = newn;

            iCount++;
        }
    }

    public void DeleteAtPos(int iPos)
    {
        node temp = null;
        int i = 0;

        if(iPos<1 || iPos>iCount)
        {
            System.out.println("Invalid Position \n");
            return;
        }

        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == iCount)
        {
            DeleteLast();
        }
        else
        {
            temp = First;

            for(i=1; i<iPos-1; i++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;

            iCount--;
        }
    }

    public void DeleteFirst()
    {
        if(First == null)
        {
            System.out.println("LL is Already Empty !!");
            return;
        }
        else if(First.next == null)
        {
            First = null;
        }
        else
        {
            First = First.next;
            First.prev = null;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        node temp = null;

        if(First == null)
        {
            System.out.println("LL is Already Empty !!");
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
}

class DoublyLL 
{
    public static void main(String[] args) 
    {
        Doubly Aobj = new Doubly();
        int iRet = 0;

        Aobj.InsertFirst(51);
        Aobj.InsertFirst(21);
        Aobj.InsertFirst(11);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are : "+iRet);

        Aobj.InsertLast(111);
        Aobj.InsertLast(121);
        Aobj.InsertLast(151);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are : "+iRet);

        Aobj.InsertAtPos(91, 4);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are : "+iRet);

        Aobj.DeleteFirst();

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are : "+iRet);

        Aobj.DeleteLast();

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are : "+iRet);

        Aobj.DeleteAtPos(3);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements are : "+iRet);
    }
    
}
