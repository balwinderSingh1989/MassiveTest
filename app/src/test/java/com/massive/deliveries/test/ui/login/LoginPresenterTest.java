

package com.massive.deliveries.test.ui.login;

import com.massive.deliveries.test.data.DataManager;
import com.massive.deliveries.test.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by balwinder on 02/02/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginIView mMockLoginMvpView;
    @Mock
    DataManager mMockDataManager;

    private LoginPresenter<LoginIView> mLoginPresenter;
    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mLoginPresenter = new LoginPresenter<>(
            mMockDataManager,
            testSchedulerProvider,
            compositeDisposable);
        mLoginPresenter.onAttach(mMockLoginMvpView);
    }

    @Test
    public void testServerLoginSuccess() {

        String email = "dummy@gmail.com";
        String password = "password";



        mLoginPresenter.onLoginClick(email, password);

        mTestScheduler.triggerActions();

        verify(mMockLoginMvpView).showLoading();
        verify(mMockLoginMvpView).hideLoading();
        verify(mMockLoginMvpView).openMainActivity();
    }


    @After
    public void tearDown() throws Exception {
        mLoginPresenter.onDetach();
    }

}