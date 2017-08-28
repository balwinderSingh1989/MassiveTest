

package com.massive.deliveries.test.data.network;
import com.massive.deliveries.test.data.network.model.Deliveries;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

public interface ApiHelper {



    @GET("deliveries")
    Observable<List<Deliveries>> getDelieverables();




}
