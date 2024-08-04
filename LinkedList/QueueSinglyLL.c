//Queue Usind Singly LL: (First int First OUT)

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
void EnQueue(PPNODE First, int iNo) // InsertLast
{
    PNODE newn = NULL;
    PNODE Temp = NULL;

    newn = (PNODE)malloc(sizeof(NODE));
    newn->next = NULL;
    newn->data = iNo;

    if(*First == NULL)
    {
        *First = newn;
    }
    else
    {
        Temp = *First;

        while(Temp->next != NULL)
        {
            Temp = Temp->next;
        }
        Temp->next = newn;
    }
}

int DeQueue(PPNODE First)  // DeleteFirst;
{
    PNODE Temp = NULL;
    int iValue = 0;

    if(*First == NULL)
    {
        printf("LL is Already Empty !!\n");
        return -1;
    }
    else if((*First)->next == NULL)
    {
        free(*First);
        *First = NULL;
    }
    else
    {
        iValue = (*First)->data;
        Temp = *First;
        *First = (*First)->next;
        free(Temp);
    }

    return iValue;
}

int main()
{
    PNODE Head = NULL;
    int iRet = 0;


    EnQueue(&Head, 10);
    EnQueue(&Head, 20);
    EnQueue(&Head, 30);
    EnQueue(&Head, 40);

    Display(Head);

    iRet = DeQueue(&Head);
    printf("Removed element is : %d\n",iRet);
    Display(Head);

    EnQueue(&Head, 50);
    EnQueue(&Head, 60);
    Display(Head);

    iRet = DeQueue(&Head);
    printf("Removed element is : %d\n",iRet);
    Display(Head);


    return 0;
}