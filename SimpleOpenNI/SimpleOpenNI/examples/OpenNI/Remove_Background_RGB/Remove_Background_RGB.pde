//user map
 
import SimpleOpenNI.*;
SimpleOpenNI  kinect;      
int [] userMap;
 
void setup()
{
  size(640,480);
  kinect = new SimpleOpenNI(this);
  if(kinect.isInit() == false)
  {
     println("Can't init SimpleOpenNI, maybe the camera is not connected!"); 
     exit();
     return;  
  }
 
  // enable depthMap generation 
  kinect.enableDepth();
 
  // enable RGB camera
  kinect.enableRGB(); 
 
  // enable skeleton generation for all joints
  kinect.enableUser();
 
  // turn on depth-color alignment 
  kinect.alternativeViewPointDepthToImage();
  background(0);
  }
 
void draw()
{
  // update the cam
  background(0);
  kinect.update();
 
  // get the Kinect color image
  PImage rgbImage = kinect.rgbImage(); 
  // prepare the color pixels 
  rgbImage.loadPixels();
 
 
  int[] userList = kinect.getUsers();
  if(userList.length>0)
  {
    userMap = kinect.userMap();
    // load sketches pixels
    loadPixels();
   for(int i=0; i<userMap.length; i++)
    {
      if(userMap[i]!=0)
      {
         // set the sketch pixel to the color pixel
          pixels[i] = rgbImage.pixels[i];
      }
      else
      {
        pixels[i] = color(0);
      }
    }
   updatePixels();
 
  }  
}