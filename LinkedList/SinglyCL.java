// SinglyCL  java:

import java.util.*;

class node
{
    public int data;
    public node next;
}

class Singly
{
    private node First;
    private node Last;
    private int iCount;

    public Singly()
    {
        System.out.println("Inside Singly Counstructor !!");
        First = null;
        Last = null;
        iCount = 0;
    }

    public void Display()
    {
        System.out.print("-> ");
        do
        {
            System.out.print("| "+First.data+" | -> ");
            First = First.next;
        }while(First != Last.next);

        System.out.println();
    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(int iNo)
    {
        node newn = null;

        newn = new node(); 
        newn.next = null;
        newn.data = iNo;

        if(First == null || Last == null )
        {
            Last = newn;
        }
        else
        {
            newn.next = First;
        }
        First = newn;
        Last.next = First;
        
        iCount++;
    }

    public void InsertLast(int iNo)
    {
        node newn = null;

        newn = new node();
        newn.next = null;
        newn.data = iNo;

        if(First == null || Last == null )
        {
            First = newn;
            Last = newn;
        }
        else
        {
            Last.next = newn;
            Last = newn;
        }
        Last.next = First;
        iCount++;
    }

    public void InsertatPos(int iPos, int iNo)
    {
        node temp = null;
        int i = 0;

        node newn = new node();
        newn.next = null;
        newn.data = iNo;

        if(iPos<1 || iPos>iCount+1)
        {
            System.out.println("Invalid Position !!");
            return;
        }
        
        if(iPos == iCount+1)
        {
            InsertLast(iNo);
        }
        else if(iPos == 1)
        {
            InsertFirst(iNo);
        }
        else 
        {
            temp = First;
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
        if(First == null || Last == null )
        {
            System.out.println("LL is empty !!");
            return;
        }
        else if(First == Last)
        {
            First  = null;
            Last = null;
        }
        else
        {
            First = First.next;
            Last.next = First;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        node temp = First;

        if(First == null || Last == null )
        {
            System.out.println("LL is empty !!");
            return;
        }
        else if(First == Last)
        {
            First  = null;
            Last = null;
        }
        else
        {
            while(temp.next != Last)
            {
                temp = temp.next;
            }
            Last = temp;
            Last.next = First;
        }
        iCount--;
    }

    public void DeleteAtPos(int iPos)
    {
        node temp = null;
        int i = 0;

        if(iPos<1 || iPos>iCount)
        {
            System.out.println("Invalid Position !!");
            return;
        }
        
        if(iPos == iCount)
        {
            DeleteLast();
        }
        else if(iPos == 1)
        {
            DeleteFirst();
        }
        else 
        {
            temp = First;
            for(i=1; i<iPos-1; i++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;

            iCount--;
        }
    }

}

class SinglyCL 
{
    public static void main(String[] args) 
    { 
        try (Scanner Sobj = new Scanner(System.in)) 
        {
            Singly Aobj = new Singly();
            int iRet = 0;

            Aobj.InsertFirst(51);
            Aobj.InsertFirst(21);
            Aobj.InsertFirst(10);

            Aobj.InsertLast(101);
            Aobj.InsertLast(121);
            Aobj.InsertLast(151);

            Aobj.Display();
            iRet = Aobj.Count();
            System.out.println("Number of elements in LL are :"+iRet);

            System.out.println("Enter the Position where you want to insert the element :");
            int Index = Sobj.nextInt();

            Aobj.InsertatPos(Index, 15);

            Aobj.Display();
            iRet = Aobj.Count();
            System.out.println("Number of elements in LL are :"+iRet);

            Aobj.DeleteFirst();

            Aobj.Display();
            iRet = Aobj.Count();
            System.out.println("Number of elements in LL are :"+iRet);

            Aobj.DeleteLast();

            Aobj.Display();
            iRet = Aobj.Count();
            System.out.println("Number of elements in LL are :"+iRet);

            Aobj.DeleteAtPos(3);

            Aobj.Display();
            iRet = Aobj.Count();
            System.out.println("Number of elements in LL are :"+iRet);
        }

    }
}