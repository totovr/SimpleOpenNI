package SimpleOpenNI;

public class Vec3f
{
  private static long swigCPtr;
  protected boolean swigCMemOwn;

  protected Vec3f(long paramLong, boolean paramBoolean)
  {
    swigCMemOwn = paramBoolean;
    swigCPtr = paramLong;
  }

  protected static long getCPtr(Vec3f paramVec3f) {
    return paramVec3f == null ? 0L : 0;//swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0L) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        SimpleOpenNIJNI.delete_Vec3f(swigCPtr);
      }
      swigCPtr = 0L;
    }
  }

  public Vec3f(float paramFloat1, float paramFloat2, float paramFloat3) {
    this(SimpleOpenNIJNI.new_Vec3f__SWIG_0(paramFloat1, paramFloat2, paramFloat3), true);
  }

  public Vec3f(Vec3f paramVec3f) {
    this(SimpleOpenNIJNI.new_Vec3f__SWIG_1(getCPtr(paramVec3f), paramVec3f), true);
  }

  public float x() {
    return SimpleOpenNIJNI.Vec3f_x(swigCPtr, this);
  }

  public float y() {
    return SimpleOpenNIJNI.Vec3f_y(swigCPtr, this);
  }

  public float z() {
    return SimpleOpenNIJNI.Vec3f_z(swigCPtr, this);
  }
}