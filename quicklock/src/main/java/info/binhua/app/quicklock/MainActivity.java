package info.binhua.app.quicklock;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_CODE_ENABLE_ADMIN = 0x00;
    private DevicePolicyManager dmp;
    private ComponentName mDeviceAdminSample;
    private Button btn_active;
    private Button btn_lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dmp = (DevicePolicyManager)getSystemService(DEVICE_POLICY_SERVICE);
        mDeviceAdminSample = new ComponentName(this, MyAdmin.class);
        btn_active = (Button)findViewById(R.id.btn_active);
        btn_lock = (Button)findViewById(R.id.btn_lock);

        //判断是否激活
        boolean flag = dmp.isAdminActive(mDeviceAdminSample);
        if(!flag){
            btn_active.setVisibility(View.VISIBLE);
            btn_lock.setVisibility(View.GONE);
        }else{
            btn_active.setVisibility(View.GONE);
            btn_lock.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 一键锁屏
     * @param view
     */
    public void quickLock(View view){

        dmp.lockNow();
        this.finish();
    }

    /**
     * 激活一键锁屏
     * @param view
     */
    public void quickActive(View view){
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);

        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mDeviceAdminSample);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                "开启一键锁屏应用");
        startActivityForResult(intent, REQUEST_CODE_ENABLE_ADMIN);
    }

    /**
     * 激活成功后返回处理
     * @param requestCode
     * @param resultCode
     * @param data
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_ENABLE_ADMIN){
            Toast.makeText(this, "激活成功！", Toast.LENGTH_LONG).show();
            btn_active.setVisibility(View.GONE);
            btn_lock.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 卸载一键锁屏
     * @param view
     */
    public void uninstall(View view){
        ComponentName mDeviceAdminSample = new ComponentName(this, MyAdmin.class);
        dmp.removeActiveAdmin(mDeviceAdminSample);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DELETE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:"+getPackageName()));
        startActivity(intent);
    }
}
