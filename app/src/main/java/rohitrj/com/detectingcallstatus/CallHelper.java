package rohitrj.com.detectingcallstatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class CallHelper extends BroadcastReceiver {

    //BroadCast Receiver is used to that even when the app is not running we can detect changes and display it.

    //onRecieve Method is called every time when the call status changes.

    @Override
    public void onReceive(Context context, Intent intent) {

        String Tag="CallHelper";
        //Here we are getting which type of action is performed.
        String actionPerformed=intent.getAction();

        //same is also defined in thee manifest file.
        if(actionPerformed.equalsIgnoreCase("android.intent.action.PHONE_STATE")){

            if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                showToast(context,"Outgoing Call...");
                Log.i(Tag,"Outgoing Call...");
                }

            if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE)){
                showToast(context,"Call disconnected.");
                Log.i(Tag,"Call disconnected.");
            }

            if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)){
                showToast(context,"Ringing...");
                Log.i(Tag,"Ringing...");
            }

        }
    }

    void showToast(Context context,String messgage){
        Toast toast= Toast.makeText(context,messgage,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
