void setup()
{
  Serial.begin(9600);
  Serial.println(F("Internal Temperature Sensor"));
  pinMode(2, OUTPUT);
}
void loop()
{
  accendi();
  Serial.println(GetTemp(), 1);
}

double GetTemp(void)
{
  unsigned int wADC;
  double t;

  ADMUX = (_BV(REFS1) | _BV(REFS0) | _BV(MUX3));
  ADCSRA |= _BV(ADEN);  // enable the ADC

  delay(20);            // wait for voltages to become stable.

  ADCSRA |= _BV(ADSC);  // Start the ADC

  while (bit_is_set(ADCSRA, ADSC));
  wADC = ADCW;

  t = (wADC - 324.31 ) / 1.22;

  return (t);
}
void accendi(){
  digitalWrite(2, LOW);
  delay(16);
  digitalWrite(2, HIGH);
}
