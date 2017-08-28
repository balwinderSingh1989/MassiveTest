

package com.massive.deliveries.test.ui.base;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

import android.support.annotation.StringRes;

/**
 * Base interface that any class that wants to act as a View
 *  must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface IView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();



}
