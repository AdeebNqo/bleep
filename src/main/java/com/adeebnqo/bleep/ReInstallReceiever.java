package com.adeebnqo.bleep;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ReInstallReceiever extends BroadcastReceiver {
    public ReInstallReceiever() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("foobar", "getting action "+intent.getAction());
    }
}
