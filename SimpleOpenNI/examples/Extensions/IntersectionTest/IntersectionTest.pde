/* --------------------------------------------------------------------------
 * SimpleOpenNI Intersection Test
 * --------------------------------------------------------------------------
 * Processing Wrapper for the OpenNI/Kinect library
 * http://code.google.com/p/simple-openni
 * --------------------------------------------------------------------------
 * prog:  Max Rheiner / Interaction Design / zhdk / http://iad.zhdk.ch/
 * date:  05/14/2012 (m/d/y)
 * ----------------------------------------------------------------------------
 * Gives an example how to use intersections(rayTriangle)
 * ----------------------------------------------------------------------------
 */
 
import SimpleOpenNI.*;


SimpleOpenNI context;
float        zoomF =0.5f;
float        rotX = radians(180);  // by default rotate the hole scene 180deg around the x-axis, 
                                   // the data from openni comes upside down
float        rotY = radians(0);
boolean      autoCalib=true;

PVector      bodyCenter = new PVector();
PVector      bodyDir = new PVector();

PVector[]   triangle1 = new PVector[3];
PVector[]   triangle2 = new PVector[3];

PVector     sphere1;
float       sphere1Radius;

void setup()
{
  size(1024,768,P3D);
  context = new SimpleOpenNI(this);
   
  // disable mirror
  context.setMirror(false);

  // enable depthMap generation 
  if(context.enableDepth() == false)
  {
     println("Can't open the depthMap, maybe the camera is not connected!"); 
     exit();
     return;
  }

  // enable skeleton generation for all joints
  context.enableUser(SimpleOpenNI.SKEL_PROFILE_ALL);

  stroke(255,255,255);
  smooth();  
  perspective(radians(45),
              float(width)/float(height),
              10,150000);
              
  // setup the triangles
  triangle1[0] = new PVector(500,0,1500);
  triangle1[1] = new PVector(-500,0,1500);
  triangle1[2] = new PVector(0,500,1500);
  
  triangle2[0] = new PVector(1000,0,2500);
  triangle2[1] = new PVector(1000,0,3500);
  triangle2[2] = new PVector(1000,500,3000);
  
  sphere1 = new PVector(-1000,500,3000);
  sphere1Radius = 200;
    
 }

void draw()
{
  // update the cam
  context.update();

  background(0,0,0);
  
  // set the scene pos
  translate(width/2, height/2, 0);
  rotateX(rotX);
  rotateY(rotY);
  scale(zoomF);
  
  int[]   depthMap = context.depthMap();
  int     steps   = 3;  // to speed up the drawing, draw every third point
  int     index;
  PVector realWorldPoint;
 
  translate(0,0,-1000);  // set the rotation center of the scene 1000 infront of the camera

  stroke(100); 
  for(int y=0;y < context.depthHeight();y+=steps)
  {
    for(int x=0;x < context.depthWidth();x+=steps)
    {
      index = x + y * context.depthWidth();
      if(depthMap[index] > 0)
      { 
        // draw the projected point
        realWorldPoint = context.depthMapRealWorld()[index];
        point(realWorldPoint.x,realWorldPoint.y,realWorldPoint.z);
      }
    } 
  } 
  
  // draw the skeleton if it's available
  int[] userList = context.getUsers();
  for(int i=0;i<userList.length;i++)
  {
    if(context.isTrackingSkeleton(userList[i]))
      drawSkeleton(userList[i]);
  }      
 
  // draw the kinect cam
  context.drawCamFrustum();
}

