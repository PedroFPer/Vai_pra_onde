package com.ducks.vai_pra_onde.Geral.TelasFront;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.ducks.vai_pra_onde.Geral.DTO.CadasPessoPfDTO;
import com.ducks.vai_pra_onde.Geral.Service.ServiceCadastro;
import com.ducks.vai_pra_onde.R;
import com.ducks.vai_pra_onde.Geral.Utilidades.UtilVericCreden;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadasPf extends AppCompatActivity {
    private EditText email, telefone, senha, nome, dataNasc;

    UtilVericCreden utilVericCreden = new UtilVericCreden();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadas_pf);



        email = findViewById(R.id.email);
        telefone = findViewById(R.id.tel);
        senha = findViewById(R.id.senha);
        nome = findViewById(R.id.nome);
        dataNasc= findViewById(R.id.data);



    }

    public void cadastrar (View v){
        String emailst = email.getText().toString().trim();
        String telefonest = telefone.getText().toString().trim();
        String senhast = senha.getText().toString().trim();
        String nomest = nome.getText().toString().trim();
        String dataNascStr = dataNasc.getText().toString().trim();
        Date dataFormatadest;


        if(emailst.isEmpty()){
            Toast.makeText(this, "O e-mail não pode estar vazio.", Toast.LENGTH_SHORT).show();
            return;

        }
        if(telefonest.isEmpty() ){
            Toast.makeText(this, "O telefone não pode estar vazio.", Toast.LENGTH_SHORT).show();
            return;
        }else if (!utilVericCreden.vericTelef(telefonest)) {
            Toast.makeText(this, "O telefone deve conter 13 numeros!", Toast.LENGTH_SHORT).show();
            return;
        }



        if(senhast.isEmpty()){
            Toast.makeText(this, "A senha não pode estar vazio.", Toast.LENGTH_SHORT).show();
            return;
        }else if (!utilVericCreden.vericSenha(senhast)){
            Toast.makeText(this, "A senha deve conter 8 caracteres!", Toast.LENGTH_SHORT).show();
            return;
        }


        if(nomest.isEmpty()){
            Toast.makeText(this, "O nome não pode estar vazio.", Toast.LENGTH_SHORT).show();
            return;

        }
        if (dataNascStr.isEmpty()) {
            Toast.makeText(this, "Data de nascimento não pode está vazio!", Toast.LENGTH_SHORT).show();
            return;
        }else{
            try {
                SimpleDateFormat formatadorData = new SimpleDateFormat("yyyy-mm-dd");
                dataFormatadest = formatadorData.parse(dataNascStr);

                if(!utilVericCreden.vericDataVal(dataFormatadest)){
                    Toast.makeText(this, "Data invalida!  Por favor, tente novamente!", Toast.LENGTH_SHORT).show();
                }

                if(!utilVericCreden.vericIdade(dataFormatadest)){
                    Toast.makeText(this, "Idade inválida! É necessario ter pelo menos 16 anos!", Toast.LENGTH_SHORT).show();
                    return;
                }
            } catch (ParseException e){
                Toast.makeText(this, "Formato invalido!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        CadasPessoPfDTO cadasPessoPfDTO = new CadasPessoPfDTO(nomest, emailst, telefonest, senhast,dataFormatadest);

        ServiceCadastro  serviceCadastro = new ServiceCadastro();

        boolean vericCadastro= serviceCadastro.serviceCadastroPf(cadasPessoPfDTO);

        if(!vericCadastro){
            Toast.makeText(this, "Ocorreu um problema no cadastro, por favor tente novamente!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(TelaCadasPf.this, TelaCadasTipCli.class);
        startActivity(intent);


        

    }

}