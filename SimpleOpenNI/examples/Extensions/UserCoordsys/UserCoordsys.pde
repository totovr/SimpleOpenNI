/* --------------------------------------------------------------------------
 * SimpleOpenNI UserCoordsys Test
 * --------------------------------------------------------------------------
 * Processing Wrapper for the OpenNI/Kinect library
 * http://code.google.com/p/simple-openni
 * --------------------------------------------------------------------------
 * prog:  Max Rheiner / Interaction Design / zhdk / http://iad.zhdk.ch/
 * date:  05/06/2012 (m/d/y)
 * ----------------------------------------------------------------------------
 * This example shows how to setup a user defined coordiate system.
 * You have to devine the new nullpoint + the x/z axis.
 * This can be also usefull if you work with two independend cameras
 * ----------------------------------------------------------------------------
 */

import SimpleOpenNI.*;

final static int CALIB_START     = 0;
final static int CALIB_NULLPOINT = 1;
final static int CALIB_X_POINT   = 2;
final static int CALIB_Z_POINT   = 3;
final static int CALIB_DONE      = 4;

SimpleOpenNI  context;
boolean       screenFlag = true;
int           calibMode = CALIB_START;

PVector   nullPoint3d = new PVector();
PVector   xDirPoint3d = new PVector();
PVector   zDirPoint3d = new PVector();
PVector   tempVec1 = new PVector();
PVector   tempVec2 = new PVector();
PVector   tempVec3 = new PVector();

PMatrix3D   userCoordsysMat = new PMatrix3D();

void setup()
{  
  size(640, 480);
  smooth();

  context = new SimpleOpenNI(this);

  context.setMirror(false);

  // enable depthMap generation 
  if (context.enableDepth() == false)
  {
    println("Can't open the depthMap, maybe the camera is not connected!"); 
    exit();
    return;
  }

  if (context.enableRGB() == false)
  {
    println("Can't open the rgbMap, maybe the camera is not connected or there is no rgbSensor!"); 
    exit();
    return;
  }

  // align depth data to image data
  context.alternativeViewPointDepthToImage();

  // Create the font
  textFont(createFont("Georgia", 16));
}

void draw()
{  
  // update the cam
  context.update();

  if (screenFlag)
    image(context.rgbImage(), 0, 0);
  else
    image(context.depthImage(), 0, 0);

  // draw text background
  pushStyle();
  noStroke();
  fill(0,200,0,100);
  rect(0,0,width,40);
  popStyle();
  
  switch(calibMode)
  {
  case CALIB_START:
    text("To start the calibration press SPACE!", 5, 30);
    break;
  case CALIB_NULLPOINT:
    text("Set the nullpoint with the left mousebutton", 5, 30);
    break;
  case CALIB_X_POINT:
    text("Set the x-axis with the left mousebutton", 5, 30);
    break;
  case CALIB_Z_POINT:
    text("Set the z-axis with the left mousebutton", 5, 30);
    break;
  case CALIB_DONE:
    text("New nullpoint is defined!", 5, 30);
    break;
  }

  // draw 
  drawCalibPoint();

  // draw the user defined coordinate system
  //  with the size of  500mm
  if (context.hasUserCoordsys())
  {
    PVector temp = new PVector();
    PVector nullPoint = new PVector();

    pushStyle();

    strokeWeight(3);
    noFill();        

    context.convertRealWorldToProjective(new PVector(0, 0, 0), tempVec1);  
    stroke(255, 255, 255, 150);
    ellipse(tempVec1.x, tempVec1.y, 10, 10); 

    context.convertRealWorldToProjective(new PVector(500, 0, 0), tempVec2);        
    stroke(255, 0, 0, 150);
    line(tempVec1.x, tempVec1.y, 
    tempVec2.x, tempVec2.y); 

    context.convertRealWorldToProjective(new PVector(0, 500, 0), tempVec2);        
    stroke(0, 255, 0, 150);
    line(tempVec1.x, tempVec1.y, 
    tempVec2.x, tempVec2.y); 

    context.convertRealWorldToProjective(new PVector(0, 0, 500), tempVec2);        
    stroke(0, 0, 255, 150);
    line(tempVec1.x, tempVec1.y, 
    tempVec2.x, tempVec2.y); 

    popStyle();
  }
}

