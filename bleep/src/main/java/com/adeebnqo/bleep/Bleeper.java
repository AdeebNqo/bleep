package com.adeebnqo.bleep;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Random;

public class Bleeper {

    protected final String APP_TAG = "Bleeper-Tool";

    private static Bleeper BLEEPER_INSTANCE;
    private static Context applicationContext;
    public static boolean tryPlaySound = true;


    public static Bleeper getBlepper() {
        if (BLEEPER_INSTANCE == null) {
            BLEEPER_INSTANCE = new Bleeper();
        }
        return BLEEPER_INSTANCE;
    }
    public static void init(Context context) {
        applicationContext = context;
    }

    private final int AUDIO_ID = R.raw.honk;

    MediaPlayer mediaPlayer;
    Vibrator phoneVibrator;
    Random randomGenerator;
    View untouchedView;
    TextView numberView;

    protected  Bleeper() {
        if (applicationContext == null) {
            Log.v(APP_TAG, "Bleeper Context is null");
        } else {
            mediaPlayer = MediaPlayer.create(applicationContext, AUDIO_ID);
            phoneVibrator = (Vibrator) this.applicationContext.getSystemService(Context.VIBRATOR_SERVICE);

            LayoutInflater inflater = (LayoutInflater)applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            untouchedView = inflater.inflate(R.layout.random_view, null);
            numberView = (TextView) untouchedView.findViewById(R.id.numberView);

            untouchedView.setBackgroundColor(applicationContext.getResources().getColor(android.R.color.black));

            randomGenerator = new Random();
        }
    }

    public Bleeper beep() {
        if (applicationContext == null) {
            Log.d(APP_TAG, "Bleeper Context is null");
        } else {
            if (tryPlaySound && mediaPlayer != null && !mediaPlayer.isPlaying()) {
                Log.v(APP_TAG, applicationContext.getString(R.string.playing_sound));
                mediaPlayer.start();
            } else {
                Log.v(APP_TAG, applicationContext.getString(R.string.unable_play_sound));
            }
        }
        return Bleeper.this;
    }

    public Bleeper move() {
        if (applicationContext != null) {
            phoneVibrator.vibrate(15000);
        }
        return Bleeper.this;
    }

    public Bleeper showVisualIndicator(final Activity activity){

        if (activity==null) {
            return null;
        }
        if(untouchedView!=null && untouchedView.getWindowToken() == null) {
            final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);

            numberView.setText(String.valueOf(randomGenerator.nextInt()));
            viewGroup.addView(untouchedView, new WindowManager.LayoutParams());
            untouchedView.bringToFront();
            untouchedView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewGroup.removeView(untouchedView);
                }
            });
        }
        return Bleeper.this;
    }
}
