package secondapp.gpp.com.secondapp;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/1/3.
 */

public class DataArray {

    public static java.util.ArrayList<HashMap<String,Object>> getArryList(){

        java.util.ArrayList<HashMap<String,Object>> list = new java.util.ArrayList<>();
        for(int i=1;i<20;i++){
            HashMap<String,Object> map= new HashMap<String, Object>() ;
            map.put("Item","line "+i+"");
            list.add(map);
        }
       return list;
    }
}
