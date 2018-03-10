package com.example.omerveberna.pastam;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    private Button buttonGiris,buttonKaydol;
    private EditText etUyeEmail, etUyeParola;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        auth=FirebaseAuth.getInstance();

        etUyeEmail= (EditText)findViewById(R.id.etUyeEmail);
        etUyeParola = (EditText)findViewById(R.id.etUyeParola);
        buttonGiris=(Button)findViewById(R.id.buttonGiris);
        buttonKaydol=(Button)findViewById(R.id.buttonKaydol) ;

        buttonKaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etUyeEmail.getText().toString();
                String parola = etUyeParola.getText().toString();


                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Lütfen emailinizi giriniz",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(parola)){
                    Toast.makeText(getApplicationContext(),"Lütfen parolanızı giriniz",Toast.LENGTH_SHORT).show();
                }
                if (parola.length()<6){
                    Toast.makeText(getApplicationContext(),"Parola en az 6 haneli olmalıdır",Toast.LENGTH_SHORT).show();
                }
                auth.createUserWithEmailAndPassword(email,parola).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //İşlem başarısız olursa kullanıcıya bir Toast mesajıyla bildiriyoruz.
                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Yetkilendirme Hatası",
                                    Toast.LENGTH_SHORT).show();
                        }

                        //İşlem başarılı olduğu takdir de giriş yapılıp MainActivity e yönlendiriyoruz.
                        else {
                            Toast.makeText(getApplicationContext(),"Kayıt oldunuz!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });





    }
}
