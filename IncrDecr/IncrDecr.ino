/***********************************************************************
*@Author Gazi Adnan Latif
*@date 15/03/2017
*@Brief Uso della funzione 'Interrupt'. Alternanza incremento-decremento.
************************************************************************/

int pin = 2;
int contatore = 0;

void setup() {
  Serial.begin(9600);
  pinMode(pin, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(pin), decremento, RISING); //cambio di stato del pin.
}

void loop() {
  delay(1000);
  contatore++; //incremento ad ogni loop.
  Serial.print(contatore);
  Serial.println("   Contatore Aumentato;");
}

void decremento() {
  contatore--; //decremento per ogni pressione sul pulsante.
  Serial.print(contatore);
  Serial.println("   Contatore Diminuito;");
}
