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
           PNODE Last;
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
    Last = NULL;
    iCount = 0;
}

void Doubly::Display()
{
    if(First==NULL && Last==NULL) // Fillter
    {
        cout<<"LL is Empty\n";
        return;
    }
    cout<<"<=> ";
    do
    {
        cout<<"| "<<First->data<<" | <=> ";
        First = First->next;
    }while(First != Last->next);
    cout<<"\n";
}

int Doubly::Count()
{
    return iCount;
}

void Doubly::InsertFirst(int No)
{
    PNODE newn = NULL;

    newn = new NODE;
    newn->next = NULL;
    newn->prev = NULL;
    newn->data = No;

    if(First == NULL || Last == NULL)
    {
        First = newn;
        Last = newn;
    }
    else
    {
        First->prev = newn;
        newn->next = First;
        First = newn;
    }
    Last->next = First;
    First->prev = Last;

    iCount++;
}


void Doubly::InsertLast(int No)
{
    PNODE newn = NULL;

    newn = new NODE;
    newn->next = NULL;
    newn->prev = NULL;
    newn->data = No;

    if(First == NULL || Last == NULL)
    {
        First = newn;
        Last = newn;
    }
    else
    {
        newn->prev = Last;
        Last->next = newn;
        Last = newn;
    }
    Last->next = First;
    First->prev = Last;

    iCount++;
}

void Doubly::InsertAtPos(int No, int iPos)
{
    PNODE newn = NULL;
    PNODE Temp = NULL;
    int i = 0;

    newn = new NODE;
    newn->next = NULL;
    newn->prev = NULL;
    newn->data = No;

    if(iPos<1 || iPos>iCount+1)
    {
        cout<<"Invalid Position !!"<<"\n";
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
        Temp = First;

        for(i=1; i<iPos-1; i++)
        {
            Temp = Temp->next;
        }
        Temp->next->prev = newn;
        newn->next = Temp->next;
        newn->prev = Temp;
        Temp->next = newn;

        iCount++;
    }
}

void Doubly::DeleteFirst()
{
    if(First == NULL || Last == NULL)
    {
        cout<<"LL is Already empty\n";
        return;
    }
    else if(First == Last)
    {
        delete First;
        First = NULL;
        Last = NULL;
    }
    else
    {
        First = First->next;
        delete First->prev;   
    }
    Last->next = First;
    First->prev = Last;

    iCount--;
}

void Doubly::DeleteLast()
{
    if(First == NULL || Last == NULL)
    {
        cout<<"LL is Already empty\n";
        return;
    }
    else if(First == Last)
    {
        delete First;
        First = NULL;
        Last = NULL;
    }
    else
    {
        Last = Last->prev;
        delete Last->next;  
    }
    Last->next = First;
    First->prev = Last;

    iCount--;
}

void Doubly::DeleteAtPos(int iPos)
{
    PNODE Temp = NULL;
    int i = 0;

    if(iPos<1 || iPos>iCount)
    {
        cout<<"Invalid Position !!"<<"\n";
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
        Temp = First;

        for(i=1; i<iPos-1; i++)
        {
            Temp = Temp->next;
        }
        Temp->next = Temp->next->next;
        delete Temp->next->prev;
        Temp->next->prev =Temp;

        iCount--;
    }
}

int main ()
{
    Doubly *Aobj = new Doubly();
    int iRet = 0;

    Aobj->InsertFirst(51);
    Aobj->InsertFirst(21);
    Aobj->InsertFirst(11);

    Aobj->InsertLast(101);
    Aobj->InsertLast(121);
    Aobj->InsertLast(151);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements are : "<<iRet<<"\n";

    Aobj->InsertAtPos(91, 4);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements are : "<<iRet<<"\n";

    Aobj->DeleteFirst();

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements are : "<<iRet<<"\n";

    Aobj->DeleteLast();

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements are : "<<iRet<<"\n";

    Aobj->DeleteAtPos(3);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements are : "<<iRet<<"\n";


    return 0;
}