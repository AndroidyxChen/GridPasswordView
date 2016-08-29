package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.jungly.gridpasswordview.GridPasswordView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog showlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialog();
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(this, R.layout.dialog_password, null);
        showlog = builder.create();
        showlog.setView(view, 0, 0, 0, 0);
//      show.setView(passwordLayout, 0, 0, 0, 0);
        showlog.show();
        GridPasswordView www = (GridPasswordView) view.findViewById(R.id.pws);
        www.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() {
            @Override
            public void onChanged(String psw) {
                if (psw.length() == 6) {
                    showlog.dismiss();
                    Toast.makeText(getApplicationContext(),"密码正确,已关闭",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onMaxLength(String psw) {

            }
        });
    }
}



