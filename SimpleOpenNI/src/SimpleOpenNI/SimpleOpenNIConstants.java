package SimpleOpenNI;

public abstract interface SimpleOpenNIConstants
{
  public static final int SKEL_HEAD = SimpleOpenNIJNI.SKEL_HEAD_get();
  public static final int SKEL_NECK = SimpleOpenNIJNI.SKEL_NECK_get();
  public static final int SKEL_TORSO = SimpleOpenNIJNI.SKEL_TORSO_get();
  public static final int SKEL_LEFT_SHOULDER = SimpleOpenNIJNI.SKEL_LEFT_SHOULDER_get();
  public static final int SKEL_LEFT_ELBOW = SimpleOpenNIJNI.SKEL_LEFT_ELBOW_get();
  public static final int SKEL_LEFT_HAND = SimpleOpenNIJNI.SKEL_LEFT_HAND_get();
  public static final int SKEL_LEFT_FINGERTIP = SimpleOpenNIJNI.SKEL_LEFT_FINGERTIP_get();
  public static final int SKEL_RIGHT_SHOULDER = SimpleOpenNIJNI.SKEL_RIGHT_SHOULDER_get();
  public static final int SKEL_RIGHT_ELBOW = SimpleOpenNIJNI.SKEL_RIGHT_ELBOW_get();
  public static final int SKEL_RIGHT_HAND = SimpleOpenNIJNI.SKEL_RIGHT_HAND_get();
  public static final int SKEL_RIGHT_FINGERTIP = SimpleOpenNIJNI.SKEL_RIGHT_FINGERTIP_get();
  public static final int SKEL_LEFT_HIP = SimpleOpenNIJNI.SKEL_LEFT_HIP_get();
  public static final int SKEL_LEFT_KNEE = SimpleOpenNIJNI.SKEL_LEFT_KNEE_get();
  public static final int SKEL_LEFT_FOOT = SimpleOpenNIJNI.SKEL_LEFT_FOOT_get();
  public static final int SKEL_RIGHT_HIP = SimpleOpenNIJNI.SKEL_RIGHT_HIP_get();
  public static final int SKEL_RIGHT_KNEE = SimpleOpenNIJNI.SKEL_RIGHT_KNEE_get();
  public static final int SKEL_RIGHT_FOOT = SimpleOpenNIJNI.SKEL_RIGHT_FOOT_get();
  public static final int GESTURE_WAVE = SimpleOpenNIJNI.GESTURE_WAVE_get();
  public static final int GESTURE_CLICK = SimpleOpenNIJNI.GESTURE_CLICK_get();
  public static final int GESTURE_HAND_RAISE = SimpleOpenNIJNI.GESTURE_HAND_RAISE_get();
  public static final int NODE_NONE = SimpleOpenNIJNI.NODE_NONE_get();
  public static final int NODE_DEPTH = SimpleOpenNIJNI.NODE_DEPTH_get();
  public static final int NODE_IMAGE = SimpleOpenNIJNI.NODE_IMAGE_get();
  public static final int NODE_IR = SimpleOpenNIJNI.NODE_IR_get();
  public static final int NODE_SCENE = SimpleOpenNIJNI.NODE_SCENE_get();
  public static final int NODE_USER = SimpleOpenNIJNI.NODE_USER_get();
  public static final int NODE_HANDS = SimpleOpenNIJNI.NODE_HANDS_get();
  public static final int NODE_GESTURE = SimpleOpenNIJNI.NODE_GESTURE_get();
  public static final int NODE_RECORDER = SimpleOpenNIJNI.NODE_RECORDER_get();
  public static final int NODE_PLAYER = SimpleOpenNIJNI.NODE_PLAYER_get();
  public static final int IMG_MODE_DEFAULT = SimpleOpenNIJNI.IMG_MODE_DEFAULT_get();
  public static final int IMG_MODE_RGB_FADE = SimpleOpenNIJNI.IMG_MODE_RGB_FADE_get();
  public static final int RUN_MODE_DEFAULT = SimpleOpenNIJNI.RUN_MODE_DEFAULT_get();
  public static final int RUN_MODE_SINGLE_THREADED = SimpleOpenNIJNI.RUN_MODE_SINGLE_THREADED_get();
  public static final int RUN_MODE_MULTI_THREADED = SimpleOpenNIJNI.RUN_MODE_MULTI_THREADED_get();
}