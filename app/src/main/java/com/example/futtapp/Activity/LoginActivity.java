package com.example.futtapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.futtapp.Entidades.Usuario;
import com.example.futtapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private EditText txtCorreo,txtpassword;
    private Button btnLogin,btnRegistro;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtCorreo = (EditText) findViewById(R.id.idCorreoLogin);
        txtpassword = (EditText) findViewById(R.id.idContraseñaLogin);
        btnLogin = (Button) findViewById(R.id.idLoginLogin);
        btnRegistro = (Button) findViewById(R.id.idRegistroLogin);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = txtCorreo.getText().toString();
                if(isValidEmail(correo) && validarContraseña()){
                    String password = txtpassword.getText().toString();
                    mAuth.signInWithEmailAndPassword(correo, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(LoginActivity.this, "Se logeo correctamente.", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this,PrincipalRoom.class);
                                startActivity(i);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LoginActivity.this, "Error, credenciales incorrectas.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(LoginActivity.this, "Validaciones funcionando.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegistroActivity.class));
            }
        });
    }

    public boolean validarContraseña(){
        String password;
        password = txtpassword.getText().toString();
        if(password.length()>=6 && password.length()<=16){
            return true;
        }else return false;
    }
    @Override
    public void onResume() {
        super.onResume();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null) {
            Intent i = new Intent(LoginActivity.this,PrincipalRoom.class);
            startActivity(i);
            finish();
        }
    }


    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}