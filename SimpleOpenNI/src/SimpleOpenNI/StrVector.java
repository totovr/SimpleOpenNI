package SimpleOpenNI;

public class StrVector
{
  private static long swigCPtr;
  protected boolean swigCMemOwn;

  protected StrVector(long paramLong, boolean paramBoolean)
  {
    swigCMemOwn = paramBoolean;
    swigCPtr = paramLong;
  }

  protected static long getCPtr(StrVector paramStrVector) {
    return paramStrVector == null ? 0L : 0;//swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0L) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        SimpleOpenNIJNI.delete_StrVector(swigCPtr);
      }
      swigCPtr = 0L;
    }
  }

  public StrVector() {
    this(SimpleOpenNIJNI.new_StrVector__SWIG_0(), true);
  }

  public StrVector(long paramLong) {
    this(SimpleOpenNIJNI.new_StrVector__SWIG_1(paramLong), true);
  }

  public long size() {
    return SimpleOpenNIJNI.StrVector_size(swigCPtr, this);
  }

  public long capacity() {
    return SimpleOpenNIJNI.StrVector_capacity(swigCPtr, this);
  }

  public void reserve(long paramLong) {
    SimpleOpenNIJNI.StrVector_reserve(swigCPtr, this, paramLong);
  }

  public boolean isEmpty() {
    return SimpleOpenNIJNI.StrVector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    SimpleOpenNIJNI.StrVector_clear(swigCPtr, this);
  }

  public void add(String paramString) {
    SimpleOpenNIJNI.StrVector_add(swigCPtr, this, paramString);
  }

  public String get(int paramInt) {
    return SimpleOpenNIJNI.StrVector_get(swigCPtr, this, paramInt);
  }

  public void set(int paramInt, String paramString) {
    SimpleOpenNIJNI.StrVector_set(swigCPtr, this, paramInt, paramString);
  }
}