package com.example.upam.video_streamig_iissrraa;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView visor;
    //String url = "rtsp://172.16.163.71:1234/video";
    String url = "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visor = (VideoView) findViewById(R.id.videoView);

        visor.setVideoPath(url);
        visor.requestFocus();
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(visor);
        visor.setMediaController(mediaController);
        visor.start();

        AlertDialog alerta = new AlertDialog.Builder(this).create();

        alerta.setTitle("Alerta");
        alerta.setMessage("Visualizar video RTSP");
        alerta.setIcon(R.drawable.ic_stat_name);
        alerta.setButton(Dialog.BUTTON_POSITIVE,"Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                llamarToast();
            }
        });
        alerta.show();
    }

    public void llamarToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.customtoast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}
