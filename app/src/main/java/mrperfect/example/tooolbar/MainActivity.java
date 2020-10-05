package mrperfect.example.tooolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    /**
     * For intent
     **/
    private CardView bus_main_activity;
    private CardView boating_main_activity;
    private CardView nav_buss_bar;
    private CardView nav_train_bar;
    private CardView nav_cycling_bar;
    private CardView nav_plane_bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** For intent **/
        bus_main_activity = findViewById(R.id.nav_bus_bar);
        bus_main_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        /**      Hooks           **/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        /*** -----------------------Tool Bar -----------------------------**/
        setSupportActionBar(toolbar);

        /*** -----------------------Navigation Drawer Menu -----------------------------**/
        /**Hide or Show items **/
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(true);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        /**-----------OnClickListener for bus activity--------**/
        bus_main_activity = findViewById(R.id.nav_bus_bar);
        bus_main_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitybus_menu();
            }

            private void openActivitybus_menu() {
                Intent intent = new Intent(MainActivity.this, ActivityWalking.class);
                startActivity(intent);
            }
        });

        /**-----------OnClickListener for boating activity--------**/
        boating_main_activity = (CardView) findViewById(R.id.nav_boat_bar);
        boating_main_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent boating_intent = new Intent(MainActivity.this, ActivityBoating.class);
                startActivity(boating_intent);
            }
        });

        /**-----------OnClickListener for bus activity--------**/
        nav_buss_bar = (CardView) findViewById(R.id.nav_boat_bar);
        nav_buss_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buss_nav = new Intent(MainActivity.this, ActivityBusMenu.class);
                startActivity(buss_nav);
            }
        });



    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_bus:
                Intent intent = new Intent(MainActivity.this, Bus.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}