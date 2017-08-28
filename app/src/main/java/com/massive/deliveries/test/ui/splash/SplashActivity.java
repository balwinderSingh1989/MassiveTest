

package com.massive.deliveries.test.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.massive.deliveries.test.ui.base.BaseActivity;
import com.massive.deliveries.test.ui.login.LoginActivity;
import com.massive.deliveries.test.ui.main.MainActivity;
import com.massive.deliveries.test.R;

import javax.inject.Inject;

import butterknife.ButterKnife;


/**
 *  Creaated by Balwinder on   26/08/17.
 */

public class SplashActivity extends BaseActivity implements SplashIView {

    @Inject
    SplashIPresenter<SplashIView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SplashActivity.this);
    }

    /**
     * Making the screen wait so that the  branding can be shown
     */
    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }



    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}
