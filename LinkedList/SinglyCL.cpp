#include<iostream>
using namespace std;

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node* PNODE;

class SinglyCL
{
    private:
            PNODE First;
            PNODE Last;
            int iCount;
    public:
           SinglyCL();

           void Display();
           int Count();

           void InsertFirst(int No);
           void InsertLast(int No);
           void InsertAtPos(int No, int iPos);

           void DeleteFirst();
           void DeleteLast();
           void DeleteAtPos(int iPos);
};

SinglyCL::SinglyCL()
{
    cout<<"Inside Counstructor...!\n";
    First = NULL;
    Last = NULL;
    iCount = 0;
}

void SinglyCL:: Display()
{
    PNODE temp = First;
    
    cout<<"-> ";
    do
    {
        cout<<"| "<<temp->data<<" |-> ";
        temp = temp->next;
    }while(temp != Last->next);
    cout<<"\n";
}

int SinglyCL::Count()
{
    return iCount;
}

void SinglyCL::InsertFirst(int No)
{
    PNODE newn = NULL;

    newn = new NODE;
    newn->data = No;
    newn->next = NULL;

    if(First == NULL || Last == NULL)
    {
        First = newn;
        Last = newn;
    }
    else
    {
        newn->next = First;
        First = newn;
    }
    Last->next = First;
    iCount++;
    
}
void SinglyCL::InsertLast(int No)
{
    PNODE newn = NULL;

    newn = new NODE;
    newn->data = No;
    newn->next = NULL;

    if(First == NULL || Last == NULL)
    {
        First = newn;
        Last = newn;
    }
    else
    {
        Last->next = newn;
        Last = newn;
    }
    iCount++;
    Last->next = First;
}
void SinglyCL::InsertAtPos(int No, int iPos)
{
    PNODE newn = NULL;
    PNODE temp = NULL;
    int i = 0;
    newn = new NODE;

    newn->next = NULL;
    newn->data = No;

    if(iPos<1 || iPos>iCount+1)
    {
        cout<<"Invalid Position\n";
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

        for(i=1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        newn->next = temp->next;
        temp->next = newn;

        iCount++;
    }
}
void SinglyCL::DeleteFirst()
{
    if((First == NULL)||(Last == NULL))
    {
        cout<<"LL is Already Empty\n";
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
        delete Last->next;
        Last->next = First;
    }
    iCount--;
}
void SinglyCL::DeleteLast()
{
    PNODE temp = NULL;

    if((First == NULL)||(Last == NULL))
    {
        cout<<"LL is Already Empty\n";
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
        temp = First;

        while(temp->next != Last)
        {
            temp = temp->next;
        }
        Last = temp;
        delete Last->next;
        Last->next = First;
    }
    iCount--;
}

void SinglyCL::DeleteAtPos(int iPos)
{
    PNODE temp1 = NULL;
    PNODE temp2 = NULL;
    int i = 0;

    if(iPos<1 || iPos>iCount)
    {
        cout<<"Invalid Position\n";
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
        temp1 = First;

        for(i=1; i<iPos-1; i++)
        {
            temp1 = temp1->next;
        }

        temp2 = temp1->next;
        temp1->next = temp2->next;
        delete temp2;
    }  
}

int main ()
{
    SinglyCL obj;
    int iRet = 0;

    obj.InsertFirst(51);
    obj.InsertFirst(21);
    obj.InsertFirst(11);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of elements are : "<<iRet<<"\n";

    obj.InsertLast(111);
    obj.InsertLast(121);
    obj.InsertLast(151);
    obj.InsertLast(171);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of elements are : "<<iRet<<"\n";

    obj.InsertAtPos(91, 4);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of elements are : "<<iRet<<"\n";

    obj.DeleteFirst();

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of elements are : "<<iRet<<"\n";

    obj.DeleteLast();

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of elements are : "<<iRet<<"\n";

    obj.DeleteAtPos(4);

    obj.Display();
    iRet = obj.Count();
    cout<<"Number of elements are : "<<iRet<<"\n";
    return 0;
}