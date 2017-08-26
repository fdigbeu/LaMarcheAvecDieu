package lveapp.fr.lamarcheavecdieu.Presenter;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import lveapp.fr.lamarcheavecdieu.Model.Summary;
import lveapp.fr.lamarcheavecdieu.R;

/**
 * Created by Maranatha on 25/08/2017.
 */

public class CommonPresenter {
    /**
     * Get summary titleKeyCode or subtitleKeyCode by view id
     * @param viewId
     * @return
     */
    public static String getKeyCodeByViewId(int viewId){
        Hashtable<Integer, String> listKeyValue = new Hashtable<>();
        listKeyValue.put(R.id.title_t1, "3483480362");listKeyValue.put(R.id.title_t2, "3a77605a10");
        listKeyValue.put(R.id.title_t3, "e357ca6c85");listKeyValue.put(R.id.title_t4, "ee83717fde");
        listKeyValue.put(R.id.title_t5, "98be77822b");listKeyValue.put(R.id.title_t6, "a65f3dfdea");
        listKeyValue.put(R.id.title_t7, "9941547802");listKeyValue.put(R.id.title_t8, "3a955eb27c");
        listKeyValue.put(R.id.title_t9, "ab3a669d46");listKeyValue.put(R.id.subtitle_t1, "53e7aacf0f");
        listKeyValue.put(R.id.subtitle_t2, "a4a3bb244f");listKeyValue.put(R.id.subtitle_t3, "8b7fddada0");
        listKeyValue.put(R.id.subtitle_t4, "308f5ac886");listKeyValue.put(R.id.subtitle_t5, "326bf340f0");
        listKeyValue.put(R.id.subtitle_t6, "f54f7aacb4");listKeyValue.put(R.id.subtitle_t7, "91c4fe0d35");
        listKeyValue.put(R.id.subtitle_t8, "10a6ea8869");listKeyValue.put(R.id.subtitle_t9, "713ea2b7d6");
        listKeyValue.put(R.id.subtitle_t10, "ef01d52a8e");
        return listKeyValue.containsKey(viewId) ? listKeyValue.get(viewId) : null;
    }

    /**
     * Get list of all summary title
     * @param context
     * @return
     */
    public static ArrayList<Summary> getSummaryTitleList(Context context){
        ArrayList<Summary> mList = new ArrayList<>();
        String srcFichier = "json/summary.json";
        try
        {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset(context, srcFichier));
            for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String titre = jsonObject.getString("titre");
                String titreNumero = jsonObject.getString("titreNumero");
                String titreKeycode = jsonObject.getString("titreKeycode");
                mList.add(new Summary(titre, titreKeycode, titreNumero));
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return mList;
    }

    /**
     * Get summary title information by "titleKeyCode"
     * @param context
     * @return
     */
    public static Summary getSummaryTitleInfos(Context context, String titleKeyCode){
        Summary summary = null;
        String srcFichier = "json/summary.json";
        try
        {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset(context, srcFichier));
            for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String titre = jsonObject.getString("titre");
                String titreNumero = jsonObject.getString("titreNumero");
                String titreKeycode = jsonObject.getString("titreKeycode");
                if(titleKeyCode.equalsIgnoreCase(titreKeycode)){
                    summary = new Summary(titre, titreKeycode, titreNumero);
                }
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return summary;
    }

    /**
     * Get list of all summary subtitle by summary title keycode
     * @param context
     * @return
     */
    public static ArrayList<Summary> getSummarySubTitleListBy(Context context, String titleKeyCode){
        ArrayList<Summary> mList = new ArrayList<>();
        String srcFichier = "json/summary.json";
        try
        {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset(context, srcFichier));
            for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String titreKeycode = jsonObject.getString("titreKeycode");
                if(titleKeyCode.equalsIgnoreCase(titreKeycode)){
                    JSONArray jsonFilsArray = new JSONArray(jsonObject.getString("soustitre"));
                    for(int j = 0; j < jsonFilsArray.length(); j++){
                        JSONObject jsonFilsObject = jsonFilsArray.getJSONObject(j);
                        String sousTitreValue = jsonFilsObject.getString("sousTitreValue");
                        String sousTitreNumero = jsonFilsObject.getString("sousTitreNumero");
                        String sousTitreKeyCode = jsonFilsObject.getString("sousTitreKeyCode");
                        mList.add(new Summary(sousTitreValue, sousTitreKeyCode, sousTitreNumero));
                    }
                }
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return mList;
    }

    /**
     * Load json file from asset folder
     * @param context
     * @param srcFichier
     * @return
     */
    private static String loadJSONFromAsset(Context context, String srcFichier) {
        String json = null;
        try
        {
            InputStream is = context.getAssets().open(srcFichier);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
