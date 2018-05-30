package com.thorn.wego.User.Login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.thorn.wego.User.Login.Presenter.ILoginPresenter;
import com.thorn.wego.User.Login.Presenter.LoginPresenter;
import com.thorn.wego.User.Login.View.ILoginView;
import com.thorn.wego.R;
import com.thorn.wego.User.Register.RegisterActivity;

public class LoginActivity extends Activity implements ILoginView, View.OnClickListener {
    private EditText usernameEdit,passwordEdit;
    private TextView loginToRegister;
    private Button loginButton;
    ILoginPresenter loginPresenter;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameEdit = (EditText) this.findViewById(R.id.login_username);
        passwordEdit = (EditText) this.findViewById(R.id.login_password);
        loginButton = (Button) this.findViewById(R.id.login_submit);
        loginToRegister = (TextView) this.findViewById(R.id.login_to_register);

        loginButton.setOnClickListener(this);
        loginToRegister.setOnClickListener(this);

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.login_submit){
            String url = getResources().getString(R.string.service_url) + "login";
            loginPresenter.doLogin(usernameEdit.getText().toString(),passwordEdit.getText().toString(), url);
        }else if(v.getId() == R.id.login_to_register){
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            this.finish();
        }
    }

    @Override
    public void onLoginResult(int isLoginSuccessful, String text){
        if (isLoginSuccessful == 1){
            sp = getSharedPreferences("User", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("userid",text);
            //TODO: 保证 Username 未被修改,通过禁用更改实现
            editor.putString("username",usernameEdit.getText().toString());
            editor.commit();
            this.finish();
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
