package info.binhua.androidddup.qunaer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;

import info.binhua.androidddup.R;

/**
 * Created by dell on 2014/7/23.
 */
public class QunarSplashActivity  extends Activity{

    private RelativeLayout rl_splash_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_qunar_splash);
        rl_splash_root = (RelativeLayout)findViewById(R.id.rl_splash_root);
        rl_splash_root.setAnimation(new AlphaAnimation(0.5f, 1.0f));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(QunarSplashActivity.this, QunarUIActivity.class);
                startActivity(intent);
            }
        }).start();
    }
}
