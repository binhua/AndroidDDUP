package info.binhua.androidddup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import info.binhua.androidddup.qunaer.QunarSplashActivity;

public class MainActivity extends Activity {

    private ListView lv_main_nav;

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
                        Intent intent = new Intent(MainActivity.this, QunarSplashActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
