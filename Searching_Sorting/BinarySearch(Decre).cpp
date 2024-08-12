// Sorted Binary Search Tree 
// if List elements are present in Decreasing  order :

#include<iostream>
using namespace std;

template <class T>
class ArrayX
{
    public:
        T *Arr;
        int iSize;

        ArrayX(int Value);
        ~ArrayX();
        void Accept();
        void Display();
        bool LinearSearch(T Value);
        bool BidirectionalSearch(T Value);
        bool BinarySearch(T Value);
};

template <class T>
ArrayX<T>::ArrayX(int Value)
{
    this->iSize = Value;
    this->Arr = new T[iSize];
}

template <class T>
ArrayX<T>::~ArrayX()
{
    delete []Arr;
}

template <class T>
void ArrayX<T>::Accept()
{
    int i = 0;

    cout<<"Enter the elements : \n";
    for(i = 0; i < iSize; i++)
    {
        cin>>Arr[i];
    }
}

template <class T>
void ArrayX<T>::Display()
{
    int i = 0;

    cout<<"Entered elements are : \n";
    for(i = 0; i < iSize; i++)
    {
        cout<<Arr[i]<<"\n";
    }
}

template <class T>
bool ArrayX<T>::LinearSearch(T Value)
{
    bool flag = false;
    int i = 0;

    for(i = 0; i < iSize; i++)
    {
        if(Arr[i] == Value)
        {
            flag = true;
            break;
        }
    }
    return flag;
}

template <class T>
bool ArrayX<T>::BidirectionalSearch(T Value) // It will reduces the time complexity
{
    bool bFlag = false;
    int iStart = 0, iEnd = 0;

    iStart = 0;
    iEnd = iSize-1;

    while(iStart <= iEnd)
    {
        if(Arr[iStart] == Value || Arr[iEnd] == Value)
        {
            bFlag = true;
            break;
        }
        iStart++;
        iEnd--;
    }

    return bFlag;
}

template <class T>
bool ArrayX<T>::BinarySearch(T Value)
{
    bool bFlag = false;
    int iStart = 0, iEnd = 0, iMid = 0;

    iStart = 0;
    iEnd = iSize - 1;

    while(iStart <= iEnd)
    {
        iMid = iStart + ((iEnd - iStart) / 2);

        if((Arr[iMid] == Value) || (Arr[iStart] == Value) || (Arr[iEnd] == Value))
        {
            bFlag = true;
            break;
        }
        else if(Arr[iMid] < Value)
        {
            iEnd = iMid - 1;
        }
        else if(Arr[iMid] > Value)
        {
            iStart = iMid + 1;
        }
    }

    return bFlag;
}

int main()
{
    int iLength = 0, No = 0;
    bool bRet = false;

    cout<<"Enter the number of elements : \n";
    cin>>iLength;

    ArrayX<int> *aobj = new ArrayX<int>(iLength);

    aobj->Accept();
    aobj->Display();
    
    cout<<"Enter the element that you want to search : \n";
    cin>>No;

    bRet = aobj->BinarySearch(No);

    if(bRet == true)
    {
        cout<<"Element is present \n";
    }
    else
    {
        cout<<"There is no such element\n";
    }
    
    delete aobj;
    
    return 0;
}