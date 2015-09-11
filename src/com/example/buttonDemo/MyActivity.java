package com.example.buttonDemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MyActivity extends Activity implements OnMapReadyCallback,LocationListener {

    private LocationManager locationManger;
    private GoogleMap gmap;

    @Override
    public void onMapReady(GoogleMap map) {

        map.setMyLocationEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Utils.wakeUp(this);
        Log.wtf("mediabuttonintentrec", "MyActivity.onResume()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        setContentView(R.layout.main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        gmap =  mapFragment.getMap();


        locationManger = (LocationManager) getSystemService(LOCATION_SERVICE);
        try
        {
            locationManger.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 2000, 1, this);
            locationManger.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 1, this);
        } catch(Exception e) {
            Log.e("tag", "cannot get provider!", e);
        }

        Log.wtf("mediabuttonintentrec", "MyActivity.onCreate()");


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getHelp();
    }

    public void getHelp() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wykop.pl"));
        startActivity(browserIntent);
        //Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+48667712393"));
        //startActivity(intent);

    }


    @Override
    public void onLocationChanged(Location location) {
        LatLng currentLocation = new LatLng(location.getLatitude(),location.getLongitude());
        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 13));

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
