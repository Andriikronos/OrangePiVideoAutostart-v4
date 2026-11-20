package com.orange.pi.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "OrangePiAutostart";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!Intent.ACTION_BOOT_COMPLETED.equals(action)
                && !Intent.ACTION_MY_PACKAGE_REPLACED.equals(action)) return;

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            try {
                Intent launch = new Intent(Intent.ACTION_VIEW);
                launch.setClassName("com.softwinner.TvdVideo",
                        "com.softwinner.TvdVideo.TvdVideoActivity");
                launch.setDataAndType(
                        Uri.parse("file:///sdcard/Movies/Punto_TV.mp4"), "video/mp4");
                launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(launch);
            } catch (Exception e) {
                Log.e(TAG, "Failed to start TvdVideo", e);
            }
        }, 12000);
    }
}
