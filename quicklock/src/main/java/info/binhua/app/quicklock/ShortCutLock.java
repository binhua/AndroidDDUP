package info.binhua.app.quicklock;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.os.Bundle;

/**
 * Created by Administrator on 2014/7/29.
 */
public class ShortCutLock extends Activity {

    private DevicePolicyManager dpm;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        dpm = (DevicePolicyManager)getSystemService(DEVICE_POLICY_SERVICE);
        ComponentName mDeviceAdminSample = new ComponentName(this, MyAdmin.class);
        boolean flag = dpm.isAdminActive(mDeviceAdminSample);
        dpm.lockNow();
        this.finish();
    }
}
