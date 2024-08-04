#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node* PNODE;
typedef struct node** PPNODE;

void Display(PNODE First, PNODE Last)
{
    printf("->");
    do
    {
        printf("| %d | ->",First->data);
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

void InsertFirst(PPNODE First, PPNODE Last, int No)
{
    PNODE newn = NULL;

    newn = (PNODE)malloc(sizeof(NODE));
    newn->next = NULL;
    newn->data = No;

    if(*First == NULL || *Last == NULL)
    {
        *First = newn;
        *Last = newn;
    }
    else
    {
        newn->next = *First;
        *First = newn;
    }
    (*Last)->next = *First;
}

void InsertLast(PPNODE First, PPNODE Last, int No)
{
    PNODE newn = NULL;

    newn = (PNODE)malloc(sizeof(NODE));
    newn->next = NULL;
    newn->data = No;

    if(*First == NULL || *Last == NULL)
    {
        *First = newn;
        *Last = newn;
    }
    else
    {
        (*Last)->next = newn;
        *Last = newn;
    }
    (*Last)->next = *First;
}

void InsertAtPos(PPNODE First, PPNODE Last, int No, int iPos)
{
    PNODE newn = NULL;
    PNODE temp = NULL;
    int i = 0;
    int iLength = 0;

    iLength = Count(*First, *Last);

    if((iPos<1) || (iPos>iLength+1))
    {
        printf("Invalid Position\n");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(First, Last, No);
    }
    else if(iPos == iLength+1)
    {
        InsertLast(First, Last, No);
    }
    else
    {
        temp = *First;
        newn = (PNODE)malloc(sizeof(NODE));
        newn->next = NULL;
        newn->data = No;

        for(i=1; i< iPos-1; i++)
        {
            temp = temp->next;
        }
        newn->next = temp->next;
        temp->next = newn;
    }
}

void DeleteFirst(PPNODE First, PPNODE Last)
{
    if((*First == NULL)|| (*Last == NULL))
    {
        printf("LL is already empty !!");
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
        free((*Last)->next);
        (*Last)->next = *First;
    }
}

void DeleteLast(PPNODE First, PPNODE Last)
{
    PNODE temp = NULL;

    if((*First == NULL)|| (*Last == NULL))
    {
        printf("LL is already empty !!");
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
        temp = *First;
        while(temp->next->next != *First)
        {
            temp = temp->next;
        }

        *Last = temp;
        free((*Last)->next);
        (*Last)->next = *First;
    }
}

void DeleteAtPos(PPNODE First, PPNODE Last, int iPos)
{
    PNODE temp1 = NULL;
    PNODE temp2 = NULL;
    int i = 0;
    int iLength = 0;

    iLength = Count(*First, *Last);

    if((iPos<1) || (iPos>iLength))
    {
        printf("Invalid Position\n");
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst(First, Last);
    }
    else if(iPos == iLength+1)
    {
        DeleteLast(First, Last);
    }
    else
    {
        temp1 = *First;

        for(i=1; i< iPos-1; i++)
        {
            temp1 = temp1->next;
        }
        temp2 = temp1->next;
        temp1->next = temp2->next;
        free(temp2);
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

    Display(Head, Tail);
    iRet = Count(Head, Tail);
    printf("Number of elements are : %d\n",iRet);

    InsertLast(&Head, &Tail, 111);
    InsertLast(&Head, &Tail, 121);
    InsertLast(&Head, &Tail, 151);

    Display(Head, Tail);
    iRet = Count(Head, Tail);
    printf("Number of elements are : %d\n",iRet);

    InsertAtPos(&Head, &Tail, 91, 4);

    Display(Head, Tail);
    iRet = Count(Head, Tail);
    printf("Number of elements are : %d\n",iRet);

    DeleteAtPos(&Head, &Tail, 4);

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

    return 0;
}
