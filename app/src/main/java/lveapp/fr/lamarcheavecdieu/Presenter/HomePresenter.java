package lveapp.fr.lamarcheavecdieu.Presenter;

import android.content.Context;

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
    }
}
