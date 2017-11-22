/* --------------------------------------------------------------------------
 * SimpleOpenNI Handsd Test
 * --------------------------------------------------------------------------
 * Processing Wrapper for the OpenNI/Kinect 2 library
 * http://code.google.com/p/simple-openni
 * --------------------------------------------------------------------------
 * prog:  Max Rheiner / Interaction Design / Zhdk / http://iad.zhdk.ch/
 * date:  12/12/2012 (m/d/y)
 * ----------------------------------------------------------------------------
 * Be aware that you shouln't put the cameras at the same usb bus !!!!!!!!!!!!!!!!!
 * On linux/OSX  you can use the command 'lsusb' to see on which bus the camera is
 * This demo works, even if NITE is not specified to work with multiple cameras
 * ----------------------------------------------------------------------------
 */
 
import java.util.Map;
import java.util.Iterator;

import SimpleOpenNI.*;

SimpleOpenNI  cam1;
SimpleOpenNI  cam2;

int handVecListSize = 20;
Map<Integer,ArrayList<PVector>>  handPathList1 = new HashMap<Integer,ArrayList<PVector>>();
Map<Integer,ArrayList<PVector>>  handPathList2 = new HashMap<Integer,ArrayList<PVector>>();

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
  cam1.enableHand();
 
  // enable depthMap generation 
  cam2.enableDepth();
  cam2.enableHand();
 
  background(10,200,20);
  
  // add focus gestures  / here i do have some problems on the mac, i only recognize raiseHand ? Maybe cpu performance ?
  cam1.startGesture(SimpleOpenNI.GESTURE_WAVE);
  cam2.startGesture(SimpleOpenNI.GESTURE_WAVE);
 }

void draw()
{
  // update the cam
  SimpleOpenNI.updateAll();

  // draw cam1
  image(cam1.depthImage(),0,0);  
  // draw the tracked hands
  drawHands(cam1,handPathList1);
  
  // draw cam2
  pushMatrix();
  // shift to the cam2 area
  translate(cam1.depthWidth() + 10,0);
  
  // draw the depth map
  image(cam2.depthImage(),0,0);
  
  drawHands(cam2,handPathList2);
  popMatrix();
}

void drawHands(SimpleOpenNI curContext, Map<Integer,ArrayList<PVector>> pathList)
{
  // draw the tracked hands
  if(pathList.size() > 0)  
  {    
    Iterator itr = pathList.entrySet().iterator();     
    while(itr.hasNext())
    {
      Map.Entry mapEntry = (Map.Entry)itr.next(); 
      int handId =  (Integer)mapEntry.getKey();
      ArrayList<PVector> vecList = (ArrayList<PVector>)mapEntry.getValue();
      PVector p;
      PVector p2d = new PVector();
      
        stroke(userClr[ (handId - 1) % userClr.length ]);
        noFill(); 
        strokeWeight(1);        
        Iterator itrVec = vecList.iterator(); 
        beginShape();
          while( itrVec.hasNext() ) 
          { 
            p = (PVector) itrVec.next(); 
            
            curContext.convertRealWorldToProjective(p,p2d);
            vertex(p2d.x,p2d.y);
          }
        endShape();   
  
        stroke(userClr[ (handId - 1) % userClr.length ]);
        strokeWeight(4);
        p = vecList.get(0);
        curContext.convertRealWorldToProjective(p,p2d);
        point(p2d.x,p2d.y);
    }        
  }
}

// -----------------------------------------------------------------
// hand events

void onNewHand(SimpleOpenNI curContext,int handId,PVector pos)
{
  println("onNewHand - handId: " + handId + ", pos: " + pos);
 
  ArrayList<PVector> vecList = new ArrayList<PVector>();
  vecList.add(pos);
  
  if(curContext == cam1)
    handPathList1.put(handId,vecList);
  else    
    handPathList2.put(handId,vecList);
}

void onTrackedHand(SimpleOpenNI curContext,int handId,PVector pos)
{
  //println("onTrackedHand - handId: " + handId + ", pos: " + pos );
  Map<Integer,ArrayList<PVector>> pathList;
  if(curContext == cam1)
    pathList = handPathList1;
  else    
    pathList = handPathList2;

  ArrayList<PVector> vecList = pathList.get(handId);
  if(vecList != null)
  {
    vecList.add(0,pos);
    if(vecList.size() >= handVecListSize)
      // remove the last point 
      vecList.remove(vecList.size()-1); 
  }  
}

void onLostHand(SimpleOpenNI curContext,int handId)
{
  println("onLostHand - handId: " + handId);

  if(curContext == cam1)
    handPathList1.remove(handId);
  else    
    handPathList2.remove(handId);
}

// -----------------------------------------------------------------
// gesture events

void onCompletedGesture(SimpleOpenNI curContext,int gestureType, PVector pos)
{
  println("onCompletedGesture - deviceIndex: " + curContext.deviceIndex() + " , " + "gestureType: " + gestureType + ", pos: " + pos);
  
  int handId = curContext.startTrackingHand(pos);
  println("hand stracked: " + handId);
}

// -----------------------------------------------------------------
// Keyboard event
void keyPressed()
{

  switch(key)
  {
  case ' ':
    cam1.setMirror(!cam1.mirror());
    cam2.setMirror(!cam2.mirror());
    break;
  case '1':
    cam1.setMirror(true);
    cam2.setMirror(true);
    break;
  case '2':
    cam1.setMirror(false);
    cam2.setMirror(false);
    break;
  }
}
