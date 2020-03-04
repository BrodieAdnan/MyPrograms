
/******************************************************
*@Author Gazi Adnan Latif
*@Brief mostra i colori dell'arcobaleno con un led RBG.
*@Date 20/03/2017
*******************************************************/

int myPin[] = {11, 10, 9};
int rosso = 0;
int verde = 0;
int blu = 0;

void setup() {
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
}

void loop() {

  for (int i = 0; i < 3; i++) { //accensione 'prova' dei 3 colori separati.
    analogWrite(myPin[2 - i], 255);
    delay(500);
    analogWrite(myPin[2 - i], 0);
  }

  for (int i = 0; i < 3; i++) { //accensione 'prova' dei 3 colori uniti.
    analogWrite(myPin[2 - i], 255);
    delay(500);
  }
  
  //spegnimento di tutti i led.
  analogWrite(myPin[2], 0);
  analogWrite(myPin[1], 0);
  analogWrite(myPin[0], 0);
  delay(3000);

  for (int b = 0; b <= 255; b += 85) { //blue loop.
    for (int g = 0; g <= 255; g += 85) { //green loop.
      for (int r = 0; r <= 255; r += 85) { //red loop.
        analogWrite(myPin[2], b);
        analogWrite(myPin[1], g);
        analogWrite(myPin[0], r);
        delay(300);
      }
      analogWrite(myPin[1], 0); //spegnimento verde.
      delay(300);
    }
    analogWrite(myPin[0], 0); //spegnimento rosso.
    analogWrite(myPin[2], 0); //spegnimento blu.
    delay(300);
  }
}
