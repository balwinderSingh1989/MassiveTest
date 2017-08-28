

package com.massive.deliveries.test.di.module;

import android.app.Service;

import dagger.Module;

/**
 *  Creaated by Balwinder on 01/02/17.
 */

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }
}
