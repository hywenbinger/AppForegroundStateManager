package com.example.zz;

import com.example.zz.AppForegroundStateManager.AppForegroundState;
import com.example.zz.AppForegroundStateManager.OnAppForegroundStateChangeListener;

import android.app.Application;

public class MyApplication extends Application implements OnAppForegroundStateChangeListener{
	
	public final String TAG = MyApplication.class.getSimpleName();
	 
    public enum LaunchMechanism {
        DIRECT,
        NOTIFICATION,
        URL;
    }
 
    private LaunchMechanism mLaunchMechanism = LaunchMechanism.DIRECT;
 
    public void setLaunchMechanism(LaunchMechanism launchMechanism) {
        mLaunchMechanism = launchMechanism;
    }
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		AppForegroundStateManager.getInstance().addListener(this);
	}

	@Override
	public void onAppForegroundStateChange(AppForegroundState newState) {
		// TODO Auto-generated method stub
		System.out.println(newState);
		if (AppForegroundStateManager.AppForegroundState.IN_FOREGROUND == newState) {
            // App just entered the foreground. Do something here!
			System.out.println("App just entered the foreground. Do something here!");
			System.out.println("App Just Entered the Foreground with launch mechanism of: " + mLaunchMechanism);
        } else {
            // App just entered the background. Do something here!
        	System.out.println("App just entered the background. Do something here!");
        	mLaunchMechanism = LaunchMechanism.DIRECT;
        }
	}
	
}
