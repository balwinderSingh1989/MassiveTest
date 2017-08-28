

package com.massive.deliveries.test.ui.login;


import com.massive.deliveries.test.di.PerActivity;
import com.massive.deliveries.test.ui.base.MvpPresenter;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

@PerActivity
public interface LoginIPresenter<V extends LoginIView> extends MvpPresenter<V> {

    void onLoginClick(String email, String password);


}
