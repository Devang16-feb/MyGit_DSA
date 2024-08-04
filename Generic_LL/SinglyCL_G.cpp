#include<iostream>
using namespace std;

template <class T>
struct node
{
    int data;
    struct node *next;
};

template <class T>
class SinglyCL
{
    private:
            struct node<T>* First;
            struct node<T>* Last;
            int iCount;
    public:
           SinglyCL();

           void Display();
           int Count();

           void InsertFirst(T No);
           void InsertLast(T No);
           void InsertAtPos(T No, int iPos);

           void DeleteFirst();
           void DeleteLast();
           void DeleteAtPos(int iPos);
};

template <class T>
SinglyCL<T>::SinglyCL()
{
    cout<<"Inside Counstructor...!\n";
    First = NULL;
    Last = NULL;
    iCount = 0;
}

template <class T>
void SinglyCL<T>:: Display()
{
    struct node<T>* temp = First;
    
    cout<<"-> ";
    do
    {
        cout<<"| "<<temp->data<<" |-> ";
        temp = temp->next;
    }while(temp != Last->next);
    cout<<"\n";
}

template <class T>
int SinglyCL<T>::Count()
{
    return iCount;
}

template <class T>
void SinglyCL<T>::InsertFirst(T No)
{
    struct node<T>* newn = NULL;

    newn = new struct node<T>;
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

template <class T>
void SinglyCL<T>::InsertLast(T No)
{
    struct node<T>* newn = NULL;

    newn = new struct node<T>;
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

template <class T>
void SinglyCL<T>::InsertAtPos(T No, int iPos)
{
    struct node<T>* newn = NULL;
    struct node<T>* temp = NULL;
    int i = 0;
    newn = new struct node<T>;

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

template <class T>
void SinglyCL<T>::DeleteFirst()
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

template <class T>
void SinglyCL<T>::DeleteLast()
{
    struct node<T>* temp = NULL;

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

template <class T>
void SinglyCL<T>::DeleteAtPos(int iPos)
{
    struct node<T>* temp1 = NULL;
    struct node<T>* temp2 = NULL;
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
    SinglyCL<int>*Aobj = new SinglyCL<int>();
    int iRet = 0;

    Aobj->InsertFirst(51);
    Aobj->InsertFirst(21);
    Aobj->InsertFirst(11);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements are : "<<iRet<<"\n";

    Aobj->InsertLast(111);
    Aobj->InsertLast(121);
    Aobj->InsertLast(151);
    Aobj->InsertLast(171);

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

    Aobj->DeleteAtPos(4);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of elements are : "<<iRet<<"\n";
    return 0;
}