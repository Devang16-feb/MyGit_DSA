#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
    struct node *prev;
};

typedef struct node NODE;
typedef struct node* PNODE;
typedef struct node** PPNODE;

void Display(PNODE First)
{
    printf("| NULL | <=>");
    while(First != NULL)
    {
        printf("| %d | <=> ",First->data);
        First = First->next;
    }
    printf("| NULL |\n");
}

int Count(PNODE First)
{
    int iCount = 0;

    while(First != NULL)
    {
        iCount++;
        First = First->next;
    }
    return iCount;
}

void InsertFirst(PPNODE First, int No)
{
    PNODE newn = NULL;

    newn = (PNODE)malloc(sizeof(NODE));
    newn->next = NULL;
    newn->prev = NULL;
    newn->data = No;

    if(*First == NULL)
    {
        *First = newn;
    }
    else
    {
        (*First)->prev = newn;
        newn->next = *First;
        *First = newn;
    }
}

void InsertLast(PPNODE First, int No)
{
    PNODE newn = NULL;
    PNODE temp = NULL;

    newn = (PNODE)malloc(sizeof(NODE));
    newn->next = NULL;
    newn->prev = NULL;
    newn->data = No;

    if(*First == NULL)
    {
        *First = newn;
    }
    else
    {
        temp = *First;

        while(temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = newn;
        newn->prev = temp;
    }

}

void InsertAtPos(PPNODE First, int No, int iPos)
{
    PNODE newn = NULL;
    PNODE temp = NULL;
    int i = 0;

    newn = (PNODE)malloc(sizeof(NODE));
    newn->next = NULL;
    newn->prev = NULL;
    newn->data = No;

    int iLength = Count(*First);

    if(iPos<1 || iPos>iLength+1)
    {
        printf("Invalid Position\n");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(First, No);
    }
    else if(iPos == iLength+1)
    {
        InsertLast(First, No);
    }
    else
    {
        temp = *First;

        for(i=1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        temp->next->prev = newn;
        newn->next = temp->next;
        newn->prev = temp;
        temp->next = newn;
    }
}

void DeleteFirst(PPNODE First)
{
   if(*First == NULL)
   {
    printf("LL is Already Empty");
    return;
   }
   else if((*First)->next == NULL)
   {
    free(*First);
    *First = NULL;
   }
   else
   {
    *First = (*First)->next;
    free ((*First)->prev);
    (*First)->prev = NULL;
   }     
}

void DeleteLast(PPNODE First)
{
    PNODE temp = NULL;

   if(*First == NULL)
   {
    printf("LL is Already Empty");
    return;
   }
   else if((*First)->next == NULL)
   {
    free(*First);
    *First = NULL;
   }
   else
   {
    temp = *First;

    while(temp->next->next != NULL)
    {
        temp = temp->next;
    }
    free(temp->next);
    temp->next = NULL;

   }     
}

void DeleteAtPos(PPNODE First, int iPos)
{
    PNODE temp = NULL;
    int i = 0;

    int iLength = Count(*First);

    if(iPos<1 || iPos>iLength)
    {
        printf("Invalid Position\n");
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst(First);
    }
    else if(iPos == iLength)
    {
        DeleteLast(First);
    }
    else
    {
        temp = *First;

        for(i=1; i<iPos-1; i++)
        {
            temp = temp->next;
        }
        temp->next = temp->next->next;
        free(temp->next->prev);
        temp->next->prev = temp;
    }
}

int main()
{
    PNODE Head = NULL;
    int iRet = 0;

    InsertFirst(&Head, 51);
    InsertFirst(&Head, 21);
    InsertFirst(&Head, 11);

    Display(Head);
    iRet = Count(Head);
    printf("Number of elements are : %d\n",iRet);

    InsertLast(&Head, 111);
    InsertLast(&Head, 121);
    InsertLast(&Head, 151);

    Display(Head);
    iRet = Count(Head);
    printf("Number of elements are : %d\n",iRet);

    InsertAtPos(&Head, 91, 4);

    Display(Head);
    iRet = Count(Head);
    printf("Number of elements are : %d\n",iRet);

    DeleteFirst(&Head);

    Display(Head);
    iRet = Count(Head);
    printf("Number of elements are : %d\n",iRet);

    DeleteLast(&Head);

    Display(Head);
    iRet = Count(Head);
    printf("Number of elements are : %d\n",iRet);

    DeleteAtPos(&Head, 4);

    Display(Head);
    iRet = Count(Head);
    printf("Number of elements are : %d\n",iRet);
    
    return 0;
}