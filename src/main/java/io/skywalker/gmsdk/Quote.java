/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.skywalker.gmsdk;

public class Quote {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Quote(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Quote obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gmsdkJNI.delete_Quote(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBid_price(float value) {
    gmsdkJNI.Quote_bid_price_set(swigCPtr, this, value);
  }

  public float getBid_price() {
    return gmsdkJNI.Quote_bid_price_get(swigCPtr, this);
  }

  public void setBid_volume(long value) {
    gmsdkJNI.Quote_bid_volume_set(swigCPtr, this, value);
  }

  public long getBid_volume() {
    return gmsdkJNI.Quote_bid_volume_get(swigCPtr, this);
  }

  public void setAsk_price(float value) {
    gmsdkJNI.Quote_ask_price_set(swigCPtr, this, value);
  }

  public float getAsk_price() {
    return gmsdkJNI.Quote_ask_price_get(swigCPtr, this);
  }

  public void setAsk_volume(long value) {
    gmsdkJNI.Quote_ask_volume_set(swigCPtr, this, value);
  }

  public long getAsk_volume() {
    return gmsdkJNI.Quote_ask_volume_get(swigCPtr, this);
  }

  public Quote() {
    this(gmsdkJNI.new_Quote(), true);
  }

}
