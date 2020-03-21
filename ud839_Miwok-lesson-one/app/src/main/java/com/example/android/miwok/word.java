package com.example.android.miwok;

/**
 * Created by PC on 27-09-2017.
 */

public class word {
    private String defaultvalue, miwokvalue;
    private int imageResourceId=NO_IMAGE_PROVIDED;
    private int audioResourceId;
    private static final int NO_IMAGE_PROVIDED=0;

    public word(String miwokvalue, String defaultvalue,int audioResourceId) {
        this.defaultvalue = defaultvalue;
        this.miwokvalue = miwokvalue;
        this.audioResourceId=audioResourceId;
    }
    public word(String miwokvalue,String defaultvalue,int imageResourceId,int audioResourceId)
    {
        this.defaultvalue=defaultvalue;
        this.miwokvalue=miwokvalue;
        this.imageResourceId=imageResourceId;
        this.audioResourceId=audioResourceId;
    }
    public int getAudioResourceId(){ return audioResourceId; }
    public String getDefaultvalue() {
        return defaultvalue;
    }
    public String getMiwokvalue() {
        return miwokvalue;
    }
    public int getImageResourceId()
    {
        return imageResourceId;
    }
    public boolean hasImage()
    {
        return imageResourceId!=NO_IMAGE_PROVIDED;
    }

    /*
    alt+insert
    then I can print directly the word object
    Log.v("NumbersActivity", "Current word: " + word);
    OR
    Log.v("NumbersActivity", "Current word: " + word.toString());
    @Override
    public String toString() {
        return "word{" +
                "defaultvalue='" + defaultvalue + '\'' +
                ", miwokvalue='" + miwokvalue + '\'' +
                ", imageResourceId=" + imageResourceId +
                ", audioResourceId=" + audioResourceId +
                '}';
    }*/
}
