import SimpleOpenNI.*;

//Generate a SimpleOpenNI object
SimpleOpenNI kinect;


void setup() {
 kinect = new SimpleOpenNI(this);
 kinect.enableDepth();
 //kinect.enableIR();
 kinect.enableUser();// because of the version this change
 size(640, 480);
 fill(255, 0, 0);
 //size(kinect.depthWidth()+kinect.irWidth(), kinect.depthHeight());
 kinect.setMirror(false);


}

void draw() {

  kinect.update();
  //image(kinect.depthImage(), 0, 0);
  //image(kinect.irImage(),kinect.depthWidth(),0);
  image(kinect.userImage(),0,0);


  IntVector userList = new IntVector();
  kinect.getUsers(userList);

  if (userList.size() > 0) {
    int userId = userList.get(0);
    //If we detect one user we have to draw it
    if ( kinect.isTrackingSkeleton(userId)) {
      bola(userId);
    }
  }
}

void bola(int userId) {

  //rightHand
  PVector rightHand = new PVector();
  kinect.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_LEFT_HAND,rightHand);
  PVector convertedRightHand = new PVector();
  kinect.convertRealWorldToProjective(rightHand, convertedRightHand);
  ellipse(convertedRightHand.x, convertedRightHand.y, 20, 20);

  //leftHand
  PVector leftHand = new PVector();
  kinect.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_RIGHT_HAND,leftHand);
  PVector convertedLeftHand = new PVector();
  kinect.convertRealWorldToProjective(leftHand, convertedLeftHand);
  ellipse(convertedLeftHand.x, convertedLeftHand.y, 20, 20);

  // calculate difference by subtracting one vector from another
  PVector differenceVector = PVector.sub(leftHand, rightHand);
  // calculate the distance and direction
  // of the difference vector
  float magnitude = differenceVector.mag();
  differenceVector.normalize();
  // draw a line between the two handsst
  kinect.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_HAND, SimpleOpenNI.SKEL_RIGHT_HAND);
  // display
  pushMatrix();
    scale(4);
    fill(differenceVector.x * 255, differenceVector.y * 255, differenceVector.z * 255);
    text("Centimeters: " + magnitude, 5, 10);
  popMatrix();

}

//Calibration not required

void onNewUser(SimpleOpenNI kinect, int userID){
  println("Start tracking");
  kinect.startTrackingSkeleton(userID);
}

void onLostUser(SimpleOpenNI curContext, int userId){
  println("onLostUser - userId: " + userId);
}
