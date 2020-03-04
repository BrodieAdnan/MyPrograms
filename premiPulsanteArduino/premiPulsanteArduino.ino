const int ledPin = 2;
const int buttonPin = 8;
bool buttonState = 0;
bool prevState = buttonState;
bool ledState = 0;
int time = 0;
int debounce = 200;

void setup() {
  pinMode(ledPin, OUTPUT);
  pinMode(buttonPin, INPUT);
  Serial.begin(9600);
}

void loop() {
  buttonState = digitalRead(buttonPin);
  Serial.println("buttonState: "+buttonState);
  if(buttonState==HIGH && prevState==LOW && millis()-time > debounce){
    ledState=(!ledState);
    digitalWrite(ledPin, ledState);
    Serial.print(ledState);
    time = millis();
    Serial.println("prevState: "+prevState);
  }
  prevState = buttonState;
}
