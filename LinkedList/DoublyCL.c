#include<stdio.h>
#include<stdbool.h>
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

void Display(PNODE First, PNODE Last)
{
    printf("<-> ");
    do
    {
        printf("| %d | <-> ",First->data);
        First = First->next;

    }while(First != Last->next);
    printf("\n");
}

int Count(PNODE First, PNODE Last)
{
    int iCount = 0;
    do
    {
        iCount++;
        First = First->next;

    }while(First != Last->next);

    return iCount;
}

void InsertFirst(PPNODE First, PPNODE Last, int iNo)
{
    PNODE newn = NULL;

    newn = (PNODE)malloc(sizeof(NODE));
    newn->data = iNo;
    newn->next = NULL;
    newn->prev = NULL;

    if(*First == NULL || *Last == NULL)
    {
        *First = newn;
        *Last = newn;
    }
    else
    {
        newn->next = *First;
        (*First)->prev = newn;
        *First = newn;
    }
    (*First)->prev= *Last;
    (*Last)->next = *First;
}

void InsertLast(PPNODE First, PPNODE Last, int iNo)
{
    PNODE newn = NULL;
    PNODE Temp = NULL;

    newn = (PNODE)malloc(sizeof(NODE));
    newn->data = iNo;
    newn->next = NULL;
    newn->prev = NULL;

    if(*First == NULL || *Last == NULL)
    {
        *First = newn;
        *Last = newn;
    }
    else
    {
        Temp = *First;

        while(Temp->next != (*Last)->next)
        {
            Temp = Temp->next;
        }
        (*Last)->next = newn;
        newn->prev = (*Last);
        *Last = newn;
    }
    (*First)->prev= *Last;
    (*Last)->next = *First;
}

void InsertAtPos(PPNODE First, PPNODE Last, int iPos, int iNo)
{
    int i = 0;
    PNODE newn = NULL;
    PNODE Temp = NULL;

    int iCount = Count(*First, *Last);

    newn = (PNODE)malloc(sizeof(NODE));
    newn->next = NULL;
    newn->prev = NULL;
    newn->data = iNo;

    if(iPos<1 || iPos >iCount+1)
    {
        printf("Invalid Position !!\n");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(First, Last, iNo);
    }
    else if(iPos == iCount+1)
    {
        InsertLast(First, Last, iNo);
    }
    else
    {
        Temp = *First;
        for(i=1; i<iPos-1; i++)
        {
            Temp = Temp->next;
        }
        Temp->next->prev = newn;
        newn->next = Temp->next;
        newn->prev = Temp;
        Temp->next = newn;
    }
}

void DeleteFirst(PPNODE First, PPNODE Last)
{
    if(*First == NULL || *Last == NULL)
    {
        printf("LL is uable to delete !!");
        return;
    }
    else if(*First == *Last)
    {
        free(*First);
        *First = NULL;
        *Last = NULL;
    }
    else
    {
        *First = (*First)->next;
        free((*First)->prev);
    }
    (*Last)->next = *First;
    (*First)->prev = *Last;
}

void DeleteLast(PPNODE First, PPNODE Last)
{
    if(*First == NULL || *Last == NULL)
    {
        printf("LL is uable to delete !!");
        return;
    }
    else if(*First == *Last)
    {
        free(*First);
        *First = NULL;
        *Last = NULL;
    }
    else
    {
        *Last = (*Last)->prev;
        free((*Last)->next);
    }
    (*Last)->next = *First;
    (*First)->prev = *Last;
}

void DeleteAtPos(PPNODE First, PPNODE Last, int iPos)
{
    int i = 0;
    PNODE Temp = NULL;

    int iCount = Count(*First, *Last);

    if(iPos<1 || iPos >iCount)
    {
        printf("Invalid Position !!\n");
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst(First, Last);
    }
    else if(iPos == iCount)
    {
        DeleteLast(First, Last);
    }
    else
    {
        Temp = *First;
        for(i=1; i<iPos-1; i++)
        {
            Temp = Temp->next;
        }
        Temp->next = Temp->next->next;
        free(Temp->next->prev);
        Temp->next->prev = Temp;
    }
}

int main()
{
    PNODE Head = NULL;
    PNODE Tail = NULL;
    int iRet = 0;

    InsertFirst(&Head, &Tail, 51);
    InsertFirst(&Head, &Tail, 21);
    InsertFirst(&Head, &Tail, 11);

    InsertLast(&Head, &Tail, 101);
    InsertLast(&Head, &Tail, 121);
    InsertLast(&Head, &Tail, 151);

    Display(Head, Tail);
    iRet = Count(Head, Tail);
    printf("Number of elements are : %d\n",iRet);

    InsertAtPos(&Head, &Tail, 4, 91);

    Display(Head, Tail);
    iRet = Count(Head, Tail);
    printf("Number of elements are : %d\n",iRet);

    DeleteFirst(&Head, &Tail);

    Display(Head, Tail);
    iRet = Count(Head, Tail);
    printf("Number of elements are : %d\n",iRet);

    DeleteLast(&Head, &Tail);

    Display(Head, Tail);
    iRet = Count(Head, Tail);
    printf("Number of elements are : %d\n",iRet);

    DeleteAtPos(&Head, &Tail, 4);

    Display(Head, Tail);
    iRet = Count(Head, Tail);
    printf("Number of elements are : %d\n",iRet);

    return 0;
}