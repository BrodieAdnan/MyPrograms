#include <iostream>
/*******************************************************************************************************
*@Brief BigBitVect 6400
*@Author Gazi Adnan Latif
*@Date 1/02/2017
*@param setta un bit alto o basso in una posizione interna all'array unsigned long long da 100 elementi.
*******************************************************************************************************/
using namespace std;
 class Vector6400{
     typedef unsigned long long ull; //define unsigned long long in ull.
 public:
    Vector6400(){
        for(int scorrimento=0;scorrimento<100;scorrimento++)vect6400[scorrimento]=0;
    }

    void setBit(int pos,bool bit){
        ull temp = (ull)1<<pos%64;
        pos=pos/64; //determina l'elemento dell'array da analizzare.
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
                ris=ris+(char)(getBit(j*64+i)+'0');
            }
            cout << ris << endl;
        }
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
	//messaggi a video per l'utilizzo del programma.
        cout << "premi 0 per modificare un bit"<<endl<< "premi 1 se vuoi leggere un bit"<<endl<<"premi 2 per chiudere il programma"<<endl<< "premi 3 per visualizzare tutti i bit" << endl;
        cin >> n;
        if(n==0){
            cout << "vuoi settare il bit a 0 o a 1?";
            cin >> n;
            cout << "In quale posizione :";
            cin >> pos;
            prova.setBit(pos,(bool)n); //richiamo di 'setBit' per la modifica del bit.
        }
        else if(n==1){
            cout << "Quale posizione vuoi leggere?";
            cin >> pos;
            cout<< prova.getBit(pos) << endl; //output del bit modificato.
        }
        else if(n==2)break; //il programma finisce.
        else if(n==3)prova.convBin(); //visualizza tutti i bit.
    }
}
