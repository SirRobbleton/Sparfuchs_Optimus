package de.sparfuchs_optimus.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import de.sparfuchs_optimus.R;

public class MapFragment extends Fragment implements OnMapReadyCallback
{
    private MapView mapView;
    private GoogleMap mMap;

    public static MapFragment newInstance() {
        MapFragment mapFragment = new MapFragment();
        return mapFragment;
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_map, container, false);
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
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setIndoorEnabled(false);
        mMap.setBuildingsEnabled(true);

        // Set boundary for Karlsruhe
        LatLngBounds karlsruhe = new LatLngBounds(
                new LatLng(48.996694, 8.378687), new LatLng(49.024639, 8.423896));

        // Add a marker in Karlsruhe and move the camera
        LatLng euro = new LatLng(49.009927, 8.395140);
        LatLng shotz = new LatLng(49.008477, 8.396108);
        LatLng badbrau = new LatLng(49.011877, 8.394246);
        LatLng aposto = new LatLng(49.008791, 8.396359);
        // mMap.addMarker(new MarkerOptions().position(myLocation).title("Your Location!"));
        mMap.addMarker(new MarkerOptions().position(shotz).title("Shotz"));
        mMap.addMarker(new MarkerOptions().position(badbrau).title("Badisches Brauhaus"));
        mMap.addMarker(new MarkerOptions().position(aposto).title("Aposto"));
        //mMap.setLatLngBoundsForCameraTarget(karlsruhe);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(euro, 18));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(mMap.getCameraPosition()).tilt(50).build()));


        /*
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
                //Location Permission already granted
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            } else {
                //Request Location Permission
                checkLocationPermission();
            }
        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
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
        mMap.setMyLocationEnabled(true);
    }
}