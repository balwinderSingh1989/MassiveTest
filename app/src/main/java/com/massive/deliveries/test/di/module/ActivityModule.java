

package com.massive.deliveries.test.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.massive.deliveries.test.BuildConfig;
import com.massive.deliveries.test.data.network.ApiHelper;
import com.massive.deliveries.test.data.network.model.Deliveries;
import com.massive.deliveries.test.di.ActivityContext;
import com.massive.deliveries.test.di.PerActivity;
import com.massive.deliveries.test.ui.delivery.DeliveryIPresenter;
import com.massive.deliveries.test.ui.delivery.DeliveryIView;
import com.massive.deliveries.test.ui.delivery.DeliveryPresenter;
import com.massive.deliveries.test.ui.login.LoginIPresenter;
import com.massive.deliveries.test.ui.login.LoginIView;
import com.massive.deliveries.test.ui.login.LoginPresenter;
import com.massive.deliveries.test.ui.main.MainAdapter;
import com.massive.deliveries.test.ui.main.MainIPresenter;
import com.massive.deliveries.test.ui.main.MainIView;
import com.massive.deliveries.test.ui.main.MainPresenter;
import com.massive.deliveries.test.ui.splash.SplashIPresenter;
import com.massive.deliveries.test.ui.splash.SplashIView;
import com.massive.deliveries.test.ui.splash.SplashPresenter;
import com.massive.deliveries.test.utils.rx.AppSchedulerProvider;
import com.massive.deliveries.test.utils.rx.SchedulerProvider;


import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashIPresenter<SplashIView> provideSplashPresenter(
            SplashPresenter<SplashIView> presenter) {
        return presenter;
    }

    @Provides
    DeliveryIPresenter<DeliveryIView> provideAboutPresenter(
            DeliveryPresenter<DeliveryIView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginIPresenter<LoginIView> provideLoginPresenter(
            LoginPresenter<LoginIView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainIPresenter<MainIView> provideMainPresenter(
            MainPresenter<MainIView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    MainAdapter provideMainAdapter() {
        return new MainAdapter(new ArrayList<Deliveries>() , mActivity);
    }



    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper()
    {
        return    new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiHelper.class);
    }

}
