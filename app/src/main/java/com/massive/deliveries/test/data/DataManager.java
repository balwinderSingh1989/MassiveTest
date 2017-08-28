

package com.massive.deliveries.test.data;


import com.massive.deliveries.test.data.db.DbHelper;
import com.massive.deliveries.test.data.network.ApiHelper;
import com.massive.deliveries.test.data.prefs.PreferencesHelper;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {


    void setUserAsLoggedOut();

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_LOGGD_IN(1);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }

}
