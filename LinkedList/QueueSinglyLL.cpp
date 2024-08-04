#include<iostream>
#include<stdlib.h>
using namespace std;

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node* PNODE;

class Queue
{
    private:
           PNODE First;
           int iCount;
    public:
           Queue();

           void Display();
           int Count();

           void EnQueue(int iNo); // Insertlast 
           int DeQueue();         // DeleteFirst
          
};

Queue:: Queue()
{
    cout<<"Inside counstructor !!\n";
    First = NULL;
    iCount = 0;
}
void Queue:: Display()
{
    PNODE Temp = First;
    while(Temp != NULL)
    {
        cout<<"| "<<Temp->data<<" | -> ";
        Temp = Temp->next;
    }
    cout<<"| NULL |\n";
}

int Queue:: Count()
{
    return iCount;
}

void Queue:: EnQueue(int iNo) // Insertlast 
{
    PNODE newn = NULL;
    PNODE Temp = NULL;

    newn = new NODE;
    newn->data = iNo;
    newn->next = NULL;

    if(First == NULL)
    {
        First = newn;
    }
    else
    {
        Temp = First;

        while(Temp->next != NULL)
        {
            Temp = Temp->next;
        }
        Temp->next = newn;
    }
    iCount++;
}
int Queue:: DeQueue() // DeleteFirst
{
    PNODE Temp = NULL;

    if(First == NULL)
    {
        cout<<"LL is Already Empty !!\n";
        return -1;
    }
    else if(First->next == NULL)
    {
        delete First;
        First = NULL;
    }
    else
    {
        Temp = First;
        First = First->next;
        delete Temp;
    }
    iCount--;
}

int main ()
{
    Queue Aobj;
    int iRet = 0;

    Aobj.EnQueue(10);
    Aobj.EnQueue(20);
    Aobj.EnQueue(30);
    Aobj.EnQueue(40);

    Aobj.Display();
    iRet = Aobj.Count();
    cout<<"Number of elements in LL are :"<<iRet<<"\n";

    Aobj.DeQueue();

    Aobj.Display();
    iRet = Aobj.Count();
    cout<<"Number of elements in LL are :"<<iRet<<"\n";

    return 0;
}