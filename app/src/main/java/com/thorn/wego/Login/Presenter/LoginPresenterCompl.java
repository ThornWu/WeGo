package com.thorn.wego.Login.Presenter;

import android.os.Handler;
import android.os.Looper;

import com.thorn.wego.Login.Model.IUser;
import com.thorn.wego.Login.Model.UserModel;
import com.thorn.wego.Login.View.ILoginView;

public class LoginPresenterCompl implements ILoginPresenter {
    ILoginView iLoginView;
    IUser iUser;
    Handler handler;

    public LoginPresenterCompl(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        // 刷新UI,需要主线程 looper
        iUser = new UserModel(null,null);
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLogin(String username, String password, String url){
        iUser.setUsername(username);
        iUser.setPassword(password);
        final int code = iUser.checkUser(url);
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(code == 0){
                    if(iUser.getLoginCode().equals("OK")){
                        iLoginView.onLoginResult(1, iUser.getLoginText());
                    }else{
                        iLoginView.onLoginResult(0, iUser.getLoginText());
                    }
                }else{
                    iLoginView.onLoginResult(0, "Please enter your username and password.");
                }
            }
        });
    }
}
