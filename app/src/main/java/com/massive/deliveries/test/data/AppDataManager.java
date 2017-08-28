

package com.massive.deliveries.test.data;


import android.content.Context;

import com.massive.deliveries.test.data.db.DbHelper;
import com.massive.deliveries.test.data.network.ApiHelper;
import com.massive.deliveries.test.data.network.model.Deliveries;
import com.massive.deliveries.test.data.prefs.PreferencesHelper;
import com.massive.deliveries.test.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
     ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper
                          ) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;

    }

    @Override
    public Observable<List<Deliveries>> getDelieverables() {
         return   mApiHelper.getDelieverables();

    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }


    @Override
    public boolean isDeliveriesEmpty() {
        return mDbHelper.isDeliveriesEmpty();
    }

    @Override
    public void setUserAsLoggedOut() {
        mPreferencesHelper.setCurrentUserLoggedInMode(DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT);

    }


    @Override
    public Observable<List<Deliveries>> getAllDeliveries() {
        return mDbHelper.getAllDeliveries();
    }

    @Override
    public boolean saveDeliveries(List<Deliveries> deliveries) {
        return mDbHelper.saveDeliveries(deliveries);
    }


    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);

    }

}
