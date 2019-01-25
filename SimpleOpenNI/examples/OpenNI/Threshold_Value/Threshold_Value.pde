//1: import libraries:: -> sketch ->Import Library
import SimpleOpenNI.*;
//2: make a variable to to hold the SimpleOpenNI object (to be able to access data from the kinect)
SimpleOpenNI kinect;
 
//3: declare PImage variable to hold and display the pixel data from the kinect
 
PImage depthCam;
 
//4: declare PImage variable to hold only the pixel data in range ...  
PImage result;
//3:: setup
void setup()
{
 
  // make the sketch size a that of kinect sample
  size(640, 480);
  // set a background color
  background(0);
  // instantatiate the SimpleOpenNI object
  //paremeter : is the current context
  kinect  = new SimpleOpenNI(this);
  //put this in setup so that we can tell the lib in advance what type of data we want
 
  //invoke the method from the lib to allow access to the depth camera
  kinect.enableDepth();
 
  // create an empty PImage container
  result = createImage(width,height,RGB);
}
 
//4: our drawing loop
void draw()
{
  //reset the background
  background(0);
  // get the next frame from the kinect
  kinect.update();
  // get the depth image and assign to the PImage var (using the lib)
  depthCam = kinect.depthImage();
 
  // get the depthMap (mm) values
  int[] depthVals = kinect.depthMap();
 
  // load the pixel array of the result image
  result.loadPixels();
 
 
  //go through the matrix - for each row go through every column
  for (int y=0; y<depthCam.height; y++)
  {
    //go through each col
    for (int x =0; x<depthCam.width; x++)
    {
      // get the location in the depthVals array
      int loc = x+(y*depthCam.width);
      // if the depth values of the sampled image are in range
      if (depthVals[loc] > 610 && depthVals[loc]< 900 )
      {
        //let the pixel value in the result image be white
        result.pixels[loc] = color(255);
      }
      else
      //otherwise let the pixel value in the result image be white
       result.pixels[loc] = color(0);
 
    }
  }
  // update
  result.updatePixels();
  //display the result
  image(result, 0, 0);
}