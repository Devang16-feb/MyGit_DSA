#include<iostream>
using namespace std;

class Array
{
    private:
           int *Arr;
           int iSize;
    public :
           Array(int iNo)
           {
            cout<<"Inside Counstructor !!"<<endl;
            this->iSize = iNo;
            this->Arr = new int[iSize];
           }

           ~Array()
           {
            delete []Arr;
           }

           void Accept()
           {
            cout<<"Enter the elements :\n";

            for(int i=0; i<iSize; i++)
            {
                cin>>Arr[i];
            }
           }

           void Display()
           {
            cout<<"Entered elements are :\n";
            for(int i=0; i<iSize; i++)
            {
                cout<<Arr[i]<<"\t";
            }
            cout<<"\n";
           }

};
int main ()
{
    int iLength = 0;

    cout<<"Enter the Array Size :"<<endl;
    cin>>iLength;

    Array *Aobj = new Array(iLength);
    
    Aobj->Accept();
    Aobj->Display();

    delete Aobj;

    return 0;
}