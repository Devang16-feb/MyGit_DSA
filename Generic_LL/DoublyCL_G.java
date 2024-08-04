
class node<T>
{
    public T Data;
    public node<T> next;
    public node<T> prev;

    public node(T iValue)
    {
        next = null;
        prev = null;
        Data = iValue;
    }
}

class Doubly<T>
{
    private node<T> First;
    private node<T> Last;
    private int iCount;

    public Doubly()
    {
        System.out.println("Inside Counstructor !!");
        First = null;
        Last = null;
        iCount = 0;
    }

    public void Display()
    {
        if(First==null && Last==null)
        {
            System.out.println("LL is Empty");
            return;
        }
        System.out.println("Elements of LL are :");
        System.out.print("<=> ");
        do
        {
            System.out.print("| "+First.Data+" | <=> ");
            First = First.next;
        }while(First != Last.next);
        System.out.println();
    }

    public int Count()
    {
        return iCount;
    }

    public void Insertfirst(T iNo)
    {
        node<T> newn = null;

        newn = new node<T>(iNo);

        if(First == null || Last == null)
        {
            First = newn;
            Last = newn;
        }
        else
        {
            First.prev = newn;
            newn.next = First;
            First = newn;
        }
        First.prev = Last;
        Last.next = First;

        iCount++;
    }

    public void InsertLast(T iNo)
    {
        node<T> newn = null;

        newn = new node<T>(iNo);

        if(First == null || Last == null)
        {
            First = newn;
            Last = newn;
        }
        else
        {
            newn.prev = Last;
            Last.next = newn;
            Last = newn;
        }
        First.prev = Last;
        Last.next = First;

        iCount++;
    }

    public void InsertAtPos(int iPos, T iNo)
    {
        node<T> newn = null;
        node<T> Temp = null;

        newn = new node<T>(iNo);

        if(iPos<1 || iPos>iCount+1)
        {
            System.out.println("Invalid Position !!");
            return;
        }

        if(iPos == 1)
        {
            Insertfirst(iNo);
        }
        else if(iPos == iCount+1)
        {
            InsertLast(iNo);
        }
        else
        {
            Temp = First;

            for(int i=1; i<iPos-1; i++)
            {
                Temp = Temp.next;
            }
            Temp.next.prev = newn;
            newn.next = Temp.next;
            newn.prev = Temp;
            Temp.next = newn;

            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if(First == null || Last == null)
        {
            System.out.println("LL is Already Empty");
            return;
        }
        else if(First == Last)
        {
            First = null;
            Last = null;
        }
        else
        {
            First = First.next;
        }
        Last.next = First;
        First.prev = Last;

        iCount--;
    }

    public void DeleteLast()
    {
        if(First == null || Last == null)
        {
            System.out.println("LL is Already Empty");
            return;
        }
        else if(First == Last)
        {
            First = null;
            Last = null;
        }
        else
        {
            Last = Last.prev;
        }
        Last.next = First;
        First.prev = Last;

        iCount--;
    }
    public void DeleteAtPos(int iPos)
    {
        node<T> Temp = null;

        if(iPos<1 || iPos>iCount)
        {
            System.out.println("Invalid Position !!");
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
            Temp = First;

            for(int i=1; i<iPos-1; i++)
            {
                Temp = Temp.next;
            }
            Temp.next = Temp.next.next;
            Temp.next.prev = Temp;

            iCount--;
        }
    }
}

class DoublyCL_G
{
    public static void main(String[] args) 
    {
        Doubly<Integer>Aobj = new Doubly<Integer>();
        int iRet = 0;

        Aobj.Insertfirst(51);
        Aobj.Insertfirst(21);
        Aobj.Insertfirst(11);

        Aobj.InsertLast(101);
        Aobj.InsertLast(121);
        Aobj.InsertLast(151);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements in LL is :"+iRet);

        Aobj.InsertAtPos(4, 91);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements in LL is :"+iRet);

        Aobj.DeleteFirst();

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements in LL is :"+iRet);

        Aobj.DeleteLast();

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements in LL is :"+iRet);

        Aobj.DeleteAtPos(3);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements in LL is :"+iRet);
    }
    
}
