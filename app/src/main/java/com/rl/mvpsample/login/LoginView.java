package com.rl.mvpsample.login;

public interface LoginView {


    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

}
