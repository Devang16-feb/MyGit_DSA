
#include<stdio.h>
#include<stdbool.h>
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
                printf("Unable to insert the node as element is already present !!\n");
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

int iMinRoot(PNODE iRoot, int iMin)  // with recursive
{
    if(iRoot != NULL)
    {
        if(iMin > iRoot->data)
        {
            iMin = iRoot->data;
        }
        iMin = iMinRoot(iRoot->LChild, iMin);
        iMin = iMinRoot(iRoot->RChild, iMin);
    }

    return iMin;
}

int MinElement(PNODE Root)
{
    int iSmall = Root->data;
    int bRet = 0;

    if(Root == NULL)
    {
        printf("Bst is already Empty !!\n");
        return -1;
    }
    else
    {
        bRet = iMinRoot(Root, iSmall);
    }
    return bRet;
}

int main()
{
    PNODE Head = NULL;
    int iRet = 0;

    Insert(&Head, 21);
    Insert(&Head, 34);
    Insert(&Head, 11);
    Insert(&Head, 98);
    Insert(&Head, 44);
    Insert(&Head, 28);
    Insert(&Head, 11);
    Insert(&Head, 7);
    Insert(&Head, 17);

    iRet = MinElement(Head);
    printf("Minimum element from BST is : %d\n",iRet);

    return 0;
}