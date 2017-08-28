

package com.massive.deliveries.test.ui.delivery;

import com.massive.deliveries.test.data.DataManager;
import com.massive.deliveries.test.ui.base.BasePresenter;
import com.massive.deliveries.test.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

public class DeliveryPresenter<V extends DeliveryIView> extends BasePresenter<V>
        implements DeliveryIPresenter<V> {

    @Inject
    public DeliveryPresenter(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
