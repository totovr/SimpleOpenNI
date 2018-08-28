package SimpleOpenNI;

public class IntVector
{
  private static long swigCPtr;
  protected boolean swigCMemOwn;

  protected IntVector(long paramLong, boolean paramBoolean)
  {
    swigCMemOwn = paramBoolean;
    swigCPtr = paramLong;
  }

  protected static long getCPtr(IntVector paramIntVector) {
    return paramIntVector == null ? 0L : swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0L) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        SimpleOpenNIJNI.delete_IntVector(swigCPtr);
      }
      swigCPtr = 0L;
    }
  }

  public IntVector() {
    this(SimpleOpenNIJNI.new_IntVector__SWIG_0(), true);
  }

  public IntVector(long paramLong) {
    this(SimpleOpenNIJNI.new_IntVector__SWIG_1(paramLong), true);
  }

  public long size() {
    return SimpleOpenNIJNI.IntVector_size(swigCPtr, this);
  }

  public long capacity() {
    return SimpleOpenNIJNI.IntVector_capacity(swigCPtr, this);
  }

  public void reserve(long paramLong) {
    SimpleOpenNIJNI.IntVector_reserve(swigCPtr, this, paramLong);
  }

  public boolean isEmpty() {
    return SimpleOpenNIJNI.IntVector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    SimpleOpenNIJNI.IntVector_clear(swigCPtr, this);
  }

  public void add(int paramInt) {
    SimpleOpenNIJNI.IntVector_add(swigCPtr, this, paramInt);
  }

  public int get(int paramInt) {
    return SimpleOpenNIJNI.IntVector_get(swigCPtr, this, paramInt);
  }

  public void set(int paramInt1, int paramInt2) {
    SimpleOpenNIJNI.IntVector_set(swigCPtr, this, paramInt1, paramInt2);
  }
}