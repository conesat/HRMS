package com.nncq.signin.StaticValues;

import com.arcsoft.facerecognition.AFR_FSDKFace;

import java.io.Serializable;
import java.util.Arrays;

public class MyAFR_FSDKFace extends AFR_FSDKFace  implements Serializable {
    public static final int FEATURE_SIZE = 22020;
    byte[] mFeatureData;

    public MyAFR_FSDKFace(AFR_FSDKFace self) {
        this.mFeatureData = (byte[])self.getFeatureData().clone();
    }

    public MyAFR_FSDKFace() {
        this.mFeatureData = new byte[22020];
    }

    public MyAFR_FSDKFace(byte[] data) {
        this.mFeatureData = data;
    }

    public MyAFR_FSDKFace(byte[] data, byte[] mFeatureData) {
        super(data);
        this.mFeatureData = mFeatureData;
    }

    public byte[] getFeatureData() {
        return this.mFeatureData;
    }

    public void setFeatureData(byte[] data) {
        this.mFeatureData = data;
    }

    public AFR_FSDKFace clone() {
        return new AFR_FSDKFace(this);
    }

    public static int getFeatureSize() {
        return FEATURE_SIZE;
    }

    public byte[] getmFeatureData() {
        return mFeatureData;
    }

    public void setmFeatureData(byte[] mFeatureData) {
        this.mFeatureData = mFeatureData;
    }

    @Override
    public String toString() {
        return "MyAFR_FSDKFace{" +
                "mFeatureData=" + Arrays.toString(mFeatureData) +
                '}';
    }

    public MyAFR_FSDKFace(AFR_FSDKFace self, byte[] mFeatureData) {
        super(self);
        this.mFeatureData = mFeatureData;
    }
}
