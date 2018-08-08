/* --------------------------------------------------------------------------
 * SimpleOpenNI Multi Camera Test
 * --------------------------------------------------------------------------
 * Processing Wrapper for the OpenNI/Kinect 2 library
 * http://code.google.com/p/simple-openni
 * --------------------------------------------------------------------------
 * prog:  Max Rheiner / Interaction Design / Zhdk / http://iad.zhdk.ch/
 * date:  12/12/2012 (m/d/y)
 * ----------------------------------------------------------------------------
 * Be aware that you shouln't put the cameras at the same usb bus !!!!!!!!!!!!!!!!!
 * On linux/OSX  you can use the command 'lsusb' to see on which bus the camera is
 * This demo does not work. NITE is not specified to work with multiple cameras.
 * ----------------------------------------------------------------------------
 */

import SimpleOpenNI.*;

SimpleOpenNI  cam1;
SimpleOpenNI  cam2;
color[]       userClr = new color[]{ color(255,0,0),
                                     color(0,255,0),
                                     color(0,0,255),
                                     color(255,255,0),
                                     color(255,0,255),
                                     color(0,255,255)
                                   };

void setup()
{
  size(640 * 2 + 10,480); 

  // start OpenNI, load the library
  SimpleOpenNI.start();
  
  // print all the cams 
  StrVector strList = new StrVector();
  SimpleOpenNI.deviceNames(strList);
  for(int i=0;i<strList.size();i++)
    println(i + ":" + strList.get(i));

  // check if there are enough cams  
  if(strList.size() < 2)
  {
    println("only works with 2 cams");
    exit();
    return;
  }  
  
  // init the cameras
  cam1 = new SimpleOpenNI(0,this);
  cam2 = new SimpleOpenNI(1,this);
  /*
  cam1 = new SimpleOpenNI(0,this,SimpleOpenNI.RUN_MODE_MULTI_THREADED);
  cam2 = new SimpleOpenNI(1,this,SimpleOpenNI.RUN_MODE_MULTI_THREADED);
  */
  if(cam1.isInit() == false || cam2.isInit() == false)
  {
     println("Verify that you have two connected cameras on two different usb-busses!"); 
     exit();
     return;  
  }
  
  // set the camera generators
  // enable depthMap generation 
  cam1.enableDepth();
  cam1.enableUser();
 
  // enable depthMap generation 
  cam2.enableDepth();
  cam2.enableUser();
 
  background(10,200,20);
}

void draw()
{
  // update the cam
  SimpleOpenNI.updateAll();
  
  // draw depthImageMap
  image(cam1.depthImage(),0,0);

  // draw the skeleton if it's available
  int[] userList = cam1.getUsers();
  for(int i=0;i<userList.length;i++)
  {
    if(cam1.isTrackingSkeleton(userList[i]))
    {
      stroke(userClr[ (userList[i] - 1) % userClr.length ] );
      drawSkeleton(cam1,userList[i]);
    }      
  }   
  
  pushMatrix();
  // shift to the cam2 area
  translate(cam1.depthWidth() + 10,0);
  
  // draw the depth map
  image(cam2.depthImage(),0,0);
   
  // draw the skeleton 
  userList = cam2.getUsers();
  for(int i=0;i<userList.length;i++)
  {
    if(cam2.isTrackingSkeleton(userList[i]))
    {
      stroke(userClr[ (userList[i] - 1) % userClr.length ] );
      drawSkeleton(cam2,userList[i]);
    }      
  }     
  popMatrix();
  
}

// draw the skeleton with the selected joints
void drawSkeleton(SimpleOpenNI curContext,int userId)
{
  // to get the 3d joint data
  /*
  PVector jointPos = new PVector();
  curContext.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_NECK,jointPos);
  println(jointPos);
  */
  
  curContext.drawLimb(userId, SimpleOpenNI.SKEL_HEAD, SimpleOpenNI.SKEL_NECK);

  curContext.drawLimb(userId, SimpleOpenNI.SKEL_NECK, SimpleOpenNI.SKEL_LEFT_SHOULDER);
  curContext.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_SHOULDER, SimpleOpenNI.SKEL_LEFT_ELBOW);
  curContext.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_ELBOW, SimpleOpenNI.SKEL_LEFT_HAND);

  curContext.drawLimb(userId, SimpleOpenNI.SKEL_NECK, SimpleOpenNI.SKEL_RIGHT_SHOULDER);
  curContext.drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_SHOULDER, SimpleOpenNI.SKEL_RIGHT_ELBOW);
  curContext.drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_ELBOW, SimpleOpenNI.SKEL_RIGHT_HAND);

  curContext.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_SHOULDER, SimpleOpenNI.SKEL_TORSO);
  curContext.drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_SHOULDER, SimpleOpenNI.SKEL_TORSO);

  curContext.drawLimb(userId, SimpleOpenNI.SKEL_TORSO, SimpleOpenNI.SKEL_LEFT_HIP);
  curContext.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_HIP, SimpleOpenNI.SKEL_LEFT_KNEE);
  curContext.drawLimb(userId, SimpleOpenNI.SKEL_LEFT_KNEE, SimpleOpenNI.SKEL_LEFT_FOOT);

  curContext.drawLimb(userId, SimpleOpenNI.SKEL_TORSO, SimpleOpenNI.SKEL_RIGHT_HIP);
  curContext.drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_HIP, SimpleOpenNI.SKEL_RIGHT_KNEE);
  curContext.drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_KNEE, SimpleOpenNI.SKEL_RIGHT_FOOT);  
}

// -----------------------------------------------------------------
// SimpleOpenNI events

void onNewUser(SimpleOpenNI curContext, int userId)
{
  println("onNewUser - deviceIndex: " + curContext.deviceIndex() + " , " + "userId: " + userId);
  println("\tstart tracking skeleton");
  
  curContext.startTrackingSkeleton(userId);
}

void onLostUser(SimpleOpenNI curContext, int userId)
{
  println("onLostUser - userId: " + userId);
}

void onVisibleUser(SimpleOpenNI curContext, int userId)
{
  //println("onVisibleUser - userId: " + userId);
}

void onOutOfSceneUser(SimpleOpenNI curContext, int userId)
{
  println("onOutOfSceneUserUser - userId: " + userId);
}
