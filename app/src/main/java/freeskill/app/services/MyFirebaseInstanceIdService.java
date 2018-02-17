package freeskill.app.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import freeskill.app.FreeSkillSharedPreferences;
import freeskill.app.FreeskillApplication;
import freeskill.app.model.CurrentApp;
import freeskill.app.model.ProfileEditor;
import freeskill.app.utils.Constants;

/**
 * Created by Olivier on 26/01/2018.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    private static final String TAG = "MyAndroidFCMIIDService";

    @Override
    public void onTokenRefresh() {

        //Get hold of the registration token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //Log the token
        Log.d(TAG, "Refreshed token: " + refreshedToken);
    }
}
