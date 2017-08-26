package lveapp.fr.lamarcheavecdieu.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import lveapp.fr.lamarcheavecdieu.Presenter.CommonPresenter;
import lveapp.fr.lamarcheavecdieu.Presenter.HomePresenter;
import lveapp.fr.lamarcheavecdieu.R;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.HomeInterface.IHomeActivity;

public class HomeActivity extends AppCompatActivity implements IHomeActivity {

    private FloatingActionButton fabMenuMore;
    private Toolbar toolbar;
    private HomePresenter homePresenter;
    private final int[] summaryTextId = {R.id.title_t1, R.id.title_t2, R.id.title_t3, R.id.title_t4,
            R.id.title_t5, R.id.title_t6, R.id.title_t7, R.id.title_t8, R.id.title_t9,
            R.id.subtitle_t1, R.id.subtitle_t2, R.id.subtitle_t3, R.id.subtitle_t4, R.id.subtitle_t5,
            R.id.subtitle_t6, R.id.subtitle_t7, R.id.subtitle_t8, R.id.subtitle_t9, R.id.subtitle_t10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Load home data
        homePresenter = new HomePresenter(this);
        homePresenter.loadHomeData(HomeActivity.this);
    }

    @Override
    public void findWidgetsAndSetEvents() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //--
        fabMenuMore = (FloatingActionButton) findViewById(R.id.fab_menu_more);
        fabMenuMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePresenter.retrieveUserAction(view);
            }
        });
        //--
        for (int i=0; i<summaryTextId.length; i++){
            findViewById(summaryTextId[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    homePresenter.retrieveUserAction(view);
                }
            });
        }
    }

    @Override
    public void displayMenuMoreItem(View view) {
        PopupMenu popup = new PopupMenu(HomeActivity.this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu_more, popup.getMenu());
        popup.show();
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                homePresenter.retrieveUserAction(item);
                return false;
            }
        });
    }

    @Override
    public void displayReadingActivity() {
        Intent intent = new Intent(HomeActivity.this, ReadingActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
