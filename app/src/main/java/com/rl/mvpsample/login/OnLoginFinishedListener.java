package com.rl.mvpsample.login;

public interface OnLoginFinishedListener {

    void onUsernameError();

    void onPasswordError();

    void onSuccess();


}
