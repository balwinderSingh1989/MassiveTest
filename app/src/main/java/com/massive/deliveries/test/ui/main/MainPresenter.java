

package com.massive.deliveries.test.ui.main;

import com.massive.deliveries.test.data.DataManager;
import com.massive.deliveries.test.data.network.model.Deliveries;
import com.massive.deliveries.test.ui.base.BasePresenter;
import com.massive.deliveries.test.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Creaated by Balwinder on   26/08/17.
 */

public class MainPresenter<V extends MainIView> extends BasePresenter<V>
        implements MainIPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onDrawerOptionLogoutClick() {
        getMvpView().showLoading();
        getDataManager().setUserAsLoggedOut();
        getMvpView().hideLoading();
        getMvpView().openLoginActivity();
    }

    @Override
    public void onViewInitialized() {

        if (getDataManager().isDeliveriesEmpty()) {
            if (!getMvpView().isNetworkConnected()) {
                getMvpView().onError("Please check your internet Connection!");
                return;
            } else {
                loadFromNetwork();
            }
        } else {
            getMvpView().showLoading();
            getCompositeDisposable().add(getDataManager()
                    .getAllDeliveries()
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(this::handleResponse, this::handleError));
        }
    }


    private void handleResponse(List<Deliveries> deliveries) {

        getMvpView().refreshDeliveries(deliveries);
        getDataManager().saveDeliveries(deliveries);
        getMvpView().hideLoading();

    }

    private void handleError(Throwable error) {

        getMvpView().onError(error.getLocalizedMessage());
        getMvpView().hideLoading();

    }

    @Override
    public void onNavMenuCreated() {
        if (!isViewAttached()) {
            return;
        }
        getMvpView().updateAppVersion();

        final String currentUserName = getDataManager().getCurrentUserName();
        if (currentUserName != null && !currentUserName.isEmpty()) {
            getMvpView().updateUserName(currentUserName);
        }

        final String currentUserEmail = getDataManager().getCurrentUserEmail();
        if (currentUserEmail != null && !currentUserEmail.isEmpty()) {
            getMvpView().updateUserEmail(currentUserEmail);
        }


    }

    @Override
    public void loadFromNetwork() {


        if (!getMvpView().isNetworkConnected()) {
            getMvpView().onError("Please check your internet Connection!");
            return;
        } else {
            getMvpView().showLoading();
            getCompositeDisposable().add(getDataManager()
                    .getDelieverables()
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(this::handleResponse, this::handleError));

        }

    }

}
