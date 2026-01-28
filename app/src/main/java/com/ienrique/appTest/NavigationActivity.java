package com.ienrique.appTest;

import static android.widget.Toast.LENGTH_LONG;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

public class NavigationActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_navigation);

        TextView textHeader = findViewById(R.id.text_header);
        Client[] clients;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            clients = getIntent().getSerializableExtra("dataClient", Client[].class);
        } else {
            clients = (Client[]) getIntent().getSerializableExtra("dataClient");
        }
        if (clients !=null) {
            textHeader.setText(String.format("Bonjour %s", clients[0].getName()));
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnItemSelectedListener(NavigationActivity.this);
        loadFragment(new TextFragment());
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        } else {
            Toast.makeText(this, "Problème Fragment", LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.item_fragment_text) {
            loadFragment(new TextFragment());
            return true;
        } else if (menuItem.getItemId() == R.id.item_fragment_image) {
            loadFragment(new ImageFragment());
            return true;
        }
        return false;
    }
}