const int led1 = 12;
const int led2 = 9;
const int led3 = 7;
const int buttonPin = 2;
bool buttonState = 0;
bool prevState = buttonState;
bool ledState = 0;
int time = 0;
int debounce = 200;

void setup() {
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(buttonPin, INPUT);
  Serial.begin(9600);
}

void loop() {
bool bit [3] =  {false, false, false};
digitalWrite(led1, LOW);
digitalWrite(led2, LOW);
digitalWrite(led3, LOW);
buttonState=digitalRead(buttonPin);
if(buttonState==HIGH && prevState==LOW && millis()-time > debounce){
  time = millis();
}
prevState=buttonState;
Serial.println(buttonState);
while(bit[0] == false || bit[1] == false || bit[2] == false){
for(int i=0 ; i<3 && buttonState == LOW; i++){
if(bit[i]==true){
bit[i]=false;
}
else{
bit[i]=true;
i=2;
}
}
for(int i=0 ; i<3 && buttonState == HIGH; i++){
if(bit[i]==false){
bit[i]=true;
}
else{
bit[i]=false;
i=2;
}
}
for(int i=0 ; i<3 && buttonState == LOW; i++){
if(bit[i]==false){
bit[i]=false;
}
else{
bit[i]=true;
i=2;
}
}
}
}
