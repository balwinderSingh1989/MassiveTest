

package com.massive.deliveries.test.ui.base;

/**
 *  Creaated by Balwinder on   26/08/17.
 */


/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the IView type that wants to be attached with.
 */
public interface MvpPresenter<V extends IView> {

    void onAttach(V mvpView);
    void onDetach();
}
