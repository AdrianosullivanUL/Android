package com.example.a501958452.jerseylab1;

import static android.provider.Settings.System.getString;

public class Jersey {
    private String mPlayerName;
    private int mJerseyNumber;
    private boolean mDefaultColour;

    public Jersey()
    {
        mPlayerName = "ANDROID";
        mJerseyNumber = 17;
        mDefaultColour = true;


    }
    public Jersey (String playerName, int jerseyNumber, boolean defaultColour)
    {
        mPlayerName = playerName;
        mJerseyNumber = jerseyNumber;
        mDefaultColour = defaultColour;

    }
    public String getPlayerName()
    {
        return mPlayerName;
    }
    public int getJerseyNumber()
    {
        return mJerseyNumber;
    }

    public boolean getDefaultColour() {
        return mDefaultColour;
    }
    public void setPlayerName(String playerName)
    {
        mPlayerName = playerName;
    }
    public void setJerseyNumber(int jerseyNumber)
    {
        mJerseyNumber = jerseyNumber;
    }
    public void setDefaultColour(boolean defaultColour)
    {
        mDefaultColour = defaultColour;
    }
}
