
class node
{
    public int data;
    public node next;
}

class Stack
{
    private node First;
    private int iCount;

    public Stack()
    {
        System.out.println("Inside Counstructor !!");
        First = null;
        iCount = 0;
    }
    public void Display()
    {
        node Temp = First;

        while(Temp != null)
        {
            System.out.print("| "+Temp.data+" | -> ");
            Temp = Temp.next;
        }
        System.out.print("| NULL |\n");
    }

    public int Count()
    {
        return iCount;
    }

    public void Push(int iNo) // Insertfirst
    {
        node newn = null;

        newn = new node();
        newn.next = null;
        newn.data = iNo;

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

    public void Pop() // DeleteFirst
    {
        node Temp = null;

        if(First == null)
        {
            System.out.println("LL is Empty !!!");
            return;
        }
        else if(First.next == null)
        {
            First = null;
        }
        else
        {
            Temp = First;
            First = First.next;
            Temp.next = null;
        }
        iCount--;
    }

}

class StackSinglyLL 
{
    public static void main(String[] args) 
    {
        Stack Aobj = new Stack();
        int iRet = 0;

        Aobj.Push(40);
        Aobj.Push(30);
        Aobj.Push(20);
        Aobj.Push(10);

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements in LL after Updation is :"+iRet);

        Aobj.Pop();

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements in LL after Updation is :"+iRet);

    }   
}
