/* --------------------------------------------------------------------------
 * SimpleOpenNI Record/Play Test
 * --------------------------------------------------------------------------
 * Processing Wrapper for the OpenNI/Kinect 2 library
 * http://code.google.com/p/simple-openni
 * --------------------------------------------------------------------------
 * prog:  Max Rheiner / Interaction Design / Zhdk / http://iad.zhdk.ch/
 * date:  12/12/2012 (m/d/y)
 * ----------------------------------------------------------------------------
 * For playing the recorded file, just set recordFlag to false
 * All files should be in the data subfolder of the current project, abs.
 * path work as well
 * ----------------------------------------------------------------------------
 */

import SimpleOpenNI.*;


SimpleOpenNI  context;
boolean       recordFlag = true;
String        recordPath = "test1.oni";

void setup()
{
  size(2 * 640 + 10,480);
  
  if(recordFlag == false)
  {
     context = new SimpleOpenNI(this,recordPath);
     
     println("curFramePlayer: " + context.curFramePlayer());
  }
  else
  {  
    context = new SimpleOpenNI(this);
    if(context.isInit() == false)
    {
       println("Can't init SimpleOpenNI, maybe the camera is not connected!"); 
       exit();
       return;  
    }
    
    // recording
    // enable depthMap generation 
    context.enableDepth();

    // enable ir generation
    context.enableRGB();

    // setup the recording 
    context.enableRecorder(recordPath);

    // select the recording channels
    context.addNodeToRecording(SimpleOpenNI.NODE_DEPTH,true);
    context.addNodeToRecording(SimpleOpenNI.NODE_IMAGE,true);
  }

}

void draw()
{
  // update
  context.update(); 

  background(200, 0, 0);

  // draw the cam data
  if ((context.nodes() & SimpleOpenNI.NODE_DEPTH) != 0)
  {
    if ((context.nodes() & SimpleOpenNI.NODE_IMAGE) != 0)
    {
      image(context.depthImage(), 0, 0);   
      image(context.rgbImage(), context.depthWidth() + 10, 0);
    }
    else
      image(context.depthImage(), 0, 0);
  }

  // draw timeline
  if(recordFlag == false)
  {
    drawTimeline();
    text("curFramePlayer: " + context.curFramePlayer(),10,10);
  }    
    
}

void drawTimeline()
{
  pushStyle();

  stroke(255,255,0);
  line(10, height - 20, 
       width -10 ,height - 20);  

  stroke(0);
  rectMode(CENTER);
  fill(255,255,0);
  
  int pos = (int)((width - 2 * 10) * (float)context.curFramePlayer() / (float)context.framesPlayer());
  rect(pos, height - 20, 
       7,17);  

  popStyle();
}

void keyPressed()
{
  switch(key)
  {
  case CODED:
    switch(keyCode)
    {
    case LEFT:
      // jump back
      context.seekPlayer(context.curFramePlayer() - 3);
      break;
    case RIGHT:
      // jump forward
      context.seekPlayer(context.curFramePlayer() + 3);
      break;
    case UP:
      // slow down
      context.setPlaybackSpeedPlayer(context.playbackSpeedPlayer() * 2.0f);
      println("playbackSpeedPlayer: " + context.playbackSpeedPlayer());
      break;
    case DOWN:
      // speed up
      context.setPlaybackSpeedPlayer(context.playbackSpeedPlayer() * 0.5f);
       println("playbackSpeedPlayer: " + context.playbackSpeedPlayer());
     break;
    }
    break;   
  case ' ':
    // toggle pause
    context.playbackPlay(!context.isPlaybackPlay());
    break;    
  case BACKSPACE:
    // restart
    context.seekPlayer(0);
    break;
  }
}

