package com.thorn.wego.Register;

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

import com.thorn.wego.Login.LoginActivity;
import com.thorn.wego.R;
import com.thorn.wego.Register.Presenter.IRegPresenter;
import com.thorn.wego.Register.Presenter.RegPresenter;
import com.thorn.wego.Register.View.IRegView;

public class RegisterActivity extends Activity implements IRegView, View.OnClickListener{
    private EditText usernameEdit, passwordEdit, repeatEdit, emailEdit;
    private Button registerButton;
    private TextView registerToLogin;
    IRegPresenter regPresenter;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        usernameEdit = (EditText) this.findViewById(R.id.register_username);
        passwordEdit = (EditText) this.findViewById(R.id.register_password);
        repeatEdit =(EditText) this.findViewById(R.id.register_repeat);
        emailEdit = (EditText) this.findViewById(R.id.register_email);
        registerButton = (Button) this.findViewById(R.id.register_submit);
        registerToLogin = (TextView) this.findViewById(R.id.register_to_login);

        registerButton.setOnClickListener(this);
        registerToLogin.setOnClickListener(this);
        regPresenter = new RegPresenter(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.register_submit){
            String url = getResources().getString(R.string.service_url) + "register";
            regPresenter.doRegister(usernameEdit.getText().toString(),passwordEdit.getText().toString(),
                    repeatEdit.getText().toString(),emailEdit.getText().toString(),url);
        }else if(v.getId() == R.id.register_to_login){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            this.finish();
        }
    }

    @Override
    public void onRegisterResult(int isRegisterSuccessful, String text){
        if(isRegisterSuccessful == 1){
            Toast.makeText(this, text ,Toast.LENGTH_SHORT).show();
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