// draw the skeleton with the selected joints
void drawSkeleton(int userId)
{
  strokeWeight(3);

  // to get the 3d joint data
  drawLimb(userId, SimpleOpenNI.SKEL_HEAD, SimpleOpenNI.SKEL_NECK);

  drawLimb(userId, SimpleOpenNI.SKEL_NECK, SimpleOpenNI.SKEL_LEFT_SHOULDER);
  drawLimb(userId, SimpleOpenNI.SKEL_LEFT_SHOULDER, SimpleOpenNI.SKEL_LEFT_ELBOW);
  drawLimb(userId, SimpleOpenNI.SKEL_LEFT_ELBOW, SimpleOpenNI.SKEL_LEFT_HAND);

  drawLimb(userId, SimpleOpenNI.SKEL_NECK, SimpleOpenNI.SKEL_RIGHT_SHOULDER);
  drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_SHOULDER, SimpleOpenNI.SKEL_RIGHT_ELBOW);
  drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_ELBOW, SimpleOpenNI.SKEL_RIGHT_HAND);

  drawLimb(userId, SimpleOpenNI.SKEL_LEFT_SHOULDER, SimpleOpenNI.SKEL_TORSO);
  drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_SHOULDER, SimpleOpenNI.SKEL_TORSO);

  drawLimb(userId, SimpleOpenNI.SKEL_TORSO, SimpleOpenNI.SKEL_LEFT_HIP);
  drawLimb(userId, SimpleOpenNI.SKEL_LEFT_HIP, SimpleOpenNI.SKEL_LEFT_KNEE);
  drawLimb(userId, SimpleOpenNI.SKEL_LEFT_KNEE, SimpleOpenNI.SKEL_LEFT_FOOT);

  drawLimb(userId, SimpleOpenNI.SKEL_TORSO, SimpleOpenNI.SKEL_RIGHT_HIP);
  drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_HIP, SimpleOpenNI.SKEL_RIGHT_KNEE);
  drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_KNEE, SimpleOpenNI.SKEL_RIGHT_FOOT);  

  // draw body direction
  getBodyDirection(userId,bodyCenter,bodyDir);
  
  bodyDir.mult(200);  // 200mm length
  bodyDir.add(bodyCenter);
  
  stroke(255,200,200);
  line(bodyCenter.x,bodyCenter.y,bodyCenter.z,
       bodyDir.x ,bodyDir.y,bodyDir.z);

  strokeWeight(1);
  
  // test for intersections
  drawIntersection(userId);
 
}

void drawLimb(int userId,int jointType1,int jointType2)
{
  PVector jointPos1 = new PVector();
  PVector jointPos2 = new PVector();
  float  confidence;
  
  // draw the joint position
  confidence = context.getJointPositionSkeleton(userId,jointType1,jointPos1);
  confidence = context.getJointPositionSkeleton(userId,jointType2,jointPos2);

  stroke(255,0,0,confidence * 200 + 55);
  line(jointPos1.x,jointPos1.y,jointPos1.z,
       jointPos2.x,jointPos2.y,jointPos2.z);
  
  drawJointOrientation(userId,jointType1,jointPos1,50);
}

void drawJointOrientation(int userId,int jointType,PVector pos,float length)
{
  // draw the joint orientation  
  PMatrix3D  orientation = new PMatrix3D();
  float confidence = context.getJointOrientationSkeleton(userId,jointType,orientation);
  if(confidence < 0.001f) 
    // nothing to draw, orientation data is useless
    return;
    
  pushMatrix();
    translate(pos.x,pos.y,pos.z);
    
    // set the local coordsys
    applyMatrix(orientation);
    
    // coordsys lines are 100mm long
    // x - r
    stroke(255,0,0,confidence * 200 + 55);
    line(0,0,0,
         length,0,0);
    // y - g
    stroke(0,255,0,confidence * 200 + 55);
    line(0,0,0,
         0,length,0);
    // z - b    
    stroke(0,0,255,confidence * 200 + 55);
    line(0,0,0,
         0,0,length);
  popMatrix();
}


