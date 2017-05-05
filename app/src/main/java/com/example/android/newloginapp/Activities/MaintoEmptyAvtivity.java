package com.example.android.newloginapp.Activities;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.newloginapp.Listviews.HomeFragmentListViewActivity;
import com.example.android.newloginapp.R;
import com.example.android.newloginapp.Secondfragmenttesting;

/**
 * Created by omar on 31-01-2017.
 */

public class MaintoEmptyAvtivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    FragmentManager fragmentManager;
//    HomeFragmentListViewActivity fragment = new HomeFragmentListViewActivity();

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);



        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container, new HomeFragmentListViewActivity())
                .commit();


//        if (findViewById(R.id.fragment_container) != null){
 //      }
//        initNavigationDrawer();
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new HomeFragmentListViewActivity())
                    .commit();
            Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.settings) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new Secondfragmenttesting())
                    .commit();
            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();

        } else if(id == R.id.trash){
            drawerLayout.closeDrawers();
        } else if(id == R.id.logout){
            drawerLayout.closeDrawers();
        }


        drawerLayout  = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }






//    public void initNavigationDrawer() {
//
//        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
//
//
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem menuItem) {
//
//                int id = menuItem.getItemId();
//
//                switch (id){
//                    case R.id.home:
//                        fragmentManager = getSupportFragmentManager();
//                        fragmentManager.beginTransaction()
//                            .replace(R.id.fragment_container, fragment)
//                            .commit();
//                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
//                        drawerLayout.closeDrawers();
//                        break;
//                    case R.id.settings:
//                        Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
//                        drawerLayout.closeDrawers();
//                        break;
//                    case R.id.trash:
//                        Toast.makeText(getApplicationContext(),"Trash",Toast.LENGTH_SHORT).show();
//                        drawerLayout.closeDrawers();
//                        break;
//                    case R.id.logout:
//                        finish();
//
//                }
//                return true;
//            }
//        });
//        View header = navigationView.getHeaderView(0);
//        TextView tv_email = (TextView)header.findViewById(R.id.tv_email);
//        tv_email.setText("omar@gmail.com");
//        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
//
//        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){
//
//            @Override
//            public void onDrawerClosed(View v){
//                super.onDrawerClosed(v);
//            }
//
//            @Override
//            public void onDrawerOpened(View v) {
//                super.onDrawerOpened(v);
//            }
//        };
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//    }



    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this,SpinnerStateCitySelectorActivity.class);
        finish();
        startActivity(intent);
    }
}
