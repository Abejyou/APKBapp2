package com.example.apkbapp2.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.apkbapp2.CadastrarUsuarioActivity;
import com.example.apkbapp2.InserirFotoActivity;
import com.example.apkbapp2.R;
import com.example.apkbapp2.Usuario;
import com.example.apkbapp2.UsuarioHelper;

public class LoginFragment extends Fragment {
    private EditText txtLogin, txtSenha;
    private LoginViewModel loginViewModel;
    private Button btnLogin, btnCadastrar;
    private Usuario usuario = new Usuario();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        loginViewModel =
                ViewModelProviders.of( this ).get( LoginViewModel.class );
        View root = inflater.inflate( R.layout.fragment_login, null);
        final TextView textView = root.findViewById( R.id.textViewEsqueciSenha);
        txtLogin = root.findViewById( R.id.textInputEditTextLogin );
        txtSenha = root.findViewById( R.id.textInputEditTextSenha );
        btnLogin = root.findViewById( R.id.buttonLogin );
        btnCadastrar = root.findViewById( R.id.buttonCadastrar );
        loginViewModel.getText().observe( getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText( s );
            }
        } );
        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fazerLogin();
            }
        } );
        btnCadastrar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        } );
        return root;

    }
    public void fazerLogin(){
        UsuarioHelper usuarioHelper = new UsuarioHelper( getActivity() );

        if(txtLogin.getText().length()==0){
            txtLogin.setError( "Campo não pode ser vazio" );
            txtLogin.requestFocus();
        }
        if(txtSenha.getText().length()==0){
            txtSenha.setError( "Campo não pode ser vazio" );
            txtSenha.requestFocus();
        }
        else {
            String login = txtLogin.getText().toString();
            String senha = txtSenha.getText().toString();
            usuario = usuarioHelper.login( login, senha );
            System.out.println( usuario.getNomeUsuario() );
            if (usuario.getNomeUsuario() == null) {
                Toast.makeText( getActivity(), "Acesso Negado", Toast.LENGTH_LONG ).show();
            } else {
                Intent it = new Intent( getActivity(), InserirFotoActivity.class );
                startActivity( it );

            }
        }
    }
    public void cadastrarUsuario(){
        Intent it = new Intent( getActivity(), CadastrarUsuarioActivity.class );
        startActivity( it );
    }
}
