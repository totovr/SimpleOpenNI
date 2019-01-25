char val; // Data received from the serial port
int Elbow_Right = 33; // Set the pin to digital I/O 13
int Elbow_Left = 12; // Set the pin to digital I/O 11
int Leg_Left = 14; // Set the pin to digital I/O 11
int Leg_Right = 27; // Set the pin to digital I/O 11

void setup() {
   pinMode(Elbow_Right, OUTPUT); // Set pin as OUTPUT
   pinMode(Elbow_Left, OUTPUT); // Set pin as OUTPUT
   pinMode(Leg_Left, OUTPUT); // Set pin as OUTPUT
   pinMode(Leg_Right, OUTPUT); // Set pin as OUTPUT
   Serial.begin(115200); // Start serial communication at 115200 bps
 }

void loop() {

  if (Serial.available()) 
     { // If data is available to read,
     val = Serial.read(); // read it and store it in val
     }
     
  rightElbow();
  leftElbow();
  leftLeg();
  RightLeg();
  

}

void rightElbow(){
     
  if (val == '1') 
    { // If 1 was received
     digitalWrite(Elbow_Right, HIGH); // turn the LED ON
     } 
   
   if(val == '0') {
     digitalWrite(Elbow_Right, LOW); // otherwise turn it OFF
     }
   //delay(10); // Wait 10 milliseconds for next reading
    
  }

void leftElbow(){
     
  if (val == '2') 
    { // If 1 was received
     digitalWrite(Elbow_Left, HIGH); // turn the LED ON
     } 
   
   if(val == '3') {
     digitalWrite(Elbow_Left, LOW); // otherwise turn it OFF
     }
   //delay(10); // Wait 10 milliseconds for next reading
    
  }

  void leftLeg(){
     
  if (val == '4') 
    { // If 1 was received
     digitalWrite(Leg_Left, HIGH); // turn the LED ON
     } 
   
   if(val == '5') {
     digitalWrite(Leg_Left, LOW); // otherwise turn it OFF
     }
   //delay(10); // Wait 10 milliseconds for next reading
    
  }

  void RightLeg(){
     
  if (val == '6') 
    { // If 1 was received
     digitalWrite(Leg_Right, HIGH); // turn the LED ON
     } 
   
   if(val == '7') {
     digitalWrite(Leg_Right, LOW); // otherwise turn it OFF
     }
   //delay(10); // Wait 10 milliseconds for next reading
    
  }
