package br.com.opet.tds.InterDisciplinar.FirebaseLogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import br.com.opet.tds.InterDisciplinar.R;

public class CadastroLoginActivity extends Activity {

    private EditText edtCadNome;
    private EditText edtCadEmail;
    private EditText edtCadSenha;
    private EditText edtCadConfirmaSenha;
    private Button btnGravar;
    private Usuarios usuarios;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);


        edtCadNome = (EditText)findViewById(R.id.edtCadNome);
        edtCadEmail = (EditText)findViewById(R.id.edtCadEmail);
        edtCadSenha = (EditText)findViewById(R.id.edtCadSenha);
        edtCadConfirmaSenha = (EditText)findViewById(R.id.edtCadConfirmarSenha);
        btnGravar = (Button)findViewById(R.id.btnGravar);


        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtCadSenha.getText().toString().equals(edtCadConfirmaSenha.getText().toString())){
                    usuarios = new Usuarios();
                    usuarios.setNome(edtCadNome.getText().toString());
                    usuarios.setEmail(edtCadEmail.getText().toString());
                    usuarios.setSenha(edtCadSenha.getText().toString());

                    cadastrarUsuario();


                }else {
                    Toast.makeText(CadastroLoginActivity.this, "Senhas não coincidem!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void cadastrarUsuario(){

        autenticacao = ConfigFireBase.getFirebaseAutenticaçao();
        autenticacao.createUserWithEmailAndPassword(
                usuarios.getEmail(),
                usuarios.getSenha()
        ).addOnCompleteListener(CadastroLoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CadastroLoginActivity.this, "Usuario cadastrado com sucesso!",Toast.LENGTH_LONG).show();

                    String identificadorUsuario = Base64Custom.codificarBase64(usuarios.getEmail());
                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuarios.setId(identificadorUsuario);
                    usuarios.salvar();

                    Preferencias preferencias = new Preferencias(CadastroLoginActivity.this);
                    preferencias.salvarUsuarioPreferencias(identificadorUsuario, usuarios.getNome());

                    abrirLoginUsuario();
                }else {
                    String erroExcecao = "";

                    try {

                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        erroExcecao = "Digite uma senha mais forte, contendo no minimo 8 caracteres de letras e números.";

                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erroExcecao = "O e-mail digitado é invalido, digite um novo e-mail.";

                    } catch (FirebaseAuthUserCollisionException e) {
                        erroExcecao = "Esse e-mail já está sendo usado.";

                    } catch (Exception e){
                        erroExcecao = "Erro ao efetuar o cadastro.";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroLoginActivity.this, "Erro: " + erroExcecao ,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void abrirLoginUsuario(){
        Intent intent = new Intent(CadastroLoginActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
