package driver.lsit.texi.push;
//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.iid.FirebaseInstanceIdService;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import driver.lsit.texi.model.User;


/**
 * Created by Vikram on 10/21/17.
 */


public class FCMInitializationService extends FirebaseInstanceIdService {
    private static final String TAG = "FCMToken";
    User preference;

    public FCMInitializationService(){}

    @Override
    public void onTokenRefresh() {
        String fcmToken = FirebaseInstanceId.getInstance().getToken();
        preference = new User(getApplicationContext());
        Log.d(TAG, "FCM DeviceToken:" + fcmToken);

        //Save or send FCM registration token

        if(fcmToken!= null)
            preference.setUserDeviceToken(fcmToken);
    }
}

