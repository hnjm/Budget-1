package com.alekso.budget.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.alekso.budget.R;
import com.alekso.budget.ui.accounts.AccountsFragment;
import com.alekso.budget.ui.review.ReviewFragment;
import com.alekso.budget.ui.timeline.TimelineFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ReviewFragment fragment;
        fragment = (ReviewFragment) getSupportFragmentManager().findFragmentByTag(ReviewFragment.TAG);
        if (fragment == null) {
            fragment = ReviewFragment.newInstance();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment, ReviewFragment.TAG).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_review) {
            showReviewFragment();
        } else if (id == R.id.nav_accounts) {
            showAccountsFragment();
        } else if (id == R.id.nav_timeline) {
            showTimelineFragment();
        } else if (id == R.id.nav_planning) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showAccountsFragment() {
        AccountsFragment fragment = (AccountsFragment) getSupportFragmentManager().findFragmentByTag(AccountsFragment.TAG);
        if (fragment == null) {
            fragment = AccountsFragment.newInstance();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment, AccountsFragment.TAG).commit();
    }

    private void showReviewFragment() {
        ReviewFragment fragment = (ReviewFragment) getSupportFragmentManager().findFragmentByTag(ReviewFragment.TAG);
        if (fragment == null) {
            fragment = ReviewFragment.newInstance();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment, ReviewFragment.TAG).commit();

    }

    private void showTimelineFragment() {
        TimelineFragment fragment = (TimelineFragment) getSupportFragmentManager().findFragmentByTag(TimelineFragment.TAG);
        if (fragment == null) {
            fragment = TimelineFragment.newInstance();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment, TimelineFragment.TAG).commit();

    }
}
