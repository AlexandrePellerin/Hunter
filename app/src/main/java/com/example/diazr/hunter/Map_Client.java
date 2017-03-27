package com.example.diazr.hunter;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map_Client extends FragmentActivity implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {


    private GoogleMap mMap;
    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleClient;
    private Location mLastLocation;
    private Location currentLocation;
    private Marker marker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map__client);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        if (mGoogleClient == null) {
            mGoogleClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(Map_Client.this)
                    .addApi(LocationServices.API)
                    .build();
        }


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng loca = new LatLng(50.613505, 3.136766);
       // mMap.addMarker(new MarkerOptions().position(loca).title("Marker in IUT A"));

        if(mLastLocation != null) {
            LatLng lastLocation = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
            marker = mMap.addMarker(new MarkerOptions().position(lastLocation).title("Marker in last know location"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(lastLocation));
        }
    }



    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(5000);
        mLocationRequest.setFastestInterval(2000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        try {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleClient);
            if (mLastLocation == null) {
                Log.d("test1","LastLocation null");
            }
        } catch (SecurityException e) {
            Log.d("test","SecurityException in onConnected"+e.toString());
        }

        createLocationRequest();
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);

        PendingResult<LocationSettingsResult> result =
                LocationServices.SettingsApi.checkLocationSettings(mGoogleClient,
                        builder.build());



             startLocationUpdates();






    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    protected void onStart() {
        mGoogleClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleClient.disconnect();
        super.onStop();
    }

    protected void startLocationUpdates() {
        try {
            LocationServices.FusedLocationApi.requestLocationUpdates(
                    mGoogleClient, mLocationRequest, Map_Client.this);
        } catch(SecurityException e) {
            Log.d("test2","SecurityException in startLocationUpdates"+e.getMessage());
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        currentLocation = location;

        LatLng cLocation = new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(cLocation).title("Marker in last know location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cLocation));

    }

    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }

    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleClient, this);
    }
}
