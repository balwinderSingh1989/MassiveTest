

package com.massive.deliveries.test.data.db;

import com.massive.deliveries.test.data.network.model.Deliveries;

import java.util.List;

import io.reactivex.Observable;


/**
 *  Creaated by Balwinder on 08/12/16.
 */

public interface DbHelper {

    Observable<List<Deliveries>> getAllDeliveries();
    boolean saveDeliveries(List<Deliveries> deliveries);
    boolean isDeliveriesEmpty();




}
