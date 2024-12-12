package com.ducks.vai_pra_onde.Geral.TelasFront;

import static android.app.PendingIntent.getActivity;
import static java.security.AccessController.getContext;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.Geral.Utilidades.UtilArmazenImage;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.Geral.novaSERVICE.LoginSERVICE;
import com.ducks.vai_pra_onde.R;

import java.io.IOException;
import java.util.ArrayList;

import com.ducks.vai_pra_onde.novaDTO.PessoaPj;

public class PerfilEmpresa extends AppCompatActivity {
    private TextView nom;
    private TextView emai;
    private TextView ender;
    private TextView desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil_empresa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Eventos> listaUsuarios = getIntent().getParcelableArrayListExtra("listaUsuarios");
        PessoaPJ pessoaPJ = getIntent().getParcelableExtra("pessoaJuridica");



        nom = findViewById(R.id.nome);
        emai = findViewById(R.id.email);
        ender = findViewById(R.id.ende);

        nom.setText(pessoaPJ.getNomeEmpresa());
        emai.setText(pessoaPJ.getEmail());
        ender.setText(pessoaPJ.getLogradouro());


    }
}