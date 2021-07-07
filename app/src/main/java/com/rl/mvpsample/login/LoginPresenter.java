package com.rl.mvpsample.login;

public class LoginPresenter implements OnLoginFinishedListener  {

    LoginView loginView;
    LoginInteractor loginInteractor;


    LoginPresenter(LoginView loginView,LoginInteractor loginInteractor){

        this.loginView = loginView;
        this.loginInteractor= loginInteractor;
    }

    public void validateCredentials(String username,String password){

        if (loginView!= null) {
            loginView.showProgress();
        }

        loginInteractor.login(username,password,this);
    }

    public void onDestroy(){
        loginView = null;
    }




    @Override
    public void onUsernameError() {
        if (loginView != null){
            loginView.setUsernameError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onPasswordError() {
        if (loginView != null){
            loginView.setPasswordError();
            loginView.hideProgress();
        }


    }

    @Override
    public void onSuccess() {
        if (loginView != null){

            loginView.navigateToHome();
        }


    }
}
