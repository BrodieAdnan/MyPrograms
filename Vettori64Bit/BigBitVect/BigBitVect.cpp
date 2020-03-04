#include <iostream>
using namespace std;
typedef unsigned long long Uint64;
class Vector64
{

public:
    Vector64()
    {
        vect64=0;
    }

    void setBit (short pos, bool bit)
    {
        Uint64 temp=(Uint64) 1 << pos;
        if (!bit) vect64 &= ~temp;
        else vect64 |= temp;
    }

    short getBit (short pos) const
    {
        Uint64 temp=(Uint64) 1 << pos;
        return bool (vect64 & temp);
    }

    string convBin()
    {
        string ris="";
        Uint64 v=vect64;
        for (short i=0; i<64; i++)
        {
            ris=((v%2==0)?"0":"1")+ris;
            if((i+1)%8==0)ris=" "+ris;
            v/=2;
        }
        return ris;
    }

private:
    Uint64 vect64;
};
int main ()
{
    cout<<"prova Vector64: vettore di 64 bit" << endl;
    Vector64 a;
    cout<< a.convBin()<<endl;
    int i=4;

        a.setBit(i,1);
        cout<< a.convBin()<< endl;

    a.setBit(15,0);
    cout<<a.convBin()<< endl;
    cout<<a.getBit(15)<< endl;
    cout<<a.getBit(14)<< endl;
    return 0;
}

