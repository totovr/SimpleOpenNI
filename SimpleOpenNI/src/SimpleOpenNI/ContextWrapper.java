package SimpleOpenNI;

public class ContextWrapper
{
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected ContextWrapper(long paramLong, boolean paramBoolean)
  {
    swigCMemOwn = paramBoolean;
    swigCPtr = paramLong;
  }

  protected static long getCPtr(ContextWrapper paramContextWrapper) {
    return paramContextWrapper == null ? 0L : 0;//swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0L) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        SimpleOpenNIJNI.delete_ContextWrapper(swigCPtr);
      }
      swigCPtr = 0L;
    }
  }

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    SimpleOpenNIJNI.ContextWrapper_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    SimpleOpenNIJNI.ContextWrapper_change_ownership(this, swigCPtr, true);
  }

  public ContextWrapper() {
    this(SimpleOpenNIJNI.new_ContextWrapper(), true);
    SimpleOpenNIJNI.ContextWrapper_director_connect(this, swigCPtr, swigCMemOwn, true);
  }

  public int version() {
    return SimpleOpenNIJNI.ContextWrapper_version(swigCPtr, this);
  }

  public static void chdir(String paramString) {
    SimpleOpenNIJNI.ContextWrapper_chdir(paramString);
  }

  public static String getcwd() {
    return SimpleOpenNIJNI.ContextWrapper_getcwd();
  }

  public static boolean initContext() {
    return SimpleOpenNIJNI.ContextWrapper_initContext();
  }

  public boolean init(int paramInt) {
    return SimpleOpenNIJNI.ContextWrapper_init__SWIG_0(swigCPtr, this, paramInt);
  }

  public boolean init() {
    return SimpleOpenNIJNI.ContextWrapper_init__SWIG_1(swigCPtr, this);
  }

  public boolean init(String paramString, int paramInt) {
    return SimpleOpenNIJNI.ContextWrapper_init__SWIG_2(swigCPtr, this, paramString, paramInt);
  }

  public boolean init(String paramString) {
    return SimpleOpenNIJNI.ContextWrapper_init__SWIG_3(swigCPtr, this, paramString);
  }

  public boolean init(int paramInt1, int paramInt2) {
    return SimpleOpenNIJNI.ContextWrapper_init__SWIG_4(swigCPtr, this, paramInt1, paramInt2);
  }

  public int nodes() {
    return SimpleOpenNIJNI.ContextWrapper_nodes(swigCPtr, this);
  }

  public static int deviceCount() {
    return SimpleOpenNIJNI.ContextWrapper_deviceCount();
  }

  public static int deviceNames(StrVector paramStrVector) {
    return SimpleOpenNIJNI.ContextWrapper_deviceNames(StrVector.getCPtr(paramStrVector), paramStrVector);
  }

  public int deviceIndex() {
    return SimpleOpenNIJNI.ContextWrapper_deviceIndex(swigCPtr, this);
  }

  public boolean isInit() {
    return SimpleOpenNIJNI.ContextWrapper_isInit(swigCPtr, this);
  }

  public void close() {
    SimpleOpenNIJNI.ContextWrapper_close(swigCPtr, this);
  }

  public boolean enableDepth() {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableDepth__SWIG_0(swigCPtr, this) : SimpleOpenNIJNI.ContextWrapper_enableDepthSwigExplicitContextWrapper__SWIG_0(swigCPtr, this);
  }

  public boolean enableDepth(int paramInt1, int paramInt2, int paramInt3) {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableDepth__SWIG_1(swigCPtr, this, paramInt1, paramInt2, paramInt3) : SimpleOpenNIJNI.ContextWrapper_enableDepthSwigExplicitContextWrapper__SWIG_1(swigCPtr, this, paramInt1, paramInt2, paramInt3);
  }

  public boolean enableRGB() {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableRGB__SWIG_0(swigCPtr, this) : SimpleOpenNIJNI.ContextWrapper_enableRGBSwigExplicitContextWrapper__SWIG_0(swigCPtr, this);
  }

  public boolean enableRGB(int paramInt1, int paramInt2, int paramInt3) {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableRGB__SWIG_1(swigCPtr, this, paramInt1, paramInt2, paramInt3) : SimpleOpenNIJNI.ContextWrapper_enableRGBSwigExplicitContextWrapper__SWIG_1(swigCPtr, this, paramInt1, paramInt2, paramInt3);
  }

  public boolean enableIR() {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableIR__SWIG_0(swigCPtr, this) : SimpleOpenNIJNI.ContextWrapper_enableIRSwigExplicitContextWrapper__SWIG_0(swigCPtr, this);
  }

  public boolean enableIR(int paramInt1, int paramInt2, int paramInt3) {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableIR__SWIG_1(swigCPtr, this, paramInt1, paramInt2, paramInt3) : SimpleOpenNIJNI.ContextWrapper_enableIRSwigExplicitContextWrapper__SWIG_1(swigCPtr, this, paramInt1, paramInt2, paramInt3);
  }

  public boolean enableUser() {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableUser(swigCPtr, this) : SimpleOpenNIJNI.ContextWrapper_enableUserSwigExplicitContextWrapper(swigCPtr, this);
  }

  public boolean enableHand() {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableHand(swigCPtr, this) : SimpleOpenNIJNI.ContextWrapper_enableHandSwigExplicitContextWrapper(swigCPtr, this);
  }

  public void update() {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_update(swigCPtr, this); else SimpleOpenNIJNI.ContextWrapper_updateSwigExplicitContextWrapper(swigCPtr, this); 
  }

  public static void updateAll()
  {
    SimpleOpenNIJNI.ContextWrapper_updateAll();
  }

  public int depthWidth() {
    return SimpleOpenNIJNI.ContextWrapper_depthWidth(swigCPtr, this);
  }

  public int depthHeight() {
    return SimpleOpenNIJNI.ContextWrapper_depthHeight(swigCPtr, this);
  }

  public int depthImage(int[] paramArrayOfInt) {
    return SimpleOpenNIJNI.ContextWrapper_depthImage(swigCPtr, this, paramArrayOfInt);
  }

  public void setDepthImageColor(int paramInt1, int paramInt2, int paramInt3) {
    SimpleOpenNIJNI.ContextWrapper_setDepthImageColor(swigCPtr, this, paramInt1, paramInt2, paramInt3);
  }

  public void setDepthImageColorMode(int paramInt) {
    SimpleOpenNIJNI.ContextWrapper_setDepthImageColorMode(swigCPtr, this, paramInt);
  }

  public int depthImageColorMode() {
    return SimpleOpenNIJNI.ContextWrapper_depthImageColorMode(swigCPtr, this);
  }

  public int depthMapSize() {
    return SimpleOpenNIJNI.ContextWrapper_depthMapSize(swigCPtr, this);
  }

  public int depthMap(int[] paramArrayOfInt) {
    return SimpleOpenNIJNI.ContextWrapper_depthMap(swigCPtr, this, paramArrayOfInt);
  }

  public int depthMapRealWorld(float[] paramArrayOfFloat) {
    return SimpleOpenNIJNI.ContextWrapper_depthMapRealWorld(swigCPtr, this, paramArrayOfFloat);
  }

  public float hFieldOfView() {
    return SimpleOpenNIJNI.ContextWrapper_hFieldOfView(swigCPtr, this);
  }

  public float vFieldOfView() {
    return SimpleOpenNIJNI.ContextWrapper_vFieldOfView(swigCPtr, this);
  }

  public int rgbWidth() {
    return SimpleOpenNIJNI.ContextWrapper_rgbWidth(swigCPtr, this);
  }

  public int rgbHeight() {
    return SimpleOpenNIJNI.ContextWrapper_rgbHeight(swigCPtr, this);
  }

  public int rgbImage(int[] paramArrayOfInt) {
    return SimpleOpenNIJNI.ContextWrapper_rgbImage(swigCPtr, this, paramArrayOfInt);
  }

  public int irWidth() {
    return SimpleOpenNIJNI.ContextWrapper_irWidth(swigCPtr, this);
  }

  public int irHeight() {
    return SimpleOpenNIJNI.ContextWrapper_irHeight(swigCPtr, this);
  }

  public int irMap(int[] paramArrayOfInt) {
    return SimpleOpenNIJNI.ContextWrapper_irMap(swigCPtr, this, paramArrayOfInt);
  }

  public int irImage(int[] paramArrayOfInt) {
    return SimpleOpenNIJNI.ContextWrapper_irImage(swigCPtr, this, paramArrayOfInt);
  }

  public int userWidth() {
    return SimpleOpenNIJNI.ContextWrapper_userWidth(swigCPtr, this);
  }

  public int userHeight() {
    return SimpleOpenNIJNI.ContextWrapper_userHeight(swigCPtr, this);
  }

  public boolean getCoM(int paramInt, float[] paramArrayOfFloat) {
    return SimpleOpenNIJNI.ContextWrapper_getCoM(swigCPtr, this, paramInt, paramArrayOfFloat);
  }

  public boolean getBoundingBox(int paramInt, float[] paramArrayOfFloat) {
    return SimpleOpenNIJNI.ContextWrapper_getBoundingBox(swigCPtr, this, paramInt, paramArrayOfFloat);
  }

  public int getNumberOfUsers() {
    return SimpleOpenNIJNI.ContextWrapper_getNumberOfUsers(swigCPtr, this);
  }

  public int getUsers(IntVector paramIntVector) {
    return SimpleOpenNIJNI.ContextWrapper_getUsers(swigCPtr, this, IntVector.getCPtr(paramIntVector), paramIntVector);
  }

  public int userMap(int[] paramArrayOfInt) {
    return SimpleOpenNIJNI.ContextWrapper_userMap(swigCPtr, this, paramArrayOfInt);
  }

  public int userImage(int[] paramArrayOfInt) {
    return SimpleOpenNIJNI.ContextWrapper_userImage(swigCPtr, this, paramArrayOfInt);
  }

  public boolean isTrackingSkeleton(int paramInt) {
    return SimpleOpenNIJNI.ContextWrapper_isTrackingSkeleton(swigCPtr, this, paramInt);
  }

  public void startTrackingSkeleton(int paramInt) {
    SimpleOpenNIJNI.ContextWrapper_startTrackingSkeleton(swigCPtr, this, paramInt);
  }

  public void stopTrackingSkeleton(int paramInt) {
    SimpleOpenNIJNI.ContextWrapper_stopTrackingSkeleton(swigCPtr, this, paramInt);
  }

  public float getJointPositionSkeleton(int paramInt1, int paramInt2, float[] paramArrayOfFloat) {
    return SimpleOpenNIJNI.ContextWrapper_getJointPositionSkeleton(swigCPtr, this, paramInt1, paramInt2, paramArrayOfFloat);
  }

  public float getJointOrientationSkeleton(int paramInt1, int paramInt2, float[] paramArrayOfFloat) {
    return SimpleOpenNIJNI.ContextWrapper_getJointOrientationSkeleton(swigCPtr, this, paramInt1, paramInt2, paramArrayOfFloat);
  }

  public int startTrackingHand(float[] paramArrayOfFloat) {
    return SimpleOpenNIJNI.ContextWrapper_startTrackingHand(swigCPtr, this, paramArrayOfFloat);
  }

  public void stopTrackingHand(int paramInt) {
    SimpleOpenNIJNI.ContextWrapper_stopTrackingHand(swigCPtr, this, paramInt);
  }

  public void stopTrackingAllHand() {
    SimpleOpenNIJNI.ContextWrapper_stopTrackingAllHand(swigCPtr, this);
  }

  public void setSmoothingHand(float paramFloat) {
    SimpleOpenNIJNI.ContextWrapper_setSmoothingHand(swigCPtr, this, paramFloat);
  }

  public float getSmoothingHand() {
    return SimpleOpenNIJNI.ContextWrapper_getSmoothingHand(swigCPtr, this);
  }

  public void startGesture(int paramInt) {
    SimpleOpenNIJNI.ContextWrapper_startGesture(swigCPtr, this, paramInt);
  }

  public void endGesture(int paramInt) {
    SimpleOpenNIJNI.ContextWrapper_endGesture(swigCPtr, this, paramInt);
  }

  public boolean enableRecorder(String paramString) {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_enableRecorder(swigCPtr, this, paramString) : SimpleOpenNIJNI.ContextWrapper_enableRecorderSwigExplicitContextWrapper(swigCPtr, this, paramString);
  }

  public boolean addNodeToRecording(int paramInt, boolean paramBoolean) {
    return SimpleOpenNIJNI.ContextWrapper_addNodeToRecording(swigCPtr, this, paramInt, paramBoolean);
  }

  public boolean openFileRecording(String paramString) {
    return getClass() == ContextWrapper.class ? SimpleOpenNIJNI.ContextWrapper_openFileRecording(swigCPtr, this, paramString) : SimpleOpenNIJNI.ContextWrapper_openFileRecordingSwigExplicitContextWrapper(swigCPtr, this, paramString);
  }

  public void playbackPlay(boolean paramBoolean) {
    SimpleOpenNIJNI.ContextWrapper_playbackPlay(swigCPtr, this, paramBoolean);
  }

  public boolean isPlaybackPlay() {
    return SimpleOpenNIJNI.ContextWrapper_isPlaybackPlay(swigCPtr, this);
  }

  public void setPlaybackSpeedPlayer(float paramFloat) {
    SimpleOpenNIJNI.ContextWrapper_setPlaybackSpeedPlayer(swigCPtr, this, paramFloat);
  }

  public float playbackSpeedPlayer() {
    return SimpleOpenNIJNI.ContextWrapper_playbackSpeedPlayer(swigCPtr, this);
  }

  public void setRepeatPlayer(boolean paramBoolean) {
    SimpleOpenNIJNI.ContextWrapper_setRepeatPlayer(swigCPtr, this, paramBoolean);
  }

  public boolean repeatPlayer() {
    return SimpleOpenNIJNI.ContextWrapper_repeatPlayer(swigCPtr, this);
  }

  public int curFramePlayer() {
    return SimpleOpenNIJNI.ContextWrapper_curFramePlayer(swigCPtr, this);
  }

  public int framesPlayer() {
    return SimpleOpenNIJNI.ContextWrapper_framesPlayer(swigCPtr, this);
  }

  public void seekPlayer(int paramInt) {
    SimpleOpenNIJNI.ContextWrapper_seekPlayer(swigCPtr, this, paramInt);
  }

  public boolean isEndPlayer() {
    return SimpleOpenNIJNI.ContextWrapper_isEndPlayer(swigCPtr, this);
  }

  public void setMirror(boolean paramBoolean) {
    SimpleOpenNIJNI.ContextWrapper_setMirror(swigCPtr, this, paramBoolean);
  }

  public boolean mirror() {
    return SimpleOpenNIJNI.ContextWrapper_mirror(swigCPtr, this);
  }

  public void convertRealWorldToProjective(float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3) {
    SimpleOpenNIJNI.ContextWrapper_convertRealWorldToProjective__SWIG_0(swigCPtr, this, paramFloat1, paramFloat2, paramFloat3, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3);
  }

  public void convertRealWorldToProjective(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2) {
    SimpleOpenNIJNI.ContextWrapper_convertRealWorldToProjective__SWIG_1(swigCPtr, this, paramArrayOfFloat1, paramArrayOfFloat2);
  }

  public void convertProjectiveToRealWorld(float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3) {
    SimpleOpenNIJNI.ContextWrapper_convertProjectiveToRealWorld__SWIG_0(swigCPtr, this, paramFloat1, paramFloat2, paramFloat3, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3);
  }

  public void convertProjectiveToRealWorld(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2) {
    SimpleOpenNIJNI.ContextWrapper_convertProjectiveToRealWorld__SWIG_1(swigCPtr, this, paramArrayOfFloat1, paramArrayOfFloat2);
  }

  public boolean alternativeViewPointDepthToImage() {
    return SimpleOpenNIJNI.ContextWrapper_alternativeViewPointDepthToImage(swigCPtr, this);
  }

  public boolean setDepthToColor(boolean paramBoolean) {
    return SimpleOpenNIJNI.ContextWrapper_setDepthToColor(swigCPtr, this, paramBoolean);
  }

  public boolean depthToColor() {
    return SimpleOpenNIJNI.ContextWrapper_depthToColor(swigCPtr, this);
  }

  public boolean setDepthColorSyncEnabled(boolean paramBoolean) {
    return SimpleOpenNIJNI.ContextWrapper_setDepthColorSyncEnabled(swigCPtr, this, paramBoolean);
  }

  public void setUserCoordsys(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
    SimpleOpenNIJNI.ContextWrapper_setUserCoordsys(swigCPtr, this, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }

  public void resetUserCoordsys() {
    SimpleOpenNIJNI.ContextWrapper_resetUserCoordsys(swigCPtr, this);
  }

  public boolean hasUserCoordsys() {
    return SimpleOpenNIJNI.ContextWrapper_hasUserCoordsys(swigCPtr, this);
  }

  public void getUserCoordsysTransMat(float[] paramArrayOfFloat) {
    SimpleOpenNIJNI.ContextWrapper_getUserCoordsysTransMat(swigCPtr, this, paramArrayOfFloat);
  }

  public void calcUserCoordsys(float[] paramArrayOfFloat) {
    SimpleOpenNIJNI.ContextWrapper_calcUserCoordsys(swigCPtr, this, paramArrayOfFloat);
  }

  public void calcUserCoordsysMat(float[] paramArrayOfFloat) {
    SimpleOpenNIJNI.ContextWrapper_calcUserCoordsysMat(swigCPtr, this, paramArrayOfFloat);
  }

  public void calcUserCoordsysBack(float[] paramArrayOfFloat) {
    SimpleOpenNIJNI.ContextWrapper_calcUserCoordsysBack(swigCPtr, this, paramArrayOfFloat);
  }

  public void calcUserCoordsysBackMat(float[] paramArrayOfFloat) {
    SimpleOpenNIJNI.ContextWrapper_calcUserCoordsysBackMat(swigCPtr, this, paramArrayOfFloat);
  }

  public void getUserCoordsys(float[] paramArrayOfFloat) {
    SimpleOpenNIJNI.ContextWrapper_getUserCoordsys(swigCPtr, this, paramArrayOfFloat);
  }

  public void getUserCoordsysBack(float[] paramArrayOfFloat) {
    SimpleOpenNIJNI.ContextWrapper_getUserCoordsysBack(swigCPtr, this, paramArrayOfFloat);
  }

  public static boolean rayTriangleIntersection(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6) {
    return SimpleOpenNIJNI.ContextWrapper_rayTriangleIntersection(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfFloat4, paramArrayOfFloat5, paramArrayOfFloat6);
  }

  public static int raySphereIntersection(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float paramFloat, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5) {
    return SimpleOpenNIJNI.ContextWrapper_raySphereIntersection(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramFloat, paramArrayOfFloat4, paramArrayOfFloat5);
  }

  public long depthMapTimeStamp() {
    return SimpleOpenNIJNI.ContextWrapper_depthMapTimeStamp(swigCPtr, this);
  }

  public long depthImageTimeStamp() {
    return SimpleOpenNIJNI.ContextWrapper_depthImageTimeStamp(swigCPtr, this);
  }

  public long depthRealWorldTimeStamp() {
    return SimpleOpenNIJNI.ContextWrapper_depthRealWorldTimeStamp(swigCPtr, this);
  }

  public long imageTimeStamp() {
    return SimpleOpenNIJNI.ContextWrapper_imageTimeStamp(swigCPtr, this);
  }

  public long irTimeStamp() {
    return SimpleOpenNIJNI.ContextWrapper_irTimeStamp(swigCPtr, this);
  }

  public long sceneTimeStamp() {
    return SimpleOpenNIJNI.ContextWrapper_sceneTimeStamp(swigCPtr, this);
  }

  public long userTimeStamp() {
    return SimpleOpenNIJNI.ContextWrapper_userTimeStamp(swigCPtr, this);
  }

  public long handTimeStamp() {
    return SimpleOpenNIJNI.ContextWrapper_handTimeStamp(swigCPtr, this);
  }

  public long updateTimeStamp() {
    return SimpleOpenNIJNI.ContextWrapper_updateTimeStamp(swigCPtr, this);
  }

  public long updateSubTimeStamp() {
    return SimpleOpenNIJNI.ContextWrapper_updateSubTimeStamp(swigCPtr, this);
  }

  protected void onNewUserCb(int paramInt) {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onNewUserCb(swigCPtr, this, paramInt); else SimpleOpenNIJNI.ContextWrapper_onNewUserCbSwigExplicitContextWrapper(swigCPtr, this, paramInt); 
  }

  protected void onLostUserCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onLostUserCb(swigCPtr, this, paramInt); else SimpleOpenNIJNI.ContextWrapper_onLostUserCbSwigExplicitContextWrapper(swigCPtr, this, paramInt); 
  }

  protected void onVisibleUserCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onVisibleUserCb(swigCPtr, this, paramInt); else SimpleOpenNIJNI.ContextWrapper_onVisibleUserCbSwigExplicitContextWrapper(swigCPtr, this, paramInt); 
  }

  protected void onOutOfSceneUserCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onOutOfSceneUserCb(swigCPtr, this, paramInt); else SimpleOpenNIJNI.ContextWrapper_onOutOfSceneUserCbSwigExplicitContextWrapper(swigCPtr, this, paramInt); 
  }

  protected void onNewHandCb(int paramInt, Vec3f paramVec3f)
  {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onNewHandCb(swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f); else SimpleOpenNIJNI.ContextWrapper_onNewHandCbSwigExplicitContextWrapper(swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f); 
  }

  protected void onTrackedHandCb(int paramInt, Vec3f paramVec3f)
  {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onTrackedHandCb(swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f); else SimpleOpenNIJNI.ContextWrapper_onTrackedHandCbSwigExplicitContextWrapper(swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f); 
  }

  protected void onLostHandCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onLostHandCb(swigCPtr, this, paramInt); else SimpleOpenNIJNI.ContextWrapper_onLostHandCbSwigExplicitContextWrapper(swigCPtr, this, paramInt); 
  }

  protected void onNewGestureCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onNewGestureCb(swigCPtr, this, paramInt); else SimpleOpenNIJNI.ContextWrapper_onNewGestureCbSwigExplicitContextWrapper(swigCPtr, this, paramInt); 
  }

  protected void onInProgressGestureCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onInProgressGestureCb(swigCPtr, this, paramInt); else SimpleOpenNIJNI.ContextWrapper_onInProgressGestureCbSwigExplicitContextWrapper(swigCPtr, this, paramInt); 
  }

  protected void onAbortedGestureCb(int paramInt)
  {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onAbortedGestureCb(swigCPtr, this, paramInt); else SimpleOpenNIJNI.ContextWrapper_onAbortedGestureCbSwigExplicitContextWrapper(swigCPtr, this, paramInt); 
  }

  protected void onCompletedGestureCb(int paramInt, Vec3f paramVec3f)
  {
    if (getClass() == ContextWrapper.class) SimpleOpenNIJNI.ContextWrapper_onCompletedGestureCb(swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f); else SimpleOpenNIJNI.ContextWrapper_onCompletedGestureCbSwigExplicitContextWrapper(swigCPtr, this, paramInt, Vec3f.getCPtr(paramVec3f), paramVec3f);
  }
}