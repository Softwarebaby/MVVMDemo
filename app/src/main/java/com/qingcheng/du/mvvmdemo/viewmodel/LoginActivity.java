package com.qingcheng.du.mvvmdemo.viewmodel;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.qingcheng.du.mvvmdemo.R;
import com.qingcheng.du.mvvmdemo.databinding.ActivityLoginBinding;
import com.qingcheng.du.mvvmdemo.model.UserModel;

public class LoginActivity extends AppCompatActivity {
    protected static int SUCCESS = 1;
    protected static int ERROR = 2;
    private ActivityLoginBinding binding;
    private Context mContext;
    private UserModel userModel;
    private ProgressDialog dialog;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == SUCCESS)
                Toast.makeText(mContext, "Login Success!", Toast.LENGTH_SHORT).show();
            else if(msg.what == ERROR)
                Toast.makeText(mContext, "Login Error!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        dialog = new ProgressDialog(this);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userModel = new UserModel(binding.etUsername.getText().toString(), binding.etPassword.getText().toString());
                binding.setUser(userModel);
                doLogin();
            }
        });
    }

    private void doLogin() {
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              dialog.cancel();
              int res = userModel.checkLogin();
              Message message = new Message();
              if(res == -1)
                  message.what = ERROR;
              else if(res == 0)
                  message.what = SUCCESS;
              handler.sendMessage(message);
            }
        },2000);
    }
}
