package com.happyfeetexecutivepvtltd.temprature.base;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.happyfeetexecutivepvtltd.temprature.R;

public class OkDialog {
    Dialog dialog;

    public OkDialog(String message, Activity activity) {
        dialog = new Dialog(activity, R.style.AppTheme_PopTheme);
        dialog.setContentView(R.layout.okdialog);
        TextView tv_msg = (TextView) dialog.findViewById(R.id.tv_msg);
        Button ok = (Button) dialog.findViewById(R.id.btn_ok);

        tv_msg.setText(message);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

}