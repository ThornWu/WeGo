package com.thorn.wego.User.Login.Presenter;

import android.os.Handler;
import android.os.Looper;

import com.thorn.wego.User.Login.Model.ILoginUser;
import com.thorn.wego.User.Login.Model.LoginUser;
import com.thorn.wego.User.Login.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    private ILoginView iLoginView;
    private ILoginUser iLoginUser;
    private Handler handler;

    public LoginPresenter(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        // 刷新UI,需要主线程 looper
        iLoginUser = new LoginUser(null,null);
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLogin(String username, String password, String url){
        iLoginUser.setUsername(username);
        iLoginUser.setPassword(password);
        final int code = iLoginUser.checkUser(url);
        handler.post(new Runnable() {
            @Override
            public void run() {
            if(iLoginUser.getLoginCode()!=null && iLoginUser.getLoginCode().equals("OK")){
                iLoginView.onLoginResult(1, String.valueOf(iLoginUser.getUserId()));
            }else{
                iLoginView.onLoginResult(0, iLoginUser.getLoginText());
            }
            }
        });
    }
}
