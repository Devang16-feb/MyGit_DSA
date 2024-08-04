
class node<T>
{
    public T data;
    public node<T> next;
}

class Stack<T>
{
    private node<T> First;
    private int iCount;

    public Stack()
    {
        System.out.println("Inside Counstructor !!");
        First = null;
        iCount = 0;
    }
    public void Display()
    {
        node<T> Temp = First;

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

    public void Push(T iNo) // Insertfirst
    {
        node<T> newn = null;

        newn = new node<T>();
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
        node<T> Temp = null;

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

class StackSinglyLL_G
{
    public static void main(String[] args) 
    {
        Stack<Integer>Aobj = new Stack<Integer>();
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
