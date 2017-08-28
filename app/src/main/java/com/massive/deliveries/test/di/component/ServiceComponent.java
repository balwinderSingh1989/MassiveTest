

package com.massive.deliveries.test.di.component;

import com.massive.deliveries.test.di.PerService;
import com.massive.deliveries.test.di.module.ServiceModule;

import dagger.Component;

/**
 *  Creaated by Balwinder on 01/02/17.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {


}
