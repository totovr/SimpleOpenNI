/* --------------------------------------------------------------------------
 * SimpleOpenNI UserDefDepthView Test
 * --------------------------------------------------------------------------
 * Processing Wrapper for the OpenNI/Kinect 2 library
 * http://code.google.com/p/simple-openni
 * --------------------------------------------------------------------------
 * prog:  Max Rheiner / Interaction Design / Zhdk / http://iad.zhdk.ch/
 * date:  12/12/2012 (m/d/y)
 * ----------------------------------------------------------------------------
 * This example shows how to use a UserDefinedCoordinateSystem
 * Watch out, that you have alternativeViewPointDepthToImage enabled, if you
 * recorded the it with this option
 * ----------------------------------------------------------------------------
 */

import SimpleOpenNI.*;

SimpleOpenNI context;
float        zoomF =0.3f;
float        rotX = radians(180);  // by default rotate the hole scene 180deg around the x-axis, 
                                   // the data from openni comes upside down
float        rotY = radians(0);

void setup()
{
  size(1024,768,P3D);

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
  
  // align depth data to image data
  context.alternativeViewPointDepthToImage();
 
  // set a user defined coordsys 
  context.setUserCoordsys( -76.832214, -637.94025, 1626.0, 
                           203.97232, -632.82764, 1665.0, 
                           -105.86082, -616.4177, 1833.0 );    
 
  stroke(255,255,255);
  smooth();
  perspective(radians(45),
              float(width)/float(height),
              10,150000);             
}

void draw()
{
  // update the cam
  context.update();

  background(0,0,0);

  translate(width/2, height/2, 0);
  rotateX(rotX);
  rotateY(rotY);
  scale(zoomF);

  int[]   depthMap = context.depthMap();
  int     steps    = 2;  // to speed up the drawing, draw every third point
  int     index;
  PVector realWorldPoint;
 
  stroke(255);

  PVector[] realWorldMap = context.depthMapRealWorld();
  
  // draw pointcloud
  beginShape(POINTS);
  for(int y=0;y < context.depthHeight();y+=steps)
  {
    for(int x=0;x < context.depthWidth();x+=steps)
    {
      index = x + y * context.depthWidth();
      if(depthMap[index] > 0)
      { 
        // draw the projected point
        realWorldPoint = realWorldMap[index];
        vertex(realWorldPoint.x,realWorldPoint.y,realWorldPoint.z);  // make realworld z negative, in the 3d drawing coordsystem +z points in the direction of the eye
      }
    }
  } 
  endShape();
  
  // userdef null point
  stroke(255,0,0);
  line(0,0,0,
       500,0,0);
       
  stroke(0,255,0);
  line(0,0,0,
       0,500,0);

  stroke(0,0,255);
  line(0,0,0,
       0,0,500);
  
  // draw the kinect cam
  context.drawCamFrustum();
}


void keyPressed()
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
      if(zoomF < 0.01)
        zoomF = 0.01;
    }
    else
      rotX -= 0.1f;
    break;
  }
}

