package com.thorn.wego.Translation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.thorn.wego.Element.TranslationJson;
import com.thorn.wego.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranslationActivity extends AppCompatActivity {
    private Spinner translationSpinner;
    private List<String> translationMode;
    private EditText origin, result;
    private Button submitTranslation;
    private TranslationJson translationJson = new TranslationJson();
    private int translationModeSelected;
    private Matcher originMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translation);
        submitTranslation = (Button) findViewById(R.id.translation_submit);
        origin = (EditText) findViewById(R.id.translation_origin);
        result = (EditText) findViewById(R.id.translation_result);
        translationSpinner = (Spinner) findViewById(R.id.translation_spinner);

        submitTranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pattern chineseP = Pattern.compile("[\u4e00-\u9fa5]");
                Pattern englishP = Pattern.compile("[A-Za-z]");
                if(translationModeSelected==0){
                    originMatch = chineseP.matcher(origin.getText().toString());
                }else{
                    originMatch = englishP.matcher(origin.getText().toString());
                }

                // 匹配到相同语言直接输出
                if(!originMatch.matches()){
                    String translationUrl = formatUrl(origin.getText().toString());
                    if(translationUrl!=null){
                        sendRequest(translationUrl);
                        if(translationJson.getTrans_result()!=null){
                            result.setText(translationJson.getTrans_result().get(0).getDst());
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"Service is not available",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    result.setText(origin.getText());
                }

            }
        });

        translationMode = new ArrayList<String>();
        translationMode.add("English -> Chinese");
        translationMode.add("Chinese -> English");
        final ArrayAdapter<String> translationListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, translationMode);
        translationListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        translationSpinner.setAdapter(translationListAdapter);

        translationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                translationModeSelected = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private String formatUrl(String query){
        String sign = MD5(getResources().getString(R.string.translation_appid) + query +
                getResources().getString(R.string.translation_salt) + getResources().getString(R.string.translation_key));
        try{
            if(sign!=null){
                if(translationModeSelected==0){
                    String url = getResources().getString(R.string.translation_url) + "?q=" + URLEncoder.encode(query,"utf-8") +
                            "&from="+ URLEncoder.encode("en","utf-8") + "&to=" + URLEncoder.encode("zh","utf-8") +
                            "&appid=" + URLEncoder.encode(getResources().getString(R.string.translation_appid),"utf-8") +
                            "&salt=" + URLEncoder.encode(getResources().getString(R.string.translation_salt),"utf-8") + "&sign=" + URLEncoder.encode(sign,"utf-8");
                    return url;
                }else{
                    String url = getResources().getString(R.string.translation_url) + "?q=" + URLEncoder.encode(query,"utf-8") +
                            "&from="+ URLEncoder.encode("zh","utf-8") + "&to=" + URLEncoder.encode("en","utf-8") +
                            "&appid=" + URLEncoder.encode(getResources().getString(R.string.translation_appid),"utf-8") +
                            "&salt=" + URLEncoder.encode(getResources().getString(R.string.translation_salt),"utf-8") + "&sign=" + URLEncoder.encode(sign,"utf-8");
                    return url;
                }
            }
        }catch (Exception e){
            return null;
        }
        return null;

    }
    private void sendRequest(final String url){
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpURLConnection connection = null;
                    try{

                        URL format_url = new URL(url);
                        connection = (HttpURLConnection) format_url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(5000);

                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while((line = reader.readLine()) != null){
                            response.append(line);
                        }
                        translationJson = (TranslationJson) new Gson().fromJson(response.toString(),TranslationJson.class);

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        if(connection != null){ connection.disconnect(); }
                    }
                }
            });
            thread.start();
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str).toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }
}
