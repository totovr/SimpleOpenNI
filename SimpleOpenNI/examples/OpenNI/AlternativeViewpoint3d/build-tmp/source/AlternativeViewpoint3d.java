import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import SimpleOpenNI.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class AlternativeViewpoint3d extends PApplet {

/* --------------------------------------------------------------------------
 * SimpleOpenNI AlternativeViewpoint3d Test
 * --------------------------------------------------------------------------
 * Processing Wrapper for the OpenNI/Kinect 2 library
 * http://code.google.com/p/simple-openni
 * --------------------------------------------------------------------------
 * prog:  Max Rheiner / Interaction Design / Zhdk / http://iad.zhdk.ch/
 * date:  12/12/2012 (m/d/y)
 * ----------------------------------------------------------------------------
 */



SimpleOpenNI context;
float        zoomF =0.3f;
float        rotX = radians(180);  // by default rotate the hole scene 180deg around the x-axis, 
                                   // the data from openni comes upside down
float        rotY = radians(0);
PShape       pointCloud;
int          steps = 2;

public void setup()
{
  

  //context = new SimpleOpenNI(this,SimpleOpenNI.RUN_MODE_MULTI_THREADED);
  context = new SimpleOpenNI(this);
  if(context.isInit() == false)
  {
     println("Can't init SimpleOpenNI, maybe the camera is not connected!"); 
     exit();
     return;  
  }
  
  // disable mirror
  context.setMirror(false);

  // enable depthMap generation 
  context.enableDepth();

  context.enableRGB();
 
  // align depth data to image data
  context.alternativeViewPointDepthToImage();
  context.setDepthColorSyncEnabled(true);
 
  stroke(255,255,255);
  
  perspective(radians(45),
              PApplet.parseFloat(width)/PApplet.parseFloat(height), 
              10,150000);
}

public void draw()
{
  // update the cam
  context.update();

  background(0,0,0);

  translate(width/2, height/2, 0);
  rotateX(rotX);
  rotateY(rotY);
  scale(zoomF);

  PImage  rgbImage = context.rgbImage();
  int[]   depthMap = context.depthMap();
  int     steps   = 4;  // to speed up the drawing, draw every third point
  int     index;
  PVector realWorldPoint;
  int   pixelColor;
 
  strokeWeight((float)steps/2);

  translate(0,0,-1000);  // set the rotation center of the scene 1000 infront of the camera

  PVector[] realWorldMap = context.depthMapRealWorld();
  beginShape(POINTS);
  for(int y=0;y < context.depthHeight();y+=steps)
  {
    for(int x=0;x < context.depthWidth();x+=steps)
    {
      index = x + y * context.depthWidth();
      if(depthMap[index] > 0)
      { 
        // get the color of the point
        pixelColor = rgbImage.pixels[index];
        stroke(pixelColor);
        
        // draw the projected point
        realWorldPoint = realWorldMap[index];
        vertex(realWorldPoint.x,realWorldPoint.y,realWorldPoint.z);  // make realworld z negative, in the 3d drawing coordsystem +z points in the direction of the eye
      }
    }
  } 
  endShape();
  
  // draw the kinect cam
  strokeWeight(1);
  context.drawCamFrustum();
}


public void keyPressed()
{
  switch(key)
  {
  case ' ':
    context.setMirror(!context.mirror());
    break;
  }

  switch(keyCode)
  {
  case LEFT:
    rotY += 0.1f;
    break;
  case RIGHT:
    // zoom out
    rotY -= 0.1f;
    break;
  case UP:
    if(keyEvent.isShiftDown())
      zoomF += 0.02f;
    else
      rotX += 0.1f;
    break;
  case DOWN:
    if(keyEvent.isShiftDown())
    {
      zoomF -= 0.02f;
      if(zoomF < 0.01f)
        zoomF = 0.01f;
    }
    else
      rotX -= 0.1f;
    break;
  }
}

  public void settings() {  size(1024,768,P3D);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "AlternativeViewpoint3d" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
