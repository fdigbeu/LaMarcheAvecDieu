package lveapp.fr.lamarcheavecdieu.View.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import lveapp.fr.lamarcheavecdieu.Presenter.HomePresenter;
import lveapp.fr.lamarcheavecdieu.R;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.HomeInterface.IHomeActivity;

public class HomeActivity extends AppCompatActivity implements IHomeActivity {

    private FloatingActionButton fabMenuMore;
    private Toolbar toolbar;
    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Load home data
        homePresenter = new HomePresenter(this);
        homePresenter.loadHomeData(HomeActivity.this);
    }

    @Override
    public void findWidgetsById() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fabMenuMore = (FloatingActionButton) findViewById(R.id.fab_menu_more);
    }

    @Override
    public void setWidgetsEvents() {
        setSupportActionBar(toolbar);
        fabMenuMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePresenter.retrieveUserAction(view);
            }
        });
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
}
