#include<iostream>
#include<stdlib.h>
using namespace std;

template <class T>
struct node
{
    T data;
    struct node *next;
    struct node *prev;
};

template <class T>
class Doubly
{
    private:
           struct node<T>* First;
           struct node<T>* Last;
           int iCount;
    public:
           Doubly();

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
Doubly<T>::Doubly()
{
    cout<<"Inside Constructor\n";
    First = NULL;
    Last = NULL;
    iCount = 0;
}

template <class T>
void Doubly<T>::Display()
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

template <class T>
int Doubly<T>::Count()
{
    return iCount;
}

template <class T>
void Doubly<T>::InsertFirst(T No)
{
    struct node<T>* newn = NULL;

    newn = new struct node<T>;
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

template <class T>
void Doubly<T>::InsertLast(T No)
{
    struct node<T>* newn = NULL;

    newn = new struct node<T>;
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

template <class T>
void Doubly<T>::InsertAtPos(T No, int iPos)
{
    struct node<T>* newn = NULL;
    struct node<T>* Temp = NULL;
    int i = 0;

    newn = new struct node<T>;
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

template <class T>
void Doubly<T>::DeleteFirst()
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

template <class T>
void Doubly<T>::DeleteLast()
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

template <class T>
void Doubly<T>::DeleteAtPos(int iPos)
{
    struct node<T>* Temp = NULL;
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
    Doubly<int>*Aobj = new Doubly<int>();
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