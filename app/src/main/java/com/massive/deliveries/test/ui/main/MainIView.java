

package com.massive.deliveries.test.ui.main;

import com.massive.deliveries.test.data.network.model.Deliveries;
import com.massive.deliveries.test.ui.base.IView;

import java.util.List;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

public interface MainIView extends IView {

    void openLoginActivity();

    void refreshDeliveries(List<Deliveries> deliveries);

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateAppVersion();

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();

    void ShowNoDataView();
}
