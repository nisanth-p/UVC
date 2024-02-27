package com.advantech.uvc.vcall;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.advantech.uvc.R;
import com.advantech.uvc.tensorflow.TensorFlowActivity;
import com.advantech.uvc.vcall.AgoraActivity;
import com.hjq.permissions.XXPermissions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "xxMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListeners();
    }

    private void initListeners() {
        Button btnBasicPreview = findViewById(R.id.btnBasicPreview);
        Button btnObject = findViewById(R.id.btnObject);
        btnBasicPreview.setOnClickListener(this);
        btnObject.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        List<String> needPermissions = new ArrayList<>();
        needPermissions.add(Manifest.permission.CAMERA);

        XXPermissions.with(this)
                .permission(needPermissions)
                .request((permissions, all) -> {
                    if (v.getId() == R.id.btnBasicPreview) {
                        Class<?> activity = null;
                        if (true) activity = AgoraActivity.class;
                        else activity = TensorFlowActivity.class;
                        startActivity(new Intent(this, activity));
                        finish();
                    }else if (v.getId() == R.id.btnObject){
                        startActivity(new Intent(this, TensorFlowActivity.class));
                        finish();
                    }

                });

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}