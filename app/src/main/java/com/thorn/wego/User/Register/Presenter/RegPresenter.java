package com.thorn.wego.User.Register.Presenter;

import android.os.Handler;
import android.os.Looper;

import com.thorn.wego.User.Register.Model.IRegUser;
import com.thorn.wego.User.Register.Model.RegUser;
import com.thorn.wego.User.Register.View.IRegView;

public class RegPresenter implements IRegPresenter {
    private IRegView iRegView;
    private IRegUser iRegUser;
    private Handler handler;

    public RegPresenter(IRegView iRegView){
        this.iRegView = iRegView;
        iRegUser = new RegUser(null,null,null,null);
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doRegister(String username, String password, String repeat, String email, String url){
        iRegUser.setUsername(username);
        iRegUser.setPassword(password);
        iRegUser.setRepeat(repeat);
        iRegUser.setEmail(email);

        final int code = iRegUser.handleRegister(url);

        handler.post(new Runnable() {
            @Override
            public void run() {
            if(iRegUser.getRegisterCode()!=null && iRegUser.getRegisterCode().equals("OK")){
                iRegView.onRegisterResult(1, iRegUser.getRegisterText());
            }else{
                iRegView.onRegisterResult(0, iRegUser.getRegisterText());
            }
            }
        });
    }
}
