/*******************************************************
*@Author Gazi Adnan Latif.
*@Brief Uscita numeri da 1 a 9 con display a 7 segmenti.
*@Date 27/03/2017
*******************************************************/

const int matriceCod[10][7] = {
  {1, 1, 1, 1, 1, 1, 0}, //0
  {0, 1, 1, 0, 0, 0, 0}, //1
  {1, 1, 0, 1, 1, 0, 1}, //2
  {1, 1, 1, 1, 0, 0, 1}, //3
  {0, 1, 1, 0, 0, 1, 1}, //4
  {1, 0, 1, 1, 0, 1, 1}, //5
  {1, 0, 1, 1, 1, 1, 1}, //6
  {1, 1, 1, 0, 0, 0, 0}, //7
  {1, 1, 1, 1, 1, 1, 1}, //8
  {1, 1, 1, 1, 0, 1, 1}, //9
};

int nPin[8] = {7, 6, 4, 2, 3, 9, 10};
int cont = 0;

void setup() {
  Serial.begin(9600);
  for (int i = 0; i < 8; i++) {
    pinMode(nPin[i], OUTPUT);
  }
}

void loop() {
  for (int i = 0; i < 3; i++) {
    for (int i = 0; i < 8; i++) {
      digitalWrite(nPin[i], HIGH);
      delay(100);
      digitalWrite(nPin[i], LOW);
    }
  }

  for (int i = 0; i < 7; i++) {
    if (matriceCod[cont][i] == 1) {
      digitalWrite(nPin[i], HIGH);
    }
  }
  delay(500);
  for (int i = 0; i < 7; i++) {
    if (matriceCod[cont][i] == 1) {
      digitalWrite(nPin[i], LOW);
    }
  }
  if (cont < 10) {
    cont++;
    Serial.println(cont);
  } else {
    cont = 0;
  }
}
