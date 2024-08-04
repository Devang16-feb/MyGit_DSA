
class node
{
    public int data;
    public node next;

    public node(int iValue)
    {
        data = iValue;
        next = null;
    }
}

class Queue
{
    private node First;
    private int iCount;

    public Queue()
    {
        System.out.println("Inside Constructor !!");
        First = null;
        iCount = 0;
    }

    public void Display()
    {
        node Temp = First;

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

    public void EnQueue(int iNo) // InsertLast
    {
        node newn = null;
        node Temp = null;

        newn = new node(iNo);

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

    public int DeQueue()  // DeletFirst
    {
        int iValue = 0;

        if(First == null)
        {
            System.out.println("LL is Already Empty !!");
            return -1;
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
class QueueSinglyLL 
{
    public static void main(String[] args) 
    {
        Queue Aobj = new Queue();
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
