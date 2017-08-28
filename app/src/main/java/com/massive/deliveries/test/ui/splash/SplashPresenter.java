

package com.massive.deliveries.test.ui.splash;

import com.massive.deliveries.test.data.DataManager;
import com.massive.deliveries.test.ui.base.BasePresenter;
import com.massive.deliveries.test.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

public class SplashPresenter<V extends SplashIView> extends BasePresenter<V>
        implements SplashIPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        decideNextActivity();

    }

    private void decideNextActivity() {
        if (getDataManager().getCurrentUserLoggedInMode()
                == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getMvpView().openLoginActivity();
        } else {
            getMvpView().openMainActivity();
        }
    }
}
