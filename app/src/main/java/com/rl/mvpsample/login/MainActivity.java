package com.rl.mvpsample.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.rl.mvpsample.R;

public class MainActivity extends AppCompatActivity implements LoginView{

    EditText username;
    EditText password;
    ProgressBar progressBar;

    LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.tv_username);
        password = findViewById(R.id.tv_password);
        progressBar = findViewById(R.id.progress);



        findViewById(R.id.btn_login).setOnClickListener(view -> validateCredentials());


        loginPresenter = new LoginPresenter(this,new LoginInteractor());


    }


    private void validateCredentials(){

        loginPresenter.validateCredentials(username.getText().toString(),password.getText().toString());

    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void setUsernameError() {

        username.setError("UserName cannot be Empty");

    }

    @Override
    public void setPasswordError() {

        password.setError("Password cannot be Empty");

    }

    @Override
    public void navigateToHome() {

        startActivity(new Intent(this,MainActivity.class));
        finish();



    }
}