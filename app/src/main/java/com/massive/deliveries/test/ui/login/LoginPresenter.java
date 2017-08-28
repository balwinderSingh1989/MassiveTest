

package com.massive.deliveries.test.ui.login;

import com.massive.deliveries.test.R;
import com.massive.deliveries.test.data.DataManager;
import com.massive.deliveries.test.ui.base.BasePresenter;
import com.massive.deliveries.test.utils.CommonUtils;
import com.massive.deliveries.test.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

public class LoginPresenter<V extends LoginIView> extends BasePresenter<V>
        implements LoginIPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onLoginClick(String email, String password) {
        //validate email and password
        if (email == null || email.isEmpty()) {
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }

       getDataManager().setCurrentUserLoggedInMode(DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGD_IN);
       getMvpView().openMainActivity();

    }

}
