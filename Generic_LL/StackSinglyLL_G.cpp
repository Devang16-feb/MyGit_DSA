#include<iostream>
using namespace std;

template <class T>
struct node
{
    T data;
    struct node *next;
};

template <class T>
class Stack
{
    private:
           struct node<T>* First;
           int iCount;
    public:
           Stack();

           void Display();
           int Count();

           void Push(T iNo); // insertFirst
           void Pop();         // DeleteFirst
};

template <class T>
Stack<T>::Stack()
{
    cout<<"Inside Counstructor...!\n";
    First = NULL;
    iCount = 0;
}

template <class T>
void Stack<T>:: Display()
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
int Stack<T>:: Count()
{
    return iCount;
}

template <class T>
void Stack<T>:: Push(T iNo) // insertFirst
{
    struct node<T>* newn = NULL;

    newn = new struct node<T>;
    newn->data = iNo;
    newn->next = NULL;

    if(First == NULL)
    {
        First = newn;
    }
    else
    {
        newn->next = First;
        First = newn;
    }
    iCount++;
}

template <class T>
void Stack<T>:: Pop()  // DeleteFirst
{
    struct node<T>* Temp = NULL;
    if(First == NULL)
    {
        cout<<"LL is Already Empty !!\n";
        return;
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
    Stack<int>*Aobj = new Stack<int>();
    int iRet = 0;

    Aobj->Push(10);
    Aobj->Push(20);
    Aobj->Push(30);
    Aobj->Push(40);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements in LL after Updation is : "<<iRet<<"\n";

    Aobj->Pop();

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements in LL after Updation is : "<<iRet<<"\n";

    return 0;
}