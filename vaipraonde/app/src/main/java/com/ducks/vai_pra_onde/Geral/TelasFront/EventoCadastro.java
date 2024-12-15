package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.Geral.SERVICE.EventoSERVICE;
import com.ducks.vai_pra_onde.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EventoCadastro extends AppCompatActivity {
    EditText nome_evento=findViewById(R.id.nome_evento_cad);
    EditText nome_da_empresa=findViewById(R.id.nome_da_empresa_cad);
    EditText descricao =findViewById(R.id.descricao_cad);
    EditText data_dia=findViewById(R.id.data_dia_cad);
    EditText data_mes=findViewById(R.id.data_mes_cad);
    EditText data_ano=findViewById(R.id.data_ano_cad);
    EditText horario_hora =findViewById(R.id.horario_evento_cad_hora);
    EditText horario_minuto=findViewById(R.id.horario_do_evento_cad_min);
    EditText cidade=findViewById(R.id.endereco_cidade_cad);
    EditText bairro=findViewById(R.id.endereco_bairro_cad);
    EditText Email=findViewById(R.id.Email_cad);
    EditText Telefone=findViewById(R.id.telefone_cad);
    EditText rua=findViewById(R.id.endereco_logradouro_cad);
    Button submit=findViewById(R.id.BtnSubmit);
    PessoaPJ empresa=(PessoaPJ) getIntent().getParcelableExtra("PessoaPJ");

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
            String email_edit = Email.getText().toString().trim();
            String telefone_edit = Telefone.getText().toString().trim();
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
            if (email_edit.isEmpty()) {
                Toast.makeText(this, "Email não pode estar vazio!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (telefone_edit.isEmpty()) {
                Toast.makeText(this, "Telefone não pode estar vazio!", Toast.LENGTH_SHORT).show();
                return;
            }
            //ESSA É A DATA QUE VAI SER PASSADA PARA A FUNÇÃO
            String data_completa = String.format("%02d/%02d/%04d", data_dia_edit, data_mes_edit, data_ano_edit);
            Date data_final = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                data_final = dateFormat.parse(data_completa);

                // Enviar data_final para o banco de dados
            } catch (ParseException e) {
                Toast.makeText(this, "Erro ao formatar a data!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                return;
            }
            Eventos evento= new Eventos(
                    nome_evento_edit,
                    nome_da_empresa_edit,
                    empresa.getCodigoDocumento(),
                    descricao_edit,
                    email_edit,
                    telefone_edit,
                    rua_edit,
                    bairro_edit,
                    cidade_edit,
                    null,
                    horario_hora_edit,
                    horario_minuto_edit,
                    data_final
                    );
            EventoSERVICE.cadastrarEvento(this,evento);

        });
    }
}