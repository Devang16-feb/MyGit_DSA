// Sorted Binary Search Tree 
// if List elements are present in increasing order :

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
        void BubbleSort();
        void BubbleSortEfficient();
        void SelectionSort();
        void InsertionSort();
        void ShellSort();
        void Divide(int Left, int Right);
        void MergeSort();
        void Merge(int Lb, int Mid, int Ub);
        
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

        if(Arr[iMid] == Value)
        {
            bFlag = true;
            break;
        }
        else if(Arr[iMid] < Value)
        {
            iStart = iMid + 1;
        }
        else if(Arr[iMid] > Value)
        {
            iEnd = iMid - 1;
        }
    }

    return bFlag;
}

template <class T>
void ArrayX<T>::BubbleSort()
{
    int Temp = 0;
    int i = 0, j = 0;

    for(i=0; i<iSize-1; i++)
    {
        for(j=0; j<iSize-i-1; j++)  // Reduce the number of Iteration
        {
            if(Arr[j]>Arr[j+1])
            {
                Temp = Arr[j];
                Arr[j]  = Arr[j+1];
                Arr[j+1] = Temp;
            }
        }
        cout<<"\nArray after pass : "<<i+1<<"\n";
        Display();
    }
}

template <class T>
void ArrayX<T>::BubbleSortEfficient()
{
    T temp;
    int i = 0, j = 0;
    bool flag = true;

    //     1        2      3  
    for(i = 0; i < (iSize -1) && flag == true; i++)  // Outer
    {
        flag = false;
           //    1         2         3  
        for(j = 0; j< iSize - 1 - i; j++)   // Inner
        {
            if(Arr[j] > Arr[j + 1])
            {
                temp = Arr[j];
                Arr[j] = Arr[j+1];
                Arr[j+1] = temp;
                flag = true;
            }
        }
        cout<<"\nArray after pass : "<<i+1<<"\n";
        Display();
    }
}  

template <class T>
void ArrayX<T>::SelectionSort()
{
    int i = 0, j = 0, Min_Index = 0;
    int Temp = 0;

    for(i=0; i<iSize-1; i++)
    {
        Min_Index = i;
        for(j=i+1; j<iSize; j++)
        {
            if(Arr[Min_Index] > Arr[j])
            {
                Min_Index = j;
            }
        }
        Temp = Arr[i];
        Arr[i] = Arr[Min_Index];
        Arr[Min_Index] = Temp;
    }
}

template <class T>
void ArrayX<T>::InsertionSort()
{
    int i = 0, j = 0;
    int Selected = 0;

    for(i=1; i<iSize; i++)
    {
        for(j=i-1,Selected = Arr[i]; j>=0 && Arr[j] > Selected; j--)
        {
            Arr[j+1] = Arr[j];
        }
        Arr[j+1] = Selected;
    }
}

template <class T>
void ArrayX<T>::ShellSort()
{
    int iGap = 0, i = 0, j = 0;
    int Temp = 0;

    for(iGap=(iSize/2); iGap>=1; iGap /= 2)
    {
        for(j=iGap; j<iSize; j++)
        {
            for(i=j-iGap; i>=0; i -= iGap)
            {
                if(Arr[i+iGap] > Arr[i])
                {
                    break;
                }
                else
                {
                    Temp = Arr[i+iGap];
                    Arr[i+iGap] = Arr[i];
                    Arr[i] = Temp;
                }
            }
        }
    }
}

template <class T>
void ArrayX<T>::Divide(int Left, int Right)
{
    int iMid;

    if(Right > Left)
    {
        iMid = (Right + Left)/2;

        Divide(Left, iMid);
        Divide(iMid+1, Right);
        Merge(Left, iMid, Right);  
    }
}

template <class T>
void ArrayX<T>::Merge(int Lb, int Mid, int Ub)
{
    int i = Lb;
    int j = Mid+1;
    int k = Lb;
    int Temp[iSize];

    while(i <= Mid && j <=  Ub)
    {
        if(Arr[i] <= Arr[j])
        {
            Temp[k] = Arr[i];
            i++;   
        }
        else
        {
            Temp[k] = Arr[j];
            j++;
        }
        k++;
    }
    if(i > Mid)
    {
        while(j <= Ub)
        {
            Temp[k] = Arr[j];
            j++;
            k++;
        }
    }
    else if(j > Ub)
    {
        while(i <= Mid)
        {
            Temp[k] = Arr[i];
            i++;
            k++;
        }
    }

    for(k=Lb; k<=Ub; k++)
    {
        Arr[k] = Temp[k];
    }
}

template <class T>
void ArrayX<T>::MergeSort()
{
    int iStart = 0, iEnd = 0;

    iStart = 0;
    iEnd = iSize-1;

    Divide(iStart, iEnd);

}

int main()
{
    int iLength = 0;

    cout<<"Enter the number of elements : \n";
    cin>>iLength;

    ArrayX<int> *aobj = new ArrayX<int>(iLength);

    aobj->Accept();
    cout<<"Data before sorting : \n";

    aobj->Display();

    aobj->MergeSort();

    cout<<"\nData after Merge Sorting : \n";
    aobj->Display();
    delete aobj;
    
    return 0;
}