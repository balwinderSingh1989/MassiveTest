

package com.massive.deliveries.test.data.db;

import com.massive.deliveries.test.data.network.model.Deliveries;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


/**
 *  Creaated by Balwinder on 08/12/16.
 */

@Singleton
public class AppDbHelper implements DbHelper {


    public  DeliverableDAO mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        this.mDaoSession = new DeliverableDAO(dbOpenHelper);
    }


    @Override
    public Observable<List<Deliveries>> getAllDeliveries() {
        return Observable.fromCallable(new Callable<List<Deliveries>>() {
            @Override
            public List<Deliveries> call() throws Exception {
                return mDaoSession.getData();
            }
        });
    }

    @Override
    public boolean isDeliveriesEmpty() {
       return mDaoSession.getData().isEmpty();
    }

    @Override
    public boolean saveDeliveries(final List<Deliveries> deliveries) {
        mDaoSession.insertData(deliveries);
        return true;
    }


}
