

package com.massive.deliveries.test.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.massive.deliveries.test.BuildConfig;
import com.massive.deliveries.test.R;
import com.massive.deliveries.test.data.AppDataManager;
import com.massive.deliveries.test.data.DataManager;
import com.massive.deliveries.test.data.db.AppDbHelper;
import com.massive.deliveries.test.data.db.DbHelper;
import com.massive.deliveries.test.data.network.ApiHelper;
import com.massive.deliveries.test.data.prefs.AppPreferencesHelper;
import com.massive.deliveries.test.data.prefs.PreferencesHelper;
import com.massive.deliveries.test.di.ApiInfo;
import com.massive.deliveries.test.di.ApplicationContext;
import com.massive.deliveries.test.di.DatabaseInfo;
import com.massive.deliveries.test.di.PreferenceInfo;
import com.massive.deliveries.test.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 *  Creaated by Balwinder on   26/08/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return "";
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }



    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }



    @Provides
    @Singleton
    ApiHelper provideApiHelper()
    {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return    new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(ApiHelper.class);


    }

}
