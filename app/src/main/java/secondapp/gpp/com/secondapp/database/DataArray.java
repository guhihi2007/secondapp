package secondapp.gpp.com.secondapp.database;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/1/3.
 */

public class DataArray {

    public static java.util.ArrayList<HashMap<String, Object>> getArryList() {
        String[] name = {"殇大提琴曲", "天地孤影任我行", "寂静之声", "回梦游仙"};
        java.util.ArrayList<HashMap<String, Object>> list = new java.util.ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("Item", name[i]);
            list.add(map);
        }
        return list;
    }
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("Item", "殇大提琴曲");
//        map.put("Item", "天地孤影任我行");
//        map.put("Item", "寂静之声");
//        map.put("Item", "回梦游仙");
//        list.add(map);
}
