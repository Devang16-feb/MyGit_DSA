#include<iostream>
#include<stdlib.h>
using namespace std;

template <class T>
struct node
{
    T data;
    struct node *next;
};

template <class T>
class Queue
{
    private:
           struct node<T>* First;
           int iCount;
    public:
           Queue();

           void Display();
           int Count();

           void EnQueue(T iNo); // Insertlast 
           T DeQueue();         // DeleteFirst
          
};

template <class T>
Queue<T>:: Queue()
{
    cout<<"Inside counstructor !!\n";
    First = NULL;
    iCount = 0;
}

template <class T>
void Queue<T>:: Display()
{
    struct node<T>* Temp = First;
    while(Temp != NULL)
    {
        cout<<"| "<<Temp->data<<" | -> ";
        Temp = Temp->next;
    }
    cout<<"| NULL |\n";
}

template <class T>
int Queue<T>:: Count()
{
    return iCount;
}

template <class T>
void Queue<T>:: EnQueue(T iNo) // Insertlast 
{
    struct node<T>* newn = NULL;
    struct node<T>* Temp = NULL;

    newn = new struct node<T>;
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

template <class T>
T Queue<T>:: DeQueue() // DeleteFirst
{
    struct node<T>* Temp = NULL;

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
    Queue<int>*Aobj = new Queue<int>();
    int iRet = 0;

    Aobj->EnQueue(10);
    Aobj->EnQueue(20);
    Aobj->EnQueue(30);
    Aobj->EnQueue(40);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements in LL are :"<<iRet<<"\n";

    Aobj->DeQueue();

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements in LL are :"<<iRet<<"\n";

    return 0;
}