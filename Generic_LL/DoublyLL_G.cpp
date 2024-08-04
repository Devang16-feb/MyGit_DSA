#include<iostream>
#include<stdlib.h>
using namespace std;

template <class T>
struct node
{
    int data;
    struct node *next;
    struct node *prev;
};

template <class T>
class Doubly
{
    private:
           struct node<T>* First;
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
    iCount = 0;
}

template <class T>       
void Doubly<T>::Display()
{
    struct node<T>* temp = First;
    
    cout<<"| NULL | <=>";
    while(temp != NULL)
    {
        cout<<"| "<<temp->data<<" | <=>";
        temp = temp->next;
    }
    cout<<"| NULL |\n";
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

template <class T>
void Doubly<T>::InsertLast(T No)
{
    struct node<T>* newn = NULL;
    struct node<T>* temp = NULL;

    newn = new struct node<T>;
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

template <class T>
void Doubly<T>::InsertAtPos(T No, int iPos)
{
    struct node<T>* newn = NULL;
    struct node<T>* temp = NULL;
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

        newn = new struct node<T>;
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

template <class T>
void Doubly<T>::DeleteFirst()
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

template <class T>
void Doubly<T>::DeleteLast()
{
    struct node<T>* temp = NULL;

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

template <class T>
void Doubly<T>::DeleteAtPos(int iPos)
{
    struct node<T>* temp = NULL;
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
    Doubly<int>*Aobj = new Doubly<int>();
    int iRet = 0;

    Aobj->InsertFirst(51);
    Aobj->InsertFirst(21);
    Aobj->InsertFirst(11);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    Aobj->InsertLast(111);
    Aobj->InsertLast(121);
    Aobj->InsertLast(151);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    Aobj->InsertAtPos(91, 4);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    Aobj->DeleteFirst();

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    Aobj->DeleteLast();

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    Aobj->DeleteAtPos(3);

    Aobj->Display();
    iRet = Aobj->Count();
    cout<<"Number of Elements are : "<<iRet<<"\n";

    return 0;
}