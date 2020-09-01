package com.f.healthmonitoring.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.f.healthmonitoring.R;
import com.f.healthmonitoring.ui.Profile.ProfileFragment;
import com.f.healthmonitoring.ui.SeeMedicinePrescriptions.SeeMedicineFragment;
import com.f.healthmonitoring.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
SearchView searchView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         HomeFragment();

        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_seeallldoctor,
                R.id.nav_EmergencyAlertNotification,  R.id.nav_Seemedicineprescriptionlist)
                .setDrawerLayout(drawerLayout)
                .build();

      DataManager(getSupportFragmentManager());
    }
    public void DataManager(FragmentManager fragmentManager) {
        Fragment fragment = new HomeFragment();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_logout){
            SharedPreferences.Editor prefs = getSharedPreferences("login", MODE_PRIVATE).edit();
           prefs.clear().apply();
           finishAffinity();
           startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }
public void HomeFragment(){
    HomeFragment frag = new HomeFragment();
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(R.id.nav_host_fragment,frag,"Test Fragment");
    transaction.commit();

}


    public void SeeMedicineFragment(){
        SeeMedicineFragment frag = new SeeMedicineFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment,frag,"Test Fragment");
        transaction.commit();

    }

    public void ProfileFragment(){
        ProfileFragment frag = new ProfileFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment,frag,"Test Fragment");
        transaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
 if (id == R.id.nav_home) {
     HomeFragment();

 }


        else if (id == R.id.nav_Seemedicineprescriptionlist)
 {
     SeeMedicineFragment();
 }
else if (id == R.id.nav_Profile)
        {
            ProfileFragment();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
