package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView data_dia=findViewById(R.id.data_dia_cad);
    TextView data_mes=findViewById(R.id.data_mes_cad);
    TextView data_ano=findViewById(R.id.data_ano_cad);
    TextView horario_hora =findViewById(R.id.horario_evento_cad_hora);
    TextView horario_minuto=findViewById(R.id.horario_do_evento_cad_min);
    TextView cidade=findViewById(R.id.endereco_cidade_cad);
    TextView bairro=findViewById(R.id.endereco_bairro_cad);
    TextView rua=findViewById(R.id.endereco_logradouro_cad);
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
            String nome_evento_edit = nome_evento.getText().toString().trim();
            String nome_da_empresa_edit = nome_da_empresa.getText().toString().trim();
            String descricao_edit = descricao.getText().toString().trim();

            Integer data_dia_edit = Integer.parseInt(data_dia.getText().toString().trim());
            Integer data_mes_edit = Integer.parseInt(data_mes.getText().toString().trim());
            Integer data_ano_edit = Integer.parseInt(data_ano.getText().toString().trim());

            Integer horario_hora_edit = Integer.parseInt(horario_hora.getText().toString().trim());
            Integer horario_minuto_edit = Integer.parseInt(horario_minuto.getText().toString().trim());

            String cidade_edit = cidade.getText().toString().trim();
            String bairro_edit = bairro.getText().toString().trim();
            String rua_edit = rua.getText().toString().trim();

            if (nome_evento_edit.isEmpty()) {
                Toast.makeText(this, "Nome do evento não pode estar vazio!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (nome_da_empresa_edit.isEmpty()) {
                Toast.makeText(this, "Nome da empresa não pode estar vazio!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (descricao_edit.isEmpty()) {
                Toast.makeText(this, "Descrição não pode estar vazia!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (data_dia_edit == null || data_dia_edit < 1 || data_dia_edit > 31) {
                Toast.makeText(this, "Dia do evento inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (data_mes_edit == null || data_mes_edit < 1 || data_mes_edit > 12) {
                Toast.makeText(this, "Mês do evento inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (data_ano_edit == null || data_ano_edit < 1900 || data_ano_edit > 2100) {
                Toast.makeText(this, "Ano do evento inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (horario_hora_edit == null || horario_hora_edit < 0 || horario_hora_edit > 23) {
                Toast.makeText(this, "Hora do evento inválida!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (horario_minuto_edit == null || horario_minuto_edit < 0 || horario_minuto_edit > 59) {
                Toast.makeText(this, "Minuto do evento inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (cidade_edit.isEmpty()) {
                Toast.makeText(this, "Cidade não pode estar vazia!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (bairro_edit.isEmpty()) {
                Toast.makeText(this, "Bairro não pode estar vazio!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (rua_edit.isEmpty()) {
                Toast.makeText(this, "Rua não pode estar vazia!", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }
}