void drawCalibPoint()
{
  pushStyle();

  strokeWeight(3);
  noFill();

  switch(calibMode)
  {
  case CALIB_START:    
    break;
  case CALIB_NULLPOINT:
    context.convertRealWorldToProjective(nullPoint3d, tempVec1);

    stroke(255, 255, 255, 150);
    ellipse(tempVec1.x, tempVec1.y, 10, 10);  
    break;
  case CALIB_X_POINT:
    // draw the null point
    context.convertRealWorldToProjective(nullPoint3d, tempVec1);
    context.convertRealWorldToProjective(xDirPoint3d, tempVec2);

    stroke(255, 255, 255, 150);
    ellipse(tempVec1.x, tempVec1.y, 10, 10);  

    stroke(255, 0, 0, 150);
    ellipse(tempVec2.x, tempVec2.y, 10, 10);  
    line(tempVec1.x, tempVec1.y, tempVec2.x, tempVec2.y);

    break;
  case CALIB_Z_POINT:

    context.convertRealWorldToProjective(nullPoint3d, tempVec1);
    context.convertRealWorldToProjective(xDirPoint3d, tempVec2);
    context.convertRealWorldToProjective(zDirPoint3d, tempVec3);

    stroke(255, 255, 255, 150);
    ellipse(tempVec1.x, tempVec1.y, 10, 10);  

    stroke(255, 0, 0, 150);
    ellipse(tempVec2.x, tempVec2.y, 10, 10);  
    line(tempVec1.x, tempVec1.y, tempVec2.x, tempVec2.y);

    stroke(0, 0, 255, 150);
    ellipse(tempVec3.x, tempVec3.y, 10, 10);  
    line(tempVec1.x, tempVec1.y, tempVec3.x, tempVec3.y);

    break;
  case CALIB_DONE:


    break;
  }

  popStyle();
}

void keyPressed()
{
  switch(key)
  {
  case '1': 
    screenFlag = !screenFlag; 
    break;
  case ' ': 
    calibMode++;
    if (calibMode > CALIB_DONE)
    {
      calibMode = CALIB_START; 
      context.resetUserCoordsys();
    }
    else if (calibMode == CALIB_DONE)
    {  
      // set the calibration
      context.setUserCoordsys(nullPoint3d.x, nullPoint3d.y, nullPoint3d.z, 
                              xDirPoint3d.x, xDirPoint3d.y, xDirPoint3d.z, 
                              zDirPoint3d.x, zDirPoint3d.y, zDirPoint3d.z);

      println("Set the user define coordinatesystem");
      println("nullPoint3d: " + nullPoint3d);
      println("xDirPoint3d: " + xDirPoint3d);
      println("zDirPoint3d: " + zDirPoint3d);

      /*
      // test
      context.getUserCoordsysTransMat(userCoordsysMat);
      PVector temp = new PVector();

      userCoordsysMat.mult(new PVector(0, 0, 0), temp);         
      println("PVector(0,0,0): " + temp);

      userCoordsysMat.mult(new PVector(500, 0, 0), temp);        
      println("PVector(500,0,0): " + temp);

      userCoordsysMat.mult(new PVector(0, 500, 0), temp);        
      println("PVector(0,500,0): " + temp);

      userCoordsysMat.mult(new PVector(0, 0, 500), temp);
      println("PVector(0,0,500): " + temp);
      */
    }

    break;
  }
}  

void mousePressed() 
{
  if (mouseButton == LEFT)
  {
    PVector[] realWorldMap = context.depthMapRealWorld();
    int index = mouseX + mouseY * context.depthWidth();

    switch(calibMode)
    {
    case CALIB_NULLPOINT:
      nullPoint3d.set(realWorldMap[index]);
      break;
    case CALIB_X_POINT:
      xDirPoint3d.set(realWorldMap[index]);
      break;
    case CALIB_Z_POINT:
      zDirPoint3d.set(realWorldMap[index]);
      break;
    }
  }
  else
  {
    PVector[] realWorldMap = context.depthMapRealWorld();
    int index = mouseX + mouseY * context.depthWidth();  

    println("Point3d: " + realWorldMap[index].x + "," + realWorldMap[index].y + "," + realWorldMap[index].z);
  }
}

void mouseDragged() 
{
  if (mouseButton == LEFT)
  {
    PVector[] realWorldMap = context.depthMapRealWorld();
    int index = mouseX + mouseY * context.depthWidth();

    switch(calibMode)
    {
    case CALIB_NULLPOINT:
      nullPoint3d.set(realWorldMap[index]);
      break;
    case CALIB_X_POINT:
      xDirPoint3d.set(realWorldMap[index]);
      break;
    case CALIB_Z_POINT:
      zDirPoint3d.set(realWorldMap[index]);
      break;
    }
  }

}

