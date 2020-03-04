/*
*@Author Gazi Adnan Latif.
*@Date 01/02/2017
*@Brief Scrittura sulla memoria EEPROM.
*/

#include <EEPROM.h>
   void setup() {
   Serial.begin(9600);
}

void loop() {
   int max = 32000;
   double tempoFinale=micros();                          //assegna il tempo in microsecondi.
   Serial.println(tempoFinale);
   for(int i=0; i<max; i++){
   EEPROM.write(i, i);                                   //i= posizione, valore.
}
   double tempoIniziale=micros();
   Serial.println(tempoIniziale);
   Serial.println((tempoFinale-tempoIniziale)/max);    //tempo per una scrittura.
   delay(1000);
}
