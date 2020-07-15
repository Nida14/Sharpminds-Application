package com.roboticsworld.sharpminds;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.roboticsworld.sharpminds.shared_preference.shared_pref;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    FirebaseAuth auth;
    NavigationView navigationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MenuFragment()).commit();
            navigationView.setCheckedItem(R.id.fragment_menu);
        }

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.fragment_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MenuFragment()).commit();
                break;
            case R.id.contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;
            case R.id.logout:
                auth = FirebaseAuth.getInstance();
                if (auth.getCurrentUser() != null) {
                    // User is logged in
                    auth.signOut();
                    new shared_pref(this).getLogOut();
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                }
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
