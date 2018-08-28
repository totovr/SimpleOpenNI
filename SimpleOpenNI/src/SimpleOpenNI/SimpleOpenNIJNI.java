package SimpleOpenNI;

public class SimpleOpenNIJNI
{
  public static final native long new_IntVector__SWIG_0();

  public static final native long new_IntVector__SWIG_1(long paramLong);

  public static final native long IntVector_size(long paramLong, IntVector paramIntVector);

  public static final native long IntVector_capacity(long paramLong, IntVector paramIntVector);

  public static final native void IntVector_reserve(long paramLong1, IntVector paramIntVector, long paramLong2);

  public static final native boolean IntVector_isEmpty(long paramLong, IntVector paramIntVector);

  public static final native void IntVector_clear(long paramLong, IntVector paramIntVector);

  public static final native void IntVector_add(long paramLong, IntVector paramIntVector, int paramInt);

  public static final native int IntVector_get(long paramLong, IntVector paramIntVector, int paramInt);

  public static final native void IntVector_set(long paramLong, IntVector paramIntVector, int paramInt1, int paramInt2);

  public static final native void delete_IntVector(long paramLong);

  public static final native long new_StrVector__SWIG_0();

  public static final native long new_StrVector__SWIG_1(long paramLong);

  public static final native long StrVector_size(long paramLong, StrVector paramStrVector);

  public static final native long StrVector_capacity(long paramLong, StrVector paramStrVector);

  public static final native void StrVector_reserve(long paramLong1, StrVector paramStrVector, long paramLong2);

  public static final native boolean StrVector_isEmpty(long paramLong, StrVector paramStrVector);

  public static final native void StrVector_clear(long paramLong, StrVector paramStrVector);

  public static final native void StrVector_add(long paramLong, StrVector paramStrVector, String paramString);

  public static final native String StrVector_get(long paramLong, StrVector paramStrVector, int paramInt);

  public static final native void StrVector_set(long paramLong, StrVector paramStrVector, int paramInt, String paramString);

  public static final native void delete_StrVector(long paramLong);

  public static final native long new_Vec3f__SWIG_0(float paramFloat1, float paramFloat2, float paramFloat3);

  public static final native long new_Vec3f__SWIG_1(long paramLong, Vec3f paramVec3f);

  public static final native float Vec3f_x(long paramLong, Vec3f paramVec3f);

  public static final native float Vec3f_y(long paramLong, Vec3f paramVec3f);

  public static final native float Vec3f_z(long paramLong, Vec3f paramVec3f);

  public static final native void delete_Vec3f(long paramLong);

  public static final native int SKEL_HEAD_get();

  public static final native int SKEL_NECK_get();

  public static final native int SKEL_TORSO_get();

  public static final native int SKEL_LEFT_SHOULDER_get();

  public static final native int SKEL_LEFT_ELBOW_get();

  public static final native int SKEL_LEFT_HAND_get();

  public static final native int SKEL_LEFT_FINGERTIP_get();

  public static final native int SKEL_RIGHT_SHOULDER_get();

  public static final native int SKEL_RIGHT_ELBOW_get();

  public static final native int SKEL_RIGHT_HAND_get();

  public static final native int SKEL_RIGHT_FINGERTIP_get();

  public static final native int SKEL_LEFT_HIP_get();

  public static final native int SKEL_LEFT_KNEE_get();

  public static final native int SKEL_LEFT_FOOT_get();

  public static final native int SKEL_RIGHT_HIP_get();

  public static final native int SKEL_RIGHT_KNEE_get();

  public static final native int SKEL_RIGHT_FOOT_get();

  public static final native int GESTURE_WAVE_get();

  public static final native int GESTURE_CLICK_get();

  public static final native int GESTURE_HAND_RAISE_get();

  public static final native int NODE_NONE_get();

  public static final native int NODE_DEPTH_get();

  public static final native int NODE_IMAGE_get();

  public static final native int NODE_IR_get();

  public static final native int NODE_SCENE_get();

  public static final native int NODE_USER_get();

  public static final native int NODE_HANDS_get();

  public static final native int NODE_GESTURE_get();

  public static final native int NODE_RECORDER_get();

