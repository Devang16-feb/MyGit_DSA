// Stack using SinglyLL iT follows LIFo format :

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node* PNODE;
typedef struct node** PPNODE;

void Display(PNODE First)
{

    while(First != NULL)
    {
        printf("| %d | -> ",First->data);
        First = First->next;
    }
    printf("| NULL |\n");
}
void Push(PPNODE First, int iNo) // InsertFirst
{
    PNODE newn = NULL;

    newn = (PNODE)malloc(sizeof(NODE));
    newn->next = NULL;
    newn->data = iNo;

    if(*First == NULL)
    {
        *First = newn;
    }
    else
    {
        newn->next = *First;
        *First = newn;
    }
}

void Pop(PPNODE First)  // DeleteFirst;
{
    PNODE Temp = NULL;
    if(*First == NULL)
    {
        printf("LL is Already Empty !!\n");
        return;
    }
    else if((*First)->next == NULL)
    {
        free(*First);
        *First = NULL;
    }
    else
    {
        Temp = *First;
        *First = (*First)->next;
        free(Temp);
    }
}

int main()
{
    PNODE Head = NULL;

    Push(&Head, 10);
    Push(&Head, 20);
    Push(&Head, 30);
    Push(&Head, 40);

    printf("LL After push the elements are :\n");
    Display(Head);

    Pop(&Head);
    printf("LL After Pop the first element :\n");
    Display(Head);


    return 0;
}