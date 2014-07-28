package info.binhua.androidddup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import info.binhua.androidddup.basic_ui.AndroidBasicUI;
import info.binhua.androidddup.qunaer.QunarSplashActivity;

public class MainActivity extends Activity {

    private ListView lv_main_nav;
    private Context context = MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_main_nav = (ListView) findViewById(R.id.lv_main_nav);
        lv_main_nav.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, this.getResources().getStringArray(R.array.item_nav)));

        lv_main_nav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        Intent intent0 = new Intent(context, QunarSplashActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(context, AndroidBasicUI.class);
                        startActivity(intent1);
                        break;
                    default:break;
                }
            }
        });
    }
}
