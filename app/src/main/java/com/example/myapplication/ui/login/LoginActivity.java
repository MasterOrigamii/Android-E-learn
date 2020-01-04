package com.example.myapplication.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.BaseActivity;
import com.example.myapplication.Main2Activity;
import com.example.myapplication.MainPageActivity;
import com.example.myapplication.MultiMediaActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.CourseAdapter;
import com.example.myapplication.bean.CourseListBean;
import com.example.myapplication.utlis.BaseUrl;
import com.example.myapplication.utlis.SpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

public class LoginActivity extends BaseActivity implements PlatformActionListener {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getDatas();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.userNumTextView);
        final EditText passwordEditText = findViewById(R.id.passwordTextView);
        final Button loginButton = findViewById(R.id.loginBtn);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });


        //登录按键监听器
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                loadingProgressBar.setVisibility(View.VISIBLE);
//
//                loginViewModel.login(usernameEditText.getText().toString(),
//                       passwordEditText.getText().toString());
//
//               // 跳转至主页
//                Intent MainPageActivity =
//                        new Intent(getApplicationContext(), Main2Activity.class);
//
//                startActivity(MainPageActivity);

                getDatas();
                Intent MultiMediaActivity =
                        new Intent(getApplicationContext(), MultiMediaActivity.class);
                MultiMediaActivity.putExtra("list", list.get(0));

                startActivity(MultiMediaActivity);


                //结束这个Activity
                finish();
            }
        });

        findViewById(R.id.QQ_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginByQQ();
            }
        });
    }
    //////////////////////////////

    private ArrayList<CourseListBean> list;

    private void getDatas() {

        OkGo.<String>get(BaseUrl.baseUrl + "courses")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("hedb", "onSuccess: " + response.body());
                        Gson gson = new Gson();
                        list = gson.fromJson(response.body(), new TypeToken<List<CourseListBean>>() {
                        }.getType());


                    }
                });

    }
    //////////////////////////////
    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
        return 0;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

        getDatas();
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }


    private void loginByQQ() {
        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        qq.setPlatformActionListener(this);
        qq.SSOSetting(false);
        if (!qq.isClientValid()) {
            Toast.makeText(this, "QQ未安装,请先安装QQ", Toast.LENGTH_SHORT).show();
        }
        authorize(qq);
    }



    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Platform platform = (Platform) msg.obj;
                    String userId = platform.getDb().getUserId();//获取用户账号
                    String userName = platform.getDb().getUserName();//获取用户名字
                    String userIcon = platform.getDb().getUserIcon();//获取用户头像
                    String userGender = platform.getDb().getUserGender(); //获取用户性别，m = 男, f = 女，如果微信没有设置性别,默认返回null
                    startActivity(Main2Activity.class);
                    SpUtil.setBoolean("login",true);
                    finish();

                    break;
                case 2:
                    Toast.makeText(LoginActivity.this, "授权登陆失败", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(LoginActivity.this, "授权登陆取消", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


    private void authorize(Platform platform) {
        if (platform == null) {
            return;
        }
        if (platform.isAuthValid()) {  //如果授权就删除授权资料
            platform.removeAccount(true);
        }
        platform.showUser(null); //授权并获取用户信息
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        Message message = Message.obtain();
        message.what = 1;
        message.obj = platform;
        mHandler.sendMessage(message);
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        Message message = Message.obtain();
        message.what = 2;
        message.obj = platform;
        mHandler.sendMessage(message);
    }

    @Override
    public void onCancel(Platform platform, int i) {
        Message message = Message.obtain();
        message.what = 3;
        message.obj = platform;
        mHandler.sendMessage(message);
    }
}
