package com.example.semana6_2_jueves_room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import Beans.Usuarios;
import Interface.UsuarioDAO;
import dataBase.appDataBase;

public class MainActivity extends AppCompatActivity {

    EditText txtNom,txtCorreo,txtPas;
    Button btnGrabar,btnListar;
    TextView txtRes;

    List<Usuarios> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCorreo=findViewById(R.id.txtCorreo);
        txtNom=findViewById(R.id.txtNom);
        txtPas=findViewById(R.id.txtPass);

        btnGrabar=findViewById(R.id.btnGrabar);
        btnListar=findViewById(R.id.btnListar);

        txtRes=findViewById(R.id.txtRes);

        appDataBase db=appDataBase.getInstance(this.getApplicationContext());
        UsuarioDAO dao=db.usuariosDAO();

        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuarios usu=new Usuarios(txtNom.getText().toString(),
                        txtCorreo.getText().toString(),
                        txtPas.getText().toString());

                dao.insert(usu);

                txtCorreo.setText(null);
                txtPas.setText(null);
                txtNom.setText(null);

            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lista=dao.listaUsuarios();

                int can=lista.size();

                txtRes.setText("Cantidad de Registros: "+can+"\n");

                for(int i=0;i<lista.size();i++){
                    Usuarios u=lista.get(i);
                    txtRes.append("\nCodigo: "+u.getId()+
                            "\nNombre: "+u.getNombre()+
                            "\nCorreo: "+u.getCorreo()+
                            "\nPassword: "+u.getPass()+"\n");
                }

            }
        });

    }
}