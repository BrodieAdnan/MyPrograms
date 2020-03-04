#include <iostream>
/**
*@author Gazi Adnan Latif
*@brief calcolo del PiGreco con la ricorsione.
*@date 22/03/2017
**/
using namespace std;

float ricorsionePi(int pi, float piGreco, bool segno)
{
    if(segno){ //addizzione.
        piGreco+=(float)(4/pi);
    } else { //sottrazione.
        piGreco-=(float)(4/pi);
    }
    if(pi<=21){
        ricorsionePi(pi+=2, piGreco, !segno);
    } else{
        cout<<piGreco;
        return piGreco;
    }
}
int main()
{
    float piGreco;
    int pi=1; //divisore aumentato per ogni ricorsione.
    bool negPos=true; //indica il segno dell'operazione.
    piGreco=ricorsionePi(pi, piGreco, negPos);
    cout<<piGreco;
    return 0;
}
