package com.teste.tutasqranio;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import library.DatabaseHandler;
import library.UserFunctions;

public class MainActivity extends Activity {
	
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_UID = "ID_USUARIO";
	private static String KEY_NAME = "NOME_USUARIO";
	private static String KEY_EMAIL = "NOME_EMAIL";
	
	Button btnLogin;
	EditText email;
	EditText senha;
	
	String emailUsuario;
	String senhaUsuario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnLogin = (Button) findViewById(R.id.btnLogin);
		email = (EditText) findViewById(R.id.textEmail);
		senha = (EditText) findViewById(R.id.textSenha);
		
		btnLogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				emailUsuario = email.getText().toString();
				senhaUsuario = senha.getText().toString();
				UserFunctions userFunction = new UserFunctions();
				Log.d("Button", "Loginteste");
				JSONObject json = userFunction.loginUser(emailUsuario, senhaUsuario);
				Log.d("Button", "Login");
				try {
					if (json.getString(KEY_SUCCESS) != null) {
						String res = json.getString(KEY_SUCCESS);
						if(Integer.parseInt(res) == 1){
							// user successfully logged in
							// Store user details in SQLite Database
							DatabaseHandler db = new DatabaseHandler(getApplicationContext());
							JSONObject json_user = json.getJSONObject("user");
							// Clear all previous data in database
							userFunction.logoutUser(getApplicationContext());
							db.addUser(json_user.getString(KEY_NAME), json_user.getString(KEY_EMAIL), json.getString(KEY_UID));
							// Launch Dashboard Screen
							Intent trocarTela = new Intent(getApplicationContext(), MenuActivity.class);
							
							// Close all views before launching Dashboard
							trocarTela.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(trocarTela);
							
							// Close Login Screen
							finish();
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
