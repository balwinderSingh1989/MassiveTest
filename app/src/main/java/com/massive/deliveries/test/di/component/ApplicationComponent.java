

package com.massive.deliveries.test.di.component;

import android.app.Application;
import android.content.Context;

import com.massive.deliveries.test.MyApp;
import com.massive.deliveries.test.data.DataManager;
import com.massive.deliveries.test.di.ApplicationContext;
import com.massive.deliveries.test.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MyApp app);


    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}