void drawIntersection(int userId)
{
  pushStyle();
  noFill();
  
  PVector jointPos1 = new PVector();
  PVector jointPos2 = new PVector();
  float  confidence;
  
  // draw the joint position
  confidence = context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_LEFT_ELBOW,jointPos1);
  confidence = context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_LEFT_HAND,jointPos2);

  // draw ray from the hand + 2m
  PVector dir = PVector.sub(jointPos2,jointPos1);
  dir.normalize();
  PVector rayEnd = PVector.mult(dir,2000);
  rayEnd.add(jointPos2);
  
  line(jointPos2.x,jointPos2.y,jointPos2.z,
       rayEnd.x,rayEnd.y,rayEnd.z);
  
  // test for intersections
  PVector hit1 = new PVector();
  boolean intersection1 = SimpleOpenNI.rayTriangleIntersection(jointPos2,dir, 
      			    	                               triangle1[0],triangle1[1],triangle1[2],
                                                               hit1);

  PVector hit2 = new PVector();
  boolean intersection2 = SimpleOpenNI.rayTriangleIntersection(jointPos2,dir, 
      			    	                               triangle2[0],triangle2[1],triangle2[2],
                                                               hit2);

  
  // draw triangle
  strokeWeight(1);
  
  if(intersection1)
  { // draw hit point
    strokeWeight(7);
    stroke(255,0,255);   
    point(hit1.x,hit1.y,hit1.z);    
    strokeWeight(3);
  }    
  else
    strokeWeight(1); 
  stroke(255,255,0);   
  
  beginShape();
  for(int i=0; i < triangle1.length;i++)
    vertex(triangle1[i].x,triangle1[i].y,triangle1[i].z);
  endShape(CLOSE);
  
  if(intersection2)
  { // draw hit point
    strokeWeight(7);
    stroke(255,0,255);   
    point(hit2.x,hit2.y,hit2.z);    
    strokeWeight(3);
  }   
  else
    strokeWeight(1);
  stroke(255,255,0);   
  
  beginShape();
  for(int i=0; i < triangle2.length;i++)
    vertex(triangle2[i].x,triangle2[i].y,triangle2[i].z);
  endShape(CLOSE);
  
  // draw sphere
  int intersectionSphere = SimpleOpenNI.raySphereIntersection(jointPos2,dir, 
      			    	                              sphere1,sphere1Radius,
                                                              hit1,hit2);

  
  if(intersectionSphere > 0)
  { // draw hit point
    strokeWeight(7);

    stroke(255,0,255);   
    point(hit1.x,hit1.y,hit1.z);   
 
    if(intersectionSphere > 1)
      point(hit2.x,hit2.y,hit2.z);   
    
    strokeWeight(3);
  }   
  else
    strokeWeight(1);
  stroke(255,255,0);  
  
  pushMatrix();
  translate(sphere1.x,sphere1.y,sphere1.z);
  sphereDetail(10);
  sphere(sphere1Radius);
  popMatrix();
  
  
  popStyle();
}


// -----------------------------------------------------------------
// SimpleOpenNI user events

void onNewUser(int userId)
{
  println("onNewUser - userId: " + userId);
  println("  start pose detection");
  
  if(autoCalib)
    context.requestCalibrationSkeleton(userId,true);
  else    
    context.startPoseDetection("Psi",userId);
}

void onLostUser(int userId)
{
  println("onLostUser - userId: " + userId);
}

void onExitUser(int userId)
{
  println("onExitUser - userId: " + userId);
}

void onReEnterUser(int userId)
{
  println("onReEnterUser - userId: " + userId);
}


void onStartCalibration(int userId)
{
  println("onStartCalibration - userId: " + userId);
}

void onEndCalibration(int userId, boolean successfull)
{
  println("onEndCalibration - userId: " + userId + ", successfull: " + successfull);
  
  if (successfull) 
  { 
    println("  User calibrated !!!");
    context.startTrackingSkeleton(userId); 
  } 
  else 
  { 
    println("  Failed to calibrate user !!!");
    println("  Start pose detection");
    context.startPoseDetection("Psi",userId);
  }
}

void onStartPose(String pose,int userId)
{
  println("onStartdPose - userId: " + userId + ", pose: " + pose);
  println(" stop pose detection");
  
  context.stopPoseDetection(userId); 
  context.requestCalibrationSkeleton(userId, true);
 
}

void onEndPose(String pose,int userId)
{
  println("onEndPose - userId: " + userId + ", pose: " + pose);
}

// -----------------------------------------------------------------
// Keyboard events

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
        zoomF += 0.01f;
      else
        rotX += 0.1f;
      break;
    case DOWN:
      if(keyEvent.isShiftDown())
      {
        zoomF -= 0.01f;
        if(zoomF < 0.01)
          zoomF = 0.01;
      }
      else
        rotX -= 0.1f;
      break;
  }
}

void getBodyDirection(int userId,PVector centerPoint,PVector dir)
{
  PVector jointL = new PVector();
  PVector jointH = new PVector();
  PVector jointR = new PVector();
  float  confidence;
  
  // draw the joint position
  confidence = context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_LEFT_SHOULDER,jointL);
  confidence = context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_HEAD,jointH);
  confidence = context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_RIGHT_SHOULDER,jointR);
  
  // take the neck as the center point
  confidence = context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_NECK,centerPoint);
  
  /*  // manually calc the centerPoint
  PVector shoulderDist = PVector.sub(jointL,jointR);
  centerPoint.set(PVector.mult(shoulderDist,.5));
  centerPoint.add(jointR);
  */
  
  PVector up = new PVector();
  PVector left = new PVector();
  
  up.set(PVector.sub(jointH,centerPoint));
  left.set(PVector.sub(jointR,centerPoint));
  
  dir.set(up.cross(left));
  dir.normalize();
}
