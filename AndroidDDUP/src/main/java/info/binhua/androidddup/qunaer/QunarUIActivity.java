package info.binhua.androidddup.qunaer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import info.binhua.androidddup.R;


public class QunarUIActivity extends Activity {

    private TabHost tabHost;
    private TabWidget tabWidget;
    private LinearLayout tab1, tab2, tab3, tab4, tab5;
    private Context context = QunarUIActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_aunar_main);

        tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabWidget = (TabWidget)findViewById(android.R.id.tabs);

        tab1 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.qunar_tab_indicator, tabWidget, false);
        ImageView tab1_im = (ImageView)tab1.findViewById(R.id.iv_qunar_indicator);
        TextView tab1_tv = (TextView)tab1.findViewById(R.id.tv_qunar_indicator);
        tab1_tv.setText(R.string.tab_indicator_order);
        tab1_im.setBackgroundResource(R.drawable.qunar_indicator_order_selector);

        tab2 = (LinearLayout)LayoutInflater.from(context).inflate(R.layout.qunar_tab_indicator, tabWidget, false);
        ImageView tab2_im = (ImageView)tab2.findViewById(R.id.iv_qunar_indicator);
        TextView tab2_tv = (TextView)tab2.findViewById(R.id.tv_qunar_indicator);
        tab2_tv.setText(R.string.tab_indicator_mic);
        tab2_im.setBackgroundResource(R.drawable.qunar_indicator_mic_selector);

        tab3 = (LinearLayout)LayoutInflater.from(context).inflate(R.layout.qunar_tab_indicator, tabWidget, false);
        ImageView tab3_im = (ImageView)tab3.findViewById(R.id.iv_qunar_indicator);
        TextView tab3_tv = (TextView)tab3.findViewById(R.id.tv_qunar_indicator);
        tab3_tv.setText(R.string.tab_indicator_home);
        tab3_im.setBackgroundResource(R.drawable.qunar_indicator_home_selector);

        tab4 = (LinearLayout)LayoutInflater.from(context).inflate(R.layout.qunar_tab_indicator, tabWidget, false);
        ImageView tab4_im = (ImageView)tab4.findViewById(R.id.iv_qunar_indicator);
        TextView tab4_tv = (TextView)tab4.findViewById(R.id.tv_qunar_indicator);
        tab4_tv.setText(R.string.tab_indicator_nearby);
        tab4_im.setBackgroundResource(R.drawable.qunar_indicator_nearby_selector);

        tab5 = (LinearLayout)LayoutInflater.from(context).inflate(R.layout.qunar_tab_indicator, tabWidget, false);
        ImageView tab5_im = (ImageView)tab5.findViewById(R.id.iv_qunar_indicator);
        TextView tab5_tv = (TextView)tab5.findViewById(R.id.tv_qunar_indicator);
        tab5_tv.setText(R.string.tab_indicator_self);
        tab5_im.setBackgroundResource(R.drawable.qunar_indicator_self_selector);
    }

}
