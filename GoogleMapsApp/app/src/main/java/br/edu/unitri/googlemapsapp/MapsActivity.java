package br.edu.unitri.googlemapsapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        /*
         * Adiciona uma marcador ao mapa passando a lat e long do local
         */
        LatLng sydney = new LatLng(-34, 151);

        /*
         * Adiciona um hint que é apresentado quando o usuário clica no marcador
         */

        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        /*
         * Define o tipo de mapa a ser apresentado
         */

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        /*
         * Move a câmera para a latitude e longitude da localização
         */

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        /*
         * Define o zoom de exibição do mapa
         */

        mMap.animateCamera( CameraUpdateFactory.zoomTo( 15.0f ) );

    }
}