  public static final native int NODE_PLAYER_get();

  public static final native int IMG_MODE_DEFAULT_get();

  public static final native int IMG_MODE_RGB_FADE_get();

  public static final native int RUN_MODE_DEFAULT_get();

  public static final native int RUN_MODE_SINGLE_THREADED_get();

  public static final native int RUN_MODE_MULTI_THREADED_get();

  public static final native long new_ContextWrapper();

  public static final native void delete_ContextWrapper(long paramLong);

  public static final native int ContextWrapper_version(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_chdir(String paramString);

  public static final native String ContextWrapper_getcwd();

  public static final native boolean ContextWrapper_initContext();

  public static final native boolean ContextWrapper_init__SWIG_0(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native boolean ContextWrapper_init__SWIG_1(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_init__SWIG_2(long paramLong, ContextWrapper paramContextWrapper, String paramString, int paramInt);

  public static final native boolean ContextWrapper_init__SWIG_3(long paramLong, ContextWrapper paramContextWrapper, String paramString);

  public static final native boolean ContextWrapper_init__SWIG_4(long paramLong, ContextWrapper paramContextWrapper, int paramInt1, int paramInt2);

  public static final native int ContextWrapper_nodes(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_deviceCount();

  public static final native int ContextWrapper_deviceNames(long paramLong, StrVector paramStrVector);

  public static final native int ContextWrapper_deviceIndex(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_isInit(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_close(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_enableDepth__SWIG_0(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_enableDepthSwigExplicitContextWrapper__SWIG_0(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_enableDepth__SWIG_1(long paramLong, ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, int paramInt3);

  public static final native boolean ContextWrapper_enableDepthSwigExplicitContextWrapper__SWIG_1(long paramLong, ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, int paramInt3);

  public static final native boolean ContextWrapper_enableRGB__SWIG_0(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_enableRGBSwigExplicitContextWrapper__SWIG_0(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_enableRGB__SWIG_1(long paramLong, ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, int paramInt3);

  public static final native boolean ContextWrapper_enableRGBSwigExplicitContextWrapper__SWIG_1(long paramLong, ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, int paramInt3);

  public static final native boolean ContextWrapper_enableIR__SWIG_0(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_enableIRSwigExplicitContextWrapper__SWIG_0(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_enableIR__SWIG_1(long paramLong, ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, int paramInt3);

  public static final native boolean ContextWrapper_enableIRSwigExplicitContextWrapper__SWIG_1(long paramLong, ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, int paramInt3);

  public static final native boolean ContextWrapper_enableUser(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_enableUserSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_enableHand(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_enableHandSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_update(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_updateSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_updateAll();

  public static final native int ContextWrapper_depthWidth(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_depthHeight(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_depthImage(long paramLong, ContextWrapper paramContextWrapper, int[] paramArrayOfInt);

  public static final native void ContextWrapper_setDepthImageColor(long paramLong, ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, int paramInt3);

  public static final native void ContextWrapper_setDepthImageColorMode(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native int ContextWrapper_depthImageColorMode(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_depthMapSize(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_depthMap(long paramLong, ContextWrapper paramContextWrapper, int[] paramArrayOfInt);

  public static final native int ContextWrapper_depthMapRealWorld(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat);

  public static final native float ContextWrapper_hFieldOfView(long paramLong, ContextWrapper paramContextWrapper);

  public static final native float ContextWrapper_vFieldOfView(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_rgbWidth(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_rgbHeight(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_rgbImage(long paramLong, ContextWrapper paramContextWrapper, int[] paramArrayOfInt);

  public static final native int ContextWrapper_irWidth(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_irHeight(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_irMap(long paramLong, ContextWrapper paramContextWrapper, int[] paramArrayOfInt);

  public static final native int ContextWrapper_irImage(long paramLong, ContextWrapper paramContextWrapper, int[] paramArrayOfInt);

  public static final native int ContextWrapper_userWidth(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_userHeight(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_getCoM(long paramLong, ContextWrapper paramContextWrapper, int paramInt, float[] paramArrayOfFloat);

  public static final native boolean ContextWrapper_getBoundingBox(long paramLong, ContextWrapper paramContextWrapper, int paramInt, float[] paramArrayOfFloat);

  public static final native int ContextWrapper_getNumberOfUsers(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_getUsers(long paramLong1, ContextWrapper paramContextWrapper, long paramLong2, IntVector paramIntVector);

  public static final native int ContextWrapper_userMap(long paramLong, ContextWrapper paramContextWrapper, int[] paramArrayOfInt);

  public static final native int ContextWrapper_userImage(long paramLong, ContextWrapper paramContextWrapper, int[] paramArrayOfInt);

  public static final native boolean ContextWrapper_isTrackingSkeleton(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_startTrackingSkeleton(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_stopTrackingSkeleton(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native float ContextWrapper_getJointPositionSkeleton(long paramLong, ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, float[] paramArrayOfFloat);

  public static final native float ContextWrapper_getJointOrientationSkeleton(long paramLong, ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, float[] paramArrayOfFloat);

  public static final native int ContextWrapper_startTrackingHand(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat);

  public static final native void ContextWrapper_stopTrackingHand(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_stopTrackingAllHand(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_setSmoothingHand(long paramLong, ContextWrapper paramContextWrapper, float paramFloat);

  public static final native float ContextWrapper_getSmoothingHand(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_startGesture(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_endGesture(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native boolean ContextWrapper_enableRecorder(long paramLong, ContextWrapper paramContextWrapper, String paramString);

  public static final native boolean ContextWrapper_enableRecorderSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper, String paramString);

  public static final native boolean ContextWrapper_addNodeToRecording(long paramLong, ContextWrapper paramContextWrapper, int paramInt, boolean paramBoolean);

  public static final native boolean ContextWrapper_openFileRecording(long paramLong, ContextWrapper paramContextWrapper, String paramString);

  public static final native boolean ContextWrapper_openFileRecordingSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper, String paramString);

  public static final native void ContextWrapper_playbackPlay(long paramLong, ContextWrapper paramContextWrapper, boolean paramBoolean);

  public static final native boolean ContextWrapper_isPlaybackPlay(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_setPlaybackSpeedPlayer(long paramLong, ContextWrapper paramContextWrapper, float paramFloat);

  public static final native float ContextWrapper_playbackSpeedPlayer(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_setRepeatPlayer(long paramLong, ContextWrapper paramContextWrapper, boolean paramBoolean);

  public static final native boolean ContextWrapper_repeatPlayer(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_curFramePlayer(long paramLong, ContextWrapper paramContextWrapper);

  public static final native int ContextWrapper_framesPlayer(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_seekPlayer(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native boolean ContextWrapper_isEndPlayer(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_setMirror(long paramLong, ContextWrapper paramContextWrapper, boolean paramBoolean);

  public static final native boolean ContextWrapper_mirror(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_convertRealWorldToProjective__SWIG_0(long paramLong, ContextWrapper paramContextWrapper, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);

  public static final native void ContextWrapper_convertRealWorldToProjective__SWIG_1(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);

  public static final native void ContextWrapper_convertProjectiveToRealWorld__SWIG_0(long paramLong, ContextWrapper paramContextWrapper, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);

  public static final native void ContextWrapper_convertProjectiveToRealWorld__SWIG_1(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);

  public static final native boolean ContextWrapper_alternativeViewPointDepthToImage(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_setDepthToColor(long paramLong, ContextWrapper paramContextWrapper, boolean paramBoolean);

  public static final native boolean ContextWrapper_depthToColor(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_setDepthColorSyncEnabled(long paramLong, ContextWrapper paramContextWrapper, boolean paramBoolean);

  public static final native void ContextWrapper_setUserCoordsys(long paramLong, ContextWrapper paramContextWrapper, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);

  public static final native void ContextWrapper_resetUserCoordsys(long paramLong, ContextWrapper paramContextWrapper);

  public static final native boolean ContextWrapper_hasUserCoordsys(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_getUserCoordsysTransMat(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat);

  public static final native void ContextWrapper_calcUserCoordsys(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat);

  public static final native void ContextWrapper_calcUserCoordsysMat(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat);

  public static final native void ContextWrapper_calcUserCoordsysBack(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat);

  public static final native void ContextWrapper_calcUserCoordsysBackMat(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat);

  public static final native void ContextWrapper_getUserCoordsys(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat);

  public static final native void ContextWrapper_getUserCoordsysBack(long paramLong, ContextWrapper paramContextWrapper, float[] paramArrayOfFloat);

  public static final native boolean ContextWrapper_rayTriangleIntersection(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6);

  public static final native int ContextWrapper_raySphereIntersection(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float paramFloat, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5);

  public static final native long ContextWrapper_depthMapTimeStamp(long paramLong, ContextWrapper paramContextWrapper);

  public static final native long ContextWrapper_depthImageTimeStamp(long paramLong, ContextWrapper paramContextWrapper);

  public static final native long ContextWrapper_depthRealWorldTimeStamp(long paramLong, ContextWrapper paramContextWrapper);

  public static final native long ContextWrapper_imageTimeStamp(long paramLong, ContextWrapper paramContextWrapper);

  public static final native long ContextWrapper_irTimeStamp(long paramLong, ContextWrapper paramContextWrapper);

  public static final native long ContextWrapper_sceneTimeStamp(long paramLong, ContextWrapper paramContextWrapper);

  public static final native long ContextWrapper_userTimeStamp(long paramLong, ContextWrapper paramContextWrapper);

  public static final native long ContextWrapper_handTimeStamp(long paramLong, ContextWrapper paramContextWrapper);

  public static final native long ContextWrapper_updateTimeStamp(long paramLong, ContextWrapper paramContextWrapper);

  public static final native long ContextWrapper_updateSubTimeStamp(long paramLong, ContextWrapper paramContextWrapper);

  public static final native void ContextWrapper_onNewUserCb(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onNewUserCbSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onLostUserCb(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onLostUserCbSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onVisibleUserCb(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onVisibleUserCbSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onOutOfSceneUserCb(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onOutOfSceneUserCbSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onNewHandCb(long paramLong1, ContextWrapper paramContextWrapper, int paramInt, long paramLong2, Vec3f paramVec3f);

  public static final native void ContextWrapper_onNewHandCbSwigExplicitContextWrapper(long paramLong1, ContextWrapper paramContextWrapper, int paramInt, long paramLong2, Vec3f paramVec3f);

  public static final native void ContextWrapper_onTrackedHandCb(long paramLong1, ContextWrapper paramContextWrapper, int paramInt, long paramLong2, Vec3f paramVec3f);

  public static final native void ContextWrapper_onTrackedHandCbSwigExplicitContextWrapper(long paramLong1, ContextWrapper paramContextWrapper, int paramInt, long paramLong2, Vec3f paramVec3f);

  public static final native void ContextWrapper_onLostHandCb(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onLostHandCbSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onNewGestureCb(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onNewGestureCbSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onInProgressGestureCb(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onInProgressGestureCbSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onAbortedGestureCb(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onAbortedGestureCbSwigExplicitContextWrapper(long paramLong, ContextWrapper paramContextWrapper, int paramInt);

  public static final native void ContextWrapper_onCompletedGestureCb(long paramLong1, ContextWrapper paramContextWrapper, int paramInt, long paramLong2, Vec3f paramVec3f);

  public static final native void ContextWrapper_onCompletedGestureCbSwigExplicitContextWrapper(long paramLong1, ContextWrapper paramContextWrapper, int paramInt, long paramLong2, Vec3f paramVec3f);

  public static final native void ContextWrapper_director_connect(ContextWrapper paramContextWrapper, long paramLong, boolean paramBoolean1, boolean paramBoolean2);

  public static final native void ContextWrapper_change_ownership(ContextWrapper paramContextWrapper, long paramLong, boolean paramBoolean);

  public static boolean SwigDirector_ContextWrapper_enableDepth__SWIG_0(ContextWrapper paramContextWrapper)
  {
    return paramContextWrapper.enableDepth();
  }
  public static boolean SwigDirector_ContextWrapper_enableDepth__SWIG_1(ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, int paramInt3) {
    return paramContextWrapper.enableDepth(paramInt1, paramInt2, paramInt3);
  }
  public static boolean SwigDirector_ContextWrapper_enableRGB__SWIG_0(ContextWrapper paramContextWrapper) {
    return paramContextWrapper.enableRGB();
  }
  public static boolean SwigDirector_ContextWrapper_enableRGB__SWIG_1(ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, int paramInt3) {
    return paramContextWrapper.enableRGB(paramInt1, paramInt2, paramInt3);
  }
  public static boolean SwigDirector_ContextWrapper_enableIR__SWIG_0(ContextWrapper paramContextWrapper) {
    return paramContextWrapper.enableIR();
  }
  public static boolean SwigDirector_ContextWrapper_enableIR__SWIG_1(ContextWrapper paramContextWrapper, int paramInt1, int paramInt2, int paramInt3) {
    return paramContextWrapper.enableIR(paramInt1, paramInt2, paramInt3);
  }
  public static boolean SwigDirector_ContextWrapper_enableUser(ContextWrapper paramContextWrapper) {
    return paramContextWrapper.enableUser();
  }
  public static boolean SwigDirector_ContextWrapper_enableHand(ContextWrapper paramContextWrapper) {
    return paramContextWrapper.enableHand();
  }
  public static void SwigDirector_ContextWrapper_update(ContextWrapper paramContextWrapper) {
    paramContextWrapper.update();
  }
  public static boolean SwigDirector_ContextWrapper_enableRecorder(ContextWrapper paramContextWrapper, String paramString) {
    return paramContextWrapper.enableRecorder(paramString);
  }
  public static boolean SwigDirector_ContextWrapper_openFileRecording(ContextWrapper paramContextWrapper, String paramString) {
    return paramContextWrapper.openFileRecording(paramString);
  }
  public static void SwigDirector_ContextWrapper_onNewUserCb(ContextWrapper paramContextWrapper, int paramInt) {
    paramContextWrapper.onNewUserCb(paramInt);
  }
  public static void SwigDirector_ContextWrapper_onLostUserCb(ContextWrapper paramContextWrapper, int paramInt) {
    paramContextWrapper.onLostUserCb(paramInt);
  }
  public static void SwigDirector_ContextWrapper_onVisibleUserCb(ContextWrapper paramContextWrapper, int paramInt) {
    paramContextWrapper.onVisibleUserCb(paramInt);
  }
  public static void SwigDirector_ContextWrapper_onOutOfSceneUserCb(ContextWrapper paramContextWrapper, int paramInt) {
    paramContextWrapper.onOutOfSceneUserCb(paramInt);
  }
  public static void SwigDirector_ContextWrapper_onNewHandCb(ContextWrapper paramContextWrapper, int paramInt, long paramLong) {
    paramContextWrapper.onNewHandCb(paramInt, new Vec3f(paramLong, false));
  }
  public static void SwigDirector_ContextWrapper_onTrackedHandCb(ContextWrapper paramContextWrapper, int paramInt, long paramLong) {
    paramContextWrapper.onTrackedHandCb(paramInt, new Vec3f(paramLong, false));
  }
  public static void SwigDirector_ContextWrapper_onLostHandCb(ContextWrapper paramContextWrapper, int paramInt) {
    paramContextWrapper.onLostHandCb(paramInt);
  }
  public static void SwigDirector_ContextWrapper_onNewGestureCb(ContextWrapper paramContextWrapper, int paramInt) {
    paramContextWrapper.onNewGestureCb(paramInt);
  }
  public static void SwigDirector_ContextWrapper_onInProgressGestureCb(ContextWrapper paramContextWrapper, int paramInt) {
    paramContextWrapper.onInProgressGestureCb(paramInt);
  }
  public static void SwigDirector_ContextWrapper_onAbortedGestureCb(ContextWrapper paramContextWrapper, int paramInt) {
    paramContextWrapper.onAbortedGestureCb(paramInt);
  }
  public static void SwigDirector_ContextWrapper_onCompletedGestureCb(ContextWrapper paramContextWrapper, int paramInt, long paramLong) {
    paramContextWrapper.onCompletedGestureCb(paramInt, new Vec3f(paramLong, false));
  }
  private static final native void swig_module_init();

  static {
    swig_module_init();
  }
}