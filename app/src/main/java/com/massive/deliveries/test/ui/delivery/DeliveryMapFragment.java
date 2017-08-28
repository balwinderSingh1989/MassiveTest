

package com.massive.deliveries.test.ui.delivery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.massive.deliveries.test.di.component.ActivityComponent;
import com.massive.deliveries.test.ui.base.BaseFragment;
import com.massive.deliveries.test.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 *  Creaated by Balwinder on   26/08/17.
 */

public class DeliveryMapFragment extends BaseFragment implements DeliveryIView, OnMapReadyCallback {

    public static final String TAG = "DeliveryMapFragment";

    @Inject
    DeliveryIPresenter<DeliveryIView> mPresenter;

    @BindView(R.id.mapview)
    MapView mapView;

    GoogleMap map;
    double lat, lng;
    String address;


    public static DeliveryMapFragment newInstance(double lat, double lng,String address) {
        Bundle args = new Bundle();
        DeliveryMapFragment fragment = new DeliveryMapFragment();
        args.putDouble("lat", lat);
        args.putDouble("lng", lng);
        args.putString("add", address);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args != null){
             lat = args.getDouble("lat");
              lng = args.getDouble("lng");
              address =args.getString("add");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        mapView.onCreate(savedInstanceState);
        return view;
    }


    @OnClick(R.id.nav_back_btn)
    void onNavBackClick() {
        getBaseActivity().onFragmentDetached(TAG);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    protected void setUp(View view) {
        // Gets to GoogleMap from the MapView and does initialization stuff
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setTrafficEnabled(true);
        map.setIndoorEnabled(true);
        map.setBuildingsEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true);
        // Updates the location and zoom of the MapView
      /*  CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 10);
        map.animateCamera(cameraUpdate);*/
        LatLng coordinates = new LatLng(lat, lng);
        map.addMarker(new MarkerOptions().position(coordinates).title(address));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
        mapView.onResume();

    }
}

