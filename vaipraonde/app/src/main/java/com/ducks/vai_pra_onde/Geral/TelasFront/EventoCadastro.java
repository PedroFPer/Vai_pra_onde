package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.R;

public class EventoCadastro extends AppCompatActivity {
    TextView nome_evento=findViewById(R.id.nome_evento_cad);
    TextView nome_da_empresa=findViewById(R.id.nome_da_empresa_cad);
    TextView descricao =findViewById(R.id.descricao_cad);
    TextView data_evento=findViewById(R.id.data_evento_cad);
    TextView horario_evento=findViewById(R.id.horario_do_evento_cad);
    TextView endereco=findViewById(R.id.endereco_cad);
    Button submit=findViewById(R.id.BtnSubmit);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_evento_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);




            return insets;
        });
        submit.setOnClickListener(v->{
            String nome_evento_edit=nome_evento.getText().toString().trim();
            String nome_empresa_edit=nome_da_empresa.getText().toString().trim();
            String description_edit=descricao.getText().toString().trim();
            String horario_evento_edit=horario_evento.getText().toString().trim();
            String data_evento_edit=data_evento.getText().toString().trim();
            String endereco_edit=endereco.getText().toString().trim();
            if(nome_evento_edit.isEmpty()){
                Log.d("EventoCadastro","Adicione um nome para o Evento");
            }
            if(nome_empresa_edit.isEmpty()){
                Log.d("EventoCadastro","Adicione o nome da empresa");
            }
            if(horario_evento_edit.isEmpty()){
                Log.d("EventoCadastro","Adicione um Horario para o Evento");
            }
            if(endereco_edit.isEmpty()){
                Log.d("EventoCadastro","Adicione o endereco para o Evento");
            }
            if(data_evento_edit.isEmpty()){
                Log.d("EventoCadastro","Adicione uma Data para o Evento");

            }


        });
    }
}