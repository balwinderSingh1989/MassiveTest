

package com.massive.deliveries.test.di.component;

import com.massive.deliveries.test.di.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by balwinder on 03/02/17.
 */
@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {
}
