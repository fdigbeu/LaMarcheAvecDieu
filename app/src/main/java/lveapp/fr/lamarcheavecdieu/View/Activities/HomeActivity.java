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

import java.util.ArrayList;

import lveapp.fr.lamarcheavecdieu.Presenter.CommonPresenter;
import lveapp.fr.lamarcheavecdieu.Presenter.HomePresenter;
import lveapp.fr.lamarcheavecdieu.R;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.HomeInterface.IHomeActivity;

public class HomeActivity extends AppCompatActivity implements IHomeActivity {

    private FloatingActionButton fabMenuMore;
    private Toolbar toolbar;
    private HomePresenter homePresenter;
    private ArrayList<View> listOfView;

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
                homePresenter.retrieveUserAction(null, view);
            }
        });
        //--
        listOfView = new ArrayList<>();
        for (int i=0; i<CommonPresenter.getSummaryTextId().length; i++){
            listOfView.add(i, findViewById(CommonPresenter.getSummaryTextId()[i]));
            listOfView.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    homePresenter.retrieveUserAction(listOfView, view);
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
    public void displayReadingActivity(String keyCode) {
        Intent intent = new Intent(HomeActivity.this, ReadingActivity.class);
        intent.putExtra("keyCode", keyCode);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
