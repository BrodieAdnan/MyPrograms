void setup() {
Serial.begin(9600);
}
int tempo[3];
int a;
void loop() {
  while(!Serial.available());
  char c=Serial.read();
  if(c=='\n'){
  Serial.println("Testo a capo!");
} else {
  Serial.print(c);
}
delay(1000);
}
