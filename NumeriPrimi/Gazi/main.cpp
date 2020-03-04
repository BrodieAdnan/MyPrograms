#include <iostream>
#include <fstream>
#include <math.h>

/**
 * @author Gazi Adnan Latif
 * @brief Visualizza il primo milione di numeri primi in un file.
 * @date 11/1/2016
 */
using namespace std;

bool isPrimeNumber(int n) // riporta il numero analizzato del main
{
    int div = 3;
    int massimo = sqrt(n);

    while (div <= max)
    {

        if (n % div == 0) return false; //restituisce falso quando non è primo
        div += 2; // il divisore evita di dividere per numeri pari

    }

    return true; // restituisce vero quando è primo

}

int main()
{
    int i = 1;
    int k = 3;
    ofstream fPrimi("ListaPrimi.txt"); // crea il file 'ListaPrimi.txt'



    while(i < 1000000)
    {

        if(isPrimeNumber(k)) // richiamo del motedo isPrimeNumber con riporto del numero analizzato
        {
            i++;
            fPrimi << k << '\n';
        }
        k+=2;

    }

    cout << k-2 << endl; // manda il primo nel file

    return 0;

}
