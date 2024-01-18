package com.example.googlemapoverlayjava;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapoverlayjava.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng mudLatLng = new LatLng(28.762139, 77.505818);
        MarkerOptions markerOptions = new MarkerOptions().position(mudLatLng).title("Muradagar");
        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(mudLatLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mudLatLng, 16f));

        //Circle
        mMap.addCircle(new CircleOptions().center(mudLatLng).radius(1000).fillColor(Color.GREEN).strokeColor(Color.DKGRAY));

        //Polygon
        mMap.addPolygon(new PolygonOptions().add(new LatLng(28.762139, 77.505818),
                new LatLng(28.762139, 79.505818),
                new LatLng(30.762139, 79.505818),
                new LatLng(30.762139, 77.505818),
                new LatLng(28.762139, 77.505818)).fillColor(Color.YELLOW).strokeColor(Color.BLUE));

        //GroundOverlay

        mMap.addGroundOverlay(new GroundOverlayOptions()
                .position(mudLatLng, 1000f, 1000f)
                .image(BitmapDescriptorFactory.fromResource(R.drawable.getyoteam))
                .clickable(true));   }
}