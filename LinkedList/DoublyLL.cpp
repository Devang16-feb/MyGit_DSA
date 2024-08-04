#include<iostream>
#include<stdlib.h>
using namespace std;

struct node
{
    int data;
    struct node *next;
    struct node *prev;
};

typedef struct node NODE;
typedef struct node* PNODE;

class Doubly
{
    private:
           PNODE First;
           int iCount;
    public:
           Doubly();
           
           void Display();
           int Count();

           void InsertFirst(int No);
           void InsertLast(int No);
           void InsertAtPos(int No, int iPos);

           void DeleteFirst();
           void DeleteLast();
           void DeleteAtPos(int iPos);
};

Doubly::Doubly()
{
    cout<<"Inside Constructor\n";
    First = NULL;
    iCount = 0;
}
           
void Doubly::Display()
{
    PNODE temp = First;
    
    cout<<"| NULL | <=>";
    while(temp != NULL)
    {
        cout<<"| "<<temp->data<<" | <=>";
        temp = temp->next;
    }
    cout<<"| NULL |\n";
}

int Doubly::Count()
{
    return iCount;
}

void Doubly::InsertFirst(int No)
{
    PNODE newn = NULL;

    newn = new NODE;
    newn->data = No;
    newn->next = NULL;
    newn->prev = NULL;

    if(First == NULL)
    {
        First = newn;
    }
    else
    {
        newn->next = First;
        First->prev = newn;
        First = newn;
    }
    iCount++;
}

void Doubly::InsertLast(int No)
{
    PNODE newn = NULL;
    PNODE temp = NULL;

    newn = new NODE;
    newn->data = No;
    newn->next = NULL;
    newn->prev = NULL;

    if(First == NULL)
    {
        First = newn;
    }
    else
    {
        temp = First;

        while(temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = newn;
        newn->prev = temp;
    }
    iCount++;
}

void Doubly::InsertAtPos(int No, int iPos)
{
    PNODE newn = NULL;
    PNODE temp = NULL;
    int i = 0;

    if(iPos<1 || iPos>iCount+1)
    {
        cout<<"Invlid Position \n";
        return;
    }
    
    if(iPos == 1)
    {
        InsertFirst(No);
    }
    else if(iPos == iCount+1)
    {
        InsertLast(No);
    }
    else
    {
        temp = First;

        newn = new NODE;
        newn->next = NULL;
        newn->prev = NULL;
        newn->data = No;

        for(i=1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        temp->next->prev = newn;
        newn->next = temp->next;
        newn->prev = temp;
        temp->next = newn;
        
        iCount++;
    }
}

void Doubly::DeleteFirst()
{
    if(First == NULL)
    {
        cout<<"LL is Already Empty\n";
        return;
    }
    else if(First->next == NULL)
    {
        delete First;
        First = NULL;
    }
    else
    {
        First = First->next;
        delete(First->prev);
        First->prev = NULL;
    }
    iCount--;
}

void Doubly::DeleteLast()
{
    PNODE temp = NULL;

    if(First == NULL)
    {
        cout<<"LL is Already Empty\n";
        return;
    }
    else if(First->next == NULL)
    {
        delete First;
        First = NULL;
    }
    else
    {
        temp = First;

        while(temp->next->next != NULL)
        {
            temp = temp->next;
        }
        delete temp->next;
        temp->next = NULL;
    }
    iCount--;
}

void Doubly::DeleteAtPos(int iPos)
{
    PNODE temp = NULL;
    int i = 0;

    if(iPos<1 || iPos>iCount)
    {
        cout<<"Invlid Position \n";
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
        temp = First;

        for(i=1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        temp->next = temp->next->next;
        delete temp->next->prev;
        temp->next->prev = temp;

        iCount--;
    }
}


int main ()
{
    Doubly obj;
    int iRet = 0;

    obj.InsertFirst(51);
    obj.InsertFirst(21);
    obj.InsertFirst(11);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    obj.InsertLast(111);
    obj.InsertLast(121);
    obj.InsertLast(151);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    obj.InsertAtPos(91, 4);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    obj.DeleteFirst();

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    obj.DeleteLast();

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    obj.DeleteAtPos(3);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    return 0;
}