package info.binhua.androidddup.basic_ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Administrator on 2014/7/28.
 */
public class TextViewTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setText("in textactivity");
        setContentView(textView);
    }
}
