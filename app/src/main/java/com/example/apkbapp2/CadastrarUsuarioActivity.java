package com.example.apkbapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.apkbapp2.ui.login.LoginFragment;

public class CadastrarUsuarioActivity extends AppCompatActivity {
    private EditText edtNome, edtUsuario, edtSenha, edtEmail;
    private Button btnSalvar;
    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cadastrar_usuario );

        edtNome = findViewById( R.id.edtNome );
        edtEmail = findViewById( R.id.edtEmail );
        edtUsuario = findViewById( R.id.edtUsuario );
        edtSenha = findViewById( R.id.edtSenha );

    }
    public void cadastrarUsuario(View v){
        if(edtUsuario.getText().length()==0){
            edtUsuario.setError( "Campo obrigatório" );
            edtUsuario.requestFocus();
        }
        if(edtSenha.getText().length()==0){
            edtSenha.setError( "Campo obrigatório" );
            edtSenha.requestFocus();
        }
        UsuarioHelper usuarioHelper = new UsuarioHelper( this );
        usuario.setNome( edtNome.getText().toString() );
        usuario.setEmail( edtEmail.getText().toString() );
        usuario.setNomeUsuario( edtUsuario.getText().toString() );
        usuario.setSenha( edtSenha.getText().toString() );
        usuarioHelper.inserirUsuario( usuario );
        Intent it = new Intent( this, LoginFragment.class );
        startActivity( it );
    }
}
