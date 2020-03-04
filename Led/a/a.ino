void setup() {
 pinMode(2, OUTPUT);
 pinMode(3, OUTPUT);
 pinMode(4, OUTPUT);
 Serial.begin(9600);
}

void loop() {
 bool led1 = true;
    bool led2 = true;
    bool led3 = true;

    while(led1 == true || led2 == true || led3 == true)
    {
        if(led1==true)
        {
            led1 = false;
        }
        else
        {
            led1 = true;
            if(led2==true)
            {
                led2=false;
            }
            else
            {
                led2=true;
                if(led3==true)
                {
                    led3=false;
                }
                else
                {
                    led3=true;
                }
            }
        }
        if(led3==true)
        {
            digitalWrite(4,LOW);
        }
        else
        {
            digitalWrite(4,LOW);
        };
        if(led2==true)
        {
            digitalWrite(3,LOW);
        }
        else
        {
            digitalWrite(3,LOW);
        };
        if(led1==true)
        {
            digitalWrite(2,LOW);
        }
        else
        {
            digitalWrite(2,LOW);
        }
    }
}
