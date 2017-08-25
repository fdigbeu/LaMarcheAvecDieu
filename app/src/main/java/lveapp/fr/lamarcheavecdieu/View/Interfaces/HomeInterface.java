package lveapp.fr.lamarcheavecdieu.View.Interfaces;

import android.view.View;

/**
 * Created by Maranatha on 24/08/2017.
 */

public class HomeInterface {
    public interface IHomePresenter{

    }

    public interface IHomeActivity{
        /**
         * Identify all widgets
         */
        public void findWidgetsById();
        /**
         * Set all widgets events
         */
        public void setWidgetsEvents();

        /**
         * Display menu more item
         * @param view
         */
        public void displayMenuMoreItem(View view);
    }
}
