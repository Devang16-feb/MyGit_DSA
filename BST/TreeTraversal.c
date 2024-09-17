
#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *LChild;
    struct node *RChild;
};

typedef struct node NODE;
typedef struct node* PNODE;
typedef struct node** PPNODE;

void Insert(PPNODE Root, int iNo)
{
    PNODE newn = NULL;
    PNODE Temp = NULL;

    newn = (PNODE)malloc(sizeof(NODE));
    newn->LChild = NULL;
    newn->RChild = NULL;
    newn->data = iNo;

    if(*Root == NULL) // If Tree is Empty
    {
        *Root = newn;
    }
    else
    {
        Temp =  *Root;
        while(1) // unconditional loop
        {
            if(Temp->data == iNo)
            {
                printf("Unable to insert the node as element %d is already present !!\n", Temp->data);
                free(newn);
                break;
            }
            else if(iNo > Temp->data)
            {
                if(Temp->RChild == NULL)
                {
                    Temp->RChild = newn;
                    break;
                }
                Temp = Temp->RChild;
            }
            else if(iNo < Temp->data)
            {
                if(Temp->LChild == NULL)
                {
                    Temp->LChild = newn;
                    break;
                }
                Temp = Temp->LChild;
            }
        }
    }
}

void PreOrder(PNODE Root)
{
    if(Root != NULL)
    {
        printf("%d\t",Root->data);
        PreOrder(Root->LChild);
        PreOrder(Root->RChild);
    }
}

void InOrder(PNODE Root)
{
    if(Root != NULL)
    {
        PreOrder(Root->LChild);
        printf("%d\t",Root->data);
        PreOrder(Root->RChild);
    }
}

void PostOrder(PNODE Root)
{
    if(Root != NULL)
    {
        PreOrder(Root->LChild);
        PreOrder(Root->RChild);
        printf("%d\t",Root->data);
    }   
}

int main()
{
    PNODE Head = NULL;

    Insert(&Head, 21);
    Insert(&Head, 34);
    Insert(&Head, 11);
    Insert(&Head, 98);
    Insert(&Head, 44);
    Insert(&Head, 28);
    Insert(&Head, 11);
    Insert(&Head, 7);
    Insert(&Head, 17);

    PreOrder(Head);
    printf("\n");
    InOrder(Head);
    printf("\n");
    PostOrder(Head);
    printf("\n");

    return 0;
}