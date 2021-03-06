package lveapp.fr.lamarcheavecdieu.View.Activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import lveapp.fr.lamarcheavecdieu.Model.Content;
import lveapp.fr.lamarcheavecdieu.Model.Summary;
import lveapp.fr.lamarcheavecdieu.Presenter.CommonPresenter;
import lveapp.fr.lamarcheavecdieu.Presenter.ReadingPresenter;
import lveapp.fr.lamarcheavecdieu.R;
import lveapp.fr.lamarcheavecdieu.View.Adapters.ContentItemsAdapter;
import lveapp.fr.lamarcheavecdieu.View.Adapters.SummaryItemsAdapter;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.ReadingInterface.IReadingActivity;

public class ReadingActivity extends AppCompatActivity
        implements IReadingActivity {

    private TextView headerTitle;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private ReadingPresenter readingPresenter;
    private RecyclerView menuSummary;
    private RecyclerView bookContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        readingPresenter = new ReadingPresenter(this);
        readingPresenter.loadReadingData(ReadingActivity.this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reading, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    @Override
    public void findWidgetsAndSetEvents() {

        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Garamond_Premier_Pro.ttf");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        headerTitle = (TextView)findViewById(R.id.app_bar_title_textView);
        headerTitle.setTypeface(font);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        
        //--
        menuSummary=(RecyclerView)findViewById(R.id.menu_summary);
        bookContent = (RecyclerView)findViewById(R.id.book_content);
    }

    @Override
    public void displaySummaryContent(ArrayList<Summary> summaryItems) {
        GridLayoutManager gridLayout = new GridLayoutManager(ReadingActivity.this, 1);
        menuSummary.setLayoutManager(gridLayout);
        menuSummary.setHasFixedSize(true);

        SummaryItemsAdapter mAdapter = new SummaryItemsAdapter(ReadingActivity.this, summaryItems, drawer);
        menuSummary.setAdapter(mAdapter);
    }

    @Override
    public void displayBookContent(ArrayList<Content> contentItems) {
        GridLayoutManager gridLayout = new GridLayoutManager(ReadingActivity.this, 1);
        bookContent.setLayoutManager(gridLayout);
        bookContent.setHasFixedSize(true);

        ContentItemsAdapter mAdapter = new ContentItemsAdapter(ReadingActivity.this, contentItems);
        bookContent.setAdapter(mAdapter);
    }
}
