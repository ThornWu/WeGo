package com.thorn.wego.Register.Presenter;

import android.os.Handler;
import android.os.Looper;

import com.thorn.wego.Register.Model.IRegUser;
import com.thorn.wego.Register.Model.RegUser;
import com.thorn.wego.Register.View.IRegView;

public class RegPresenter implements IRegPresenter {
    IRegView iRegView;
    IRegUser iRegUser;
    Handler handler;

    public RegPresenter(IRegView iRegView){
        this.iRegView = iRegView;
        iRegUser = new RegUser(null,null,null);
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public int handleRegisterResult(){
        return 0;
    }
}
