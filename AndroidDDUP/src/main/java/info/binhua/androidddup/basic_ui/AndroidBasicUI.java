package info.binhua.androidddup.basic_ui;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import info.binhua.androidddup.R;


public class AndroidBasicUI extends LauncherActivity {

    private String[] item_names;
    private Class<?>[] clazzs = {TextViewTest.class};

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        item_names = this.getResources().getStringArray(R.array.basicUI_name);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AndroidBasicUI.this,
                android.R.layout.simple_list_item_1, item_names);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(AndroidBasicUI.this, clazzs[position]);
    }
}
