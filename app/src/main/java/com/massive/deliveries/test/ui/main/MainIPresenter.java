

package com.massive.deliveries.test.ui.main;


import com.massive.deliveries.test.di.PerActivity;
import com.massive.deliveries.test.ui.base.MvpPresenter;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

@PerActivity
public interface MainIPresenter<V extends MainIView> extends MvpPresenter<V> {


    void onDrawerOptionLogoutClick();

    void onViewInitialized();

    void onNavMenuCreated();


    void loadFromNetwork();
}
