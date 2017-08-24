package lveapp.fr.lamarcheavecdieu.View.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import lveapp.fr.lamarcheavecdieu.Presenter.HomePresenter;
import lveapp.fr.lamarcheavecdieu.R;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.HomeInterface.IHomeActivity;

public class HomeActivity extends AppCompatActivity implements IHomeActivity {

    private FloatingActionButton fabShare;
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
        fabShare = (FloatingActionButton) findViewById(R.id.fab);
    }

    @Override
    public void setWidgetsEvents() {
        setSupportActionBar(toolbar);
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
