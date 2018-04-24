package com.thorn.wego.Login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thorn.wego.Login.Presenter.ILoginPresenter;
import com.thorn.wego.Login.Presenter.LoginPresenter;
import com.thorn.wego.Login.View.ILoginView;
import com.thorn.wego.R;

public class LoginActivity extends Activity implements ILoginView, View.OnClickListener {
    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button loginButton;
    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameEdit = (EditText) this.findViewById(R.id.login_username);
        passwordEdit = (EditText) this.findViewById(R.id.login_password);
        loginButton = (Button) this.findViewById(R.id.login_submit);

        loginButton.setOnClickListener(this);

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.login_submit){
            String url = getResources().getString(R.string.service_url) + "login";
            loginPresenter.doLogin(usernameEdit.getText().toString(),passwordEdit.getText().toString(), url);
        }
    }

    @Override
    public void onLoginResult(int isLoginSuccessful, String text){
        if (isLoginSuccessful == 1){
            Toast.makeText(this, "OK",Toast.LENGTH_SHORT).show();
        }
        else{
            if(text.length() != 0){
                Toast.makeText(this, text ,Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Service is not available" ,Toast.LENGTH_SHORT).show();
            }
        }
    }

}
