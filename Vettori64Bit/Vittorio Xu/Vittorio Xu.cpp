#include <iostream>

using namespace std;
 class Vector6400{
     typedef unsigned long long ull;
 public:
    Vector6400(){
        for(int i=0;i<100;i++)vect6400[i]=0;
    }

    void setBit(int pos,bool bit){
        ull temp = (ull)1<<pos%64;
        pos=pos/64;
        if(!bit) vect6400[pos] &= ~temp;
        else vect6400[pos] |=temp;
    }

    short getBit(int pos)const{
        ull temp =(ull)1 << pos%64;
        return bool (vect6400[pos/64] & temp);
    }

    void convBin(){
        string ris;
        for(short j=0; j<100; j++){
            ris="";
            for(short i=0; i<64; i++){
                ris=((vect6400[j]%2==0)?"0":"1")+ris;
            }
            cout << ris << endl;
        }
        cout << "convBin: Ti illudi, non ci sono..." << endl;
    }
 private:
    ull vect6400[100];
 };

int main()
{
    Vector6400 prova;
    short n=2;
    int pos;
    while(true){
        cout << "Digita 0 se vuoi settare un bit"<<endl<< "1 se vuoi leggere un bit"<<endl<<"2 per chiudere"<<endl<< "altro per visualizzare." << endl;
        cin >> n;
        if(n==0){
            cout << "Settare a 0 o a 1: ";
            cin >> n;
            cout << "Posizione :";
            cin >> pos;
            prova.setBit(pos,(bool)n);
        }
        else if(n==1){
            cout << "Posizione da leggere :";
            cin >> pos;
            cout<< prova.getBit(pos) << endl;
        }
        else if(n==2)break;
        else prova.convBin();
    }
}
