/* --------------------------------------------------------------------------
 * SimpleOpenNI IR Test
 * --------------------------------------------------------------------------
 * Processing Wrapper for the OpenNI/Kinect 2 library
 * http://code.google.com/p/simple-openni
 * --------------------------------------------------------------------------
 * prog:  Max Rheiner / Interaction Design / Zhdk / http://iad.zhdk.ch/
 * date:  12/12/2012 (m/d/y)
 * ----------------------------------------------------------------------------
 */

import SimpleOpenNI.*;


SimpleOpenNI  context;

void setup()
{
  size(640, 480);
  context = new SimpleOpenNI(this);
  if(context.isInit() == false)
  {
     println("Can't init SimpleOpenNI, maybe the camera is not connected!"); 
     exit();
     return;  
  }
  
  // enable depthMap generation 
  context.enableDepth();
  
  // enable ir generation
  context.enableIR();
  
  background(200,0,0);
}

void draw()
{
  // update the cam
  context.update();
  
  // draw depthImageMap
  image(context.depthImage(),0,0);
  
  // draw irImageMap
  image(context.irImage(),context.depthWidth() + 10,0);
}
