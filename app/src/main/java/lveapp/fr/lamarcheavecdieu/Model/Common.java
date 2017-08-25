package lveapp.fr.lamarcheavecdieu.Model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Maranatha on 25/08/2017.
 */

public class Common {
    public static void saveDataInSharePreferences(Context context, String keyData, String contentData){
        SharedPreferences sharedPreferences = context.getSharedPreferences("SHARED_PREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(keyData, contentData);
        editor.commit();
    }

    public static String getDataFromSharePreferences(Context context, String keyData){
        SharedPreferences sharedPreferences = context.getSharedPreferences("SHARED_PREFERENCES", Context.MODE_PRIVATE);
        return sharedPreferences.getString(keyData, "");
    }
}
