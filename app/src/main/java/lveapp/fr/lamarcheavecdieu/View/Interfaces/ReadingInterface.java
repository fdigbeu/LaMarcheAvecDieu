package lveapp.fr.lamarcheavecdieu.View.Interfaces;

import android.view.View;

/**
 * Created by Maranatha on 26/08/2017.
 */

public class ReadingInterface {
    public interface IReadingPresenter{

    }

    public interface IReadingActivity{

        /**
         * Identify all widgets
         */
        public void findWidgetsAndSetEvents();
    }
}
