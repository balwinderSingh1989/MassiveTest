

package com.massive.deliveries.test.data.prefs;

import com.massive.deliveries.test.data.DataManager;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

public interface PreferencesHelper {


    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

}
