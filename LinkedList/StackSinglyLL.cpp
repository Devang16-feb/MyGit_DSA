#include<iostream>
using namespace std;

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node* PNODE;

class Stack
{
    private:
           PNODE First;
           int iCount;
    public:
           Stack();

           void Display();
           int Count();

           void Push(int iNo); // insertFirst
           void Pop();         // DeleteFirst
};

Stack::Stack()
{
    cout<<"Inside Counstructor...!\n";
    First = NULL;
    iCount = 0;
}

void Stack:: Display()
{
    PNODE Temp = First;
    while(Temp != NULL)
    {
        cout<<"| "<<Temp->data<<" | -> ";
        Temp = Temp->next;
    }
    cout<<"| NULL |\n";
}
int Stack:: Count()
{
    return iCount;
}

void Stack:: Push(int iNo) // insertFirst
{
    PNODE newn = NULL;

    newn = new NODE;
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

void Stack:: Pop()  // DeleteFirst
{
    PNODE Temp = NULL;
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
    Stack Aobj;
    int iRet = 0;

    Aobj.Push(10);
    Aobj.Push(20);
    Aobj.Push(30);
    Aobj.Push(40);

    Aobj.Display();
    iRet = Aobj.Count();
    cout<<"Number of elements in LL after Updation is : "<<iRet<<"\n";

    Aobj.Pop();

    Aobj.Display();
    iRet = Aobj.Count();
    cout<<"Number of elements in LL after Updation is : "<<iRet<<"\n";

    return 0;
}