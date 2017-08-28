

package com.massive.deliveries.test.data.network;


import com.massive.deliveries.test.BuildConfig;

/**
 * Created by balwinder on 01/02/17.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_GET_DELIVERY = BuildConfig.BASE_URL
            + "/deliveries";


    private ApiEndPoint() {
        // This class is not publicly instantiable

    }

}
