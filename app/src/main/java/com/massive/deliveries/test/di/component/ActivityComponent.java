

package com.massive.deliveries.test.di.component;

import com.massive.deliveries.test.di.PerActivity;
import com.massive.deliveries.test.di.module.ActivityModule;
import com.massive.deliveries.test.ui.delivery.DeliveryMapFragment;
import com.massive.deliveries.test.ui.login.LoginActivity;
import com.massive.deliveries.test.ui.main.MainActivity;
import com.massive.deliveries.test.ui.splash.SplashActivity;

import dagger.Component;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);


    void inject(DeliveryMapFragment fragment);



}
