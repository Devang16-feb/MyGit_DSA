#include<iostream>
using namespace std;

template <class T>
class Array
{
    private:
           T *Arr;
           int iSize;
    public :
           Array(int iNo);
           ~Array();

           void Accept();

           void Display();
};

template <class T>
Array<T>::Array(int iNo)
{
    cout<<"Inside Counstructor !!"<<endl;
    this->iSize = iNo;
    this->Arr = new T[iSize];
}

template <class T>
Array<T>::~Array()
{
    delete []Arr;
}

template <class T>
void Array<T>::Accept()
{
    cout<<"Enter the elements :\n";

    for(int i=0; i<iSize; i++)
    {
        cin>>Arr[i];
    }
}

template <class T>
void Array<T>::Display()
{
    cout<<"Entered elements are :\n";
    for(int i=0; i<iSize; i++)
    {
        cout<<Arr[i]<<"\t";
    }
    cout<<"\n";
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

int main ()
{
    int iLength = 0;

    cout<<"Enter the Array Size :"<<endl;
    cin>>iLength;

    Array<int>*Aobj = new Array<int>(iLength);
    
    Aobj->Accept();
    Aobj->Display();

    delete Aobj;

    return 0;
}