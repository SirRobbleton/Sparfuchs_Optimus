package de.sparfuchs_optimus.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import de.sparfuchs_optimus.R;

public class MapFragment extends Fragment implements OnMapReadyCallback
{
    private MapView mapView;
    private GoogleMap googleMap;

    public static MapFragment newInstance() {
        MapFragment mapFragment = new MapFragment();
        return mapFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        mapView = (MapView) rootView.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        mapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                googleMap.setIndoorEnabled(false);
                googleMap.setBuildingsEnabled(true);

                // Set boundary for Karlsruhe
                LatLngBounds karlsruhe = new LatLngBounds(
                        new LatLng(48.996694, 8.378687), new LatLng(49.024639, 8.423896));

                // Add a marker in Karlsruhe and move the camera
                LatLng euro = new LatLng(49.009927, 8.395140);
                LatLng shotz = new LatLng(49.008477, 8.396108);
                LatLng badbrau = new LatLng(49.011877, 8.394246);
                LatLng aposto = new LatLng(49.008791, 8.396359);
                // googleMap.addMarker(new MarkerOptions().position(myLocation).title("Your Location!"));
                googleMap.addMarker(new MarkerOptions().position(shotz).title("Shotz"));
                googleMap.addMarker(new MarkerOptions().position(badbrau).title("Badisches Brauhaus"));
                googleMap.addMarker(new MarkerOptions().position(aposto).title("Aposto"));
                //googleMap.setLatLngBoundsForCameraTarget(karlsruhe);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(euro, 16));
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(googleMap.getCameraPosition()).tilt(50).build()));
            }
        });
        return rootView;
    }



    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);//when you already implement OnMapReadyCallback in your fragment
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        this.googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        this.googleMap.setIndoorEnabled(false);
        this.googleMap.setBuildingsEnabled(true);

        // Set boundary for Karlsruhe
        LatLngBounds karlsruhe = new LatLngBounds(
                new LatLng(48.996694, 8.378687), new LatLng(49.024639, 8.423896));

        // Add a marker in Karlsruhe and move the camera
        LatLng euro = new LatLng(49.009927, 8.395140);
        LatLng shotz = new LatLng(49.008477, 8.396108);
        LatLng badbrau = new LatLng(49.011877, 8.394246);
        LatLng pinte = new LatLng(49.007908, 8.389647);
        LatLng strawberry = new LatLng(49.004179, 8.409696);
        LatLng flynn = new LatLng(49.004767, 8.390939);
        LatLng scruffy = new LatLng(49.011642, 8.395445);
        LatLng aposto = new LatLng(49.008791, 8.396359);
        LatLng koffer = new LatLng(49.008314, 8.391809);
        // googleMap.addMarker(new MarkerOptions().position(myLocation).title("Your Location!"));
        this.googleMap.addMarker(new MarkerOptions().position(shotz).title("Shotz"));
        this.googleMap.addMarker(new MarkerOptions().position(badbrau).title("Badisches Brauhaus"));
        this.googleMap.addMarker(new MarkerOptions().position(aposto).title("Aposto"));
        this.googleMap.addMarker(new MarkerOptions().position(koffer).title("Der Kofferraum"));
        this.googleMap.addMarker(new MarkerOptions().position(pinte).title("Die Pinte"));
        this.googleMap.addMarker(new MarkerOptions().position(strawberry).title("Erdbeermund"));
        this.googleMap.addMarker(new MarkerOptions().position(flynn).title("Flynn's Inn"));
        this.googleMap.addMarker(new MarkerOptions().position(scruffy).title("Scruffy's"));
        //googleMap.setLatLngBoundsForCameraTarget(karlsruhe);
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(euro, 17));
        this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(this.googleMap.getCameraPosition()).tilt(50).build()));


        /*
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
                //Location Permission already granted
                buildGoogleApiClient();
                googleMap.setMyLocationEnabled(true);
            } else {
                //Request Location Permission
                checkLocationPermission();
            }
        } else {
            buildGoogleApiClient();
            googleMap.setMyLocationEnabled(true);
            return;
        }
        */
        /*if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }*/
        this.googleMap.setMyLocationEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
