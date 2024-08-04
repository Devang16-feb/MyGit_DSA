
class node<T>
{
    public T data;
    public node<T> next;

    public node(T iValue)
    {
        data = iValue;
        next = null;
    }
}

class Queue<T>
{
    private node<T> First;
    private int iCount;

    public Queue()
    {
        System.out.println("Inside Constructor !!");
        First = null;
        iCount = 0;
    }

    public void Display()
    {
        node<T> Temp = First;

        while(Temp.next != null)
        {
            System.out.print("| "+Temp.data+" | -> ");
            Temp = Temp.next;
        }
        System.out.print("| null |\n");
    }

    public int Count()
    {
        return iCount;
    }

    public void EnQueue(T iNo) // InsertLast
    {
        node<T> newn = null;
        node<T> Temp = null;

        newn = new node<T>(iNo);

        if(First == null)
        {
            First = newn;
        }
        else
        {
            Temp = First;

            while(Temp.next != null)
            {
                Temp = Temp.next;
            }
            Temp.next = newn;
        }
        iCount++;
    }

    public T DeQueue()  // DeletFirst
    {
        T iValue = null;

        if(First == null)
        {
            System.out.println("LL is Already Empty !!");
            return iValue;
        }
        else if(First.next == null)
        {
            First = null;
        }
        else
        {
            iValue = First.data;
            First = First.next;
        }
        iCount--;

        return iValue;
    }
}
class QueueSinglyLL_G
{
    public static void main(String[] args) 
    {
        Queue<Integer>Aobj = new Queue<Integer>();
        int iRet = 0;

        Aobj.EnQueue(10);
        Aobj.EnQueue(20);
        Aobj.EnQueue(30);
        Aobj.EnQueue(40);
    
        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements in LL are :"+iRet);

        Aobj.DeQueue();

        Aobj.Display();
        iRet = Aobj.Count();
        System.out.println("Number of elements in LL are :"+iRet);

    }
    
}
