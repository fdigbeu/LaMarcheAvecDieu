package lveapp.fr.lamarcheavecdieu.Presenter;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;

import java.util.Hashtable;

import lveapp.fr.lamarcheavecdieu.R;
import lveapp.fr.lamarcheavecdieu.View.Interfaces.HomeInterface.IHomeActivity;

/**
 * Created by Maranatha on 24/08/2017.
 */

public class HomePresenter {
    private Context context;
    private IHomeActivity iHomeActivity;

    public HomePresenter(IHomeActivity iHomeActivity) {
        this.iHomeActivity = iHomeActivity;
    }

    public void loadHomeData(Context context){
        this.context = context;
        iHomeActivity.findWidgetsById();
        iHomeActivity.setWidgetsEvents();
    }

    /**
     * Retrieve event of user action
     * @param view
     */
    public void retrieveUserAction(View view){
        switch (view.getId()){
            case R.id.fab_menu_more:
                iHomeActivity.displayMenuMoreItem(view);
                break;
        }
    }

    /**
     * Retrieve event of user action
     * @param item
     */
    public void retrieveUserAction(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_continuer_lecture:
                break;

            case R.id.action_partager_appli:
                break;

            case R.id.action_verifier_update:
                break;

            case R.id.action_modifier_parametre:
                break;
        }
    }
}
