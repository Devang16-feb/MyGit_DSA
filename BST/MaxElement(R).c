
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

bool Search(PNODE Root, int No)
{
    bool bFlag = false;

    if(Root == NULL)
    {
        printf("Tree is empty\n");
        return bFlag;
    }
    else
    {
        while(Root != NULL)
        {
            if(Root->data == No)
            {
                bFlag = true;
                break;
            }

            else if(No < Root->data)
            {
                Root = Root->LChild;
            }

            else if(No > Root->data)
            {
                Root = Root->RChild;
            }
        }
    }
    return bFlag;
}

int Maxelement(PNODE Root)  // with recursive
{
    static int iMax = 0;

    if(Root != NULL)
    {
        if(iMax < Root->data)
        {
            iMax = Root->data;
        }
        Maxelement(Root->LChild);
        Maxelement(Root->RChild);
    }

    return iMax;
}

int main()
{
    PNODE Head = NULL;
    bool bRet = false;
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

    bRet = Search(Head, 28);

    if(bRet == true)
    {
        printf("Element is present in BST !!\n");
    }
    else
    {
        printf("Element is not present in BST !!\n");
    }

    iRet = Maxelement(Head);
    printf("Maximum element from BST is : %d\n",iRet);

    return 0;
}