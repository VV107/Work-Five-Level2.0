package com.vv.level20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView mImgHead;
    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLogin();
    }

    private void initView() {
        mImgHead = findViewById(R.id.img_main_head);
        mEtUsername = findViewById(R.id.et_main_username);
        mEtPassword = findViewById(R.id.et_main_password);
        mBtnLogin = findViewById(R.id.btn_main_login);

    }

    private void initLogin() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });
    }
    private void login() {
        String username = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();
        if (username.equals("12345") && password.equals("12345")) {
            loginSuccess(username, password);
        } else {
            loginFailure();
        }
    }
    private void loginSuccess(String username, String password) {
        Toast.makeText(this, "登陆成功!", Toast.LENGTH_SHORT).show();
        ContentActivity.startActivity(this, username, password);
        Intent intent = new Intent(this, ContentActivity.class);
        startActivity(intent);
    }
    private void loginFailure() {
        Toast.makeText(this, "账号或者密码输错了 :(",
                Toast.LENGTH_SHORT).show();
    }

}