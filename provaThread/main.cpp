#include <iostream>
#include <thread>
#include <random>
using namespace std;
void pippo(int n){
    for(; n<10; n++){
    cout<<"first thread..."<<endl;
    }
}

void prova(int n, string nome){
    for(; n<10; n++){
    cout<<"second thread..."+nome<<endl;
    }
}
int main()
{
    cout << "Start main..." << endl;
    thread primo(pippo, (rand());
    thread secondo(prova, (rand()) "Ciao");
    primo.join();
    secondo.join();
    cout<<"Finished..."<<endl;
    return 0;
}
