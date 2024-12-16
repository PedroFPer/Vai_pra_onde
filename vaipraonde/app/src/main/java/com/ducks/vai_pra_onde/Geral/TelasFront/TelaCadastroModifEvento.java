    package com.ducks.vai_pra_onde.Geral.TelasFront;

    import android.annotation.SuppressLint;
    import android.content.Context;
    import android.os.Bundle;
    import android.util.Log;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    import com.ducks.vai_pra_onde.Geral.SERVICE.EventoSERVICE;
    import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
    import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
    import com.ducks.vai_pra_onde.R;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.Locale;

    public class TelaCadastroModifEvento extends AppCompatActivity {

        @SuppressLint("SetTextI18n")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_editar_evento);


            Eventos eventoAtual = getIntent().getParcelableExtra("evento");
            PessoaPJ pessoaPJ = getIntent().getParcelableExtra("pessoaJuridica");


            TextView nome_da_empresa =findViewById(R.id.nome_da_empresa_vw);
            TextView Email = findViewById(R.id.Email_vw);
            TextView Telefone =findViewById(R.id.telefone_vw);

            //Informações da empresa que podem ser modificadas
            EditText cidade = findViewById(R.id.endereco_cidade_vw);
            EditText bairro = findViewById(R.id.endereco_bairro_vw);
            EditText rua = findViewById(R.id.endereco_logradouro_vw);

            //Informações do evento
            EditText nome_evento = findViewById(R.id.nome_evento_vw);
            EditText descricao = findViewById(R.id.descricao_vw);
            EditText data_ano = findViewById(R.id.data_ano_vw);
            EditText data_mes = findViewById(R.id.data_mes_vw);
            EditText data_dia=findViewById(R.id.data_evento_vw);
            EditText horario_hora = findViewById(R.id.horario_do_evento_vw_hora);
            EditText horario_minuto = findViewById(R.id.horario_do_evento_vw_min);

            //Botão cadastro

            Button buttonEdit=findViewById(R.id.buttoEdit);

            Button buttonDele=findViewById(R.id.buttoDel);


            Date dataEvento = eventoAtual.getDataEvento();

            SimpleDateFormat diaFormatador = new SimpleDateFormat("dd", Locale.getDefault());
            SimpleDateFormat mesFormatador = new SimpleDateFormat("MM", Locale.getDefault());
            SimpleDateFormat anoFormatador = new SimpleDateFormat("yyyy", Locale.getDefault());


            String dia = diaFormatador.format(dataEvento);
            String mes = mesFormatador.format(dataEvento);
            String ano = anoFormatador.format(dataEvento);





            nome_da_empresa.setText(eventoAtual.getNomeEmpresa());
            Email.setText(pessoaPJ.getEmail());
            Telefone.setText(pessoaPJ.getTelefone());

            cidade.setText(pessoaPJ.getCidade());
            bairro.setText(pessoaPJ.getBairro());
            rua.setText(pessoaPJ.getLogradouro());



            //Informações do evento
             nome_evento.setText(eventoAtual.getNomeEvento());
             descricao.setText(eventoAtual.getDescricao());
             data_ano.setText(ano);
             data_mes.setText(mes);
             data_dia.setText(dia);


             horario_hora.setText(Integer.toString(eventoAtual.getHoraEvento()));
             horario_minuto.setText(Integer.toString(eventoAtual.getMinutoEvento()));


            buttonEdit.setOnClickListener(v -> {

                String nome_evento_edit = nome_evento.getText().toString().trim();
                String nome_da_empresa_edit = nome_da_empresa.getText().toString().trim();
                String descricao_edit = descricao.getText().toString().trim();
                String email_edit = Email.getText().toString().trim();
                String telefone_edit = Telefone.getText().toString().trim();

                String cidade_edit = cidade.getText().toString().trim();
                String bairro_edit = bairro.getText().toString().trim();
                String rua_edit = rua.getText().toString().trim();

                // Usando variáveis int para evitar valores nulos desnecessários
                int data_dia_edit ;
                int data_mes_edit ;
                int data_ano_edit ;
                int horario_hora_edit;
                int horario_minuto_edit;

                // Validação de dados numéricos
                try {
                    data_dia_edit = Integer.parseInt(data_dia.getText().toString().trim());
                    data_mes_edit = Integer.parseInt(data_mes.getText().toString().trim());
                    data_ano_edit = Integer.parseInt(data_ano.getText().toString().trim());
                    horario_hora_edit = Integer.parseInt(horario_hora.getText().toString().trim());
                    horario_minuto_edit = Integer.parseInt(horario_minuto.getText().toString().trim());
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Preencha todos os campos com números válidos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validações para garantir que os valores estejam dentro dos intervalos corretos
                if (data_dia_edit < 1 || data_dia_edit > 31) {
                    Toast.makeText(this, "Dia do evento inválido!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (data_mes_edit < 1 || data_mes_edit > 12) {
                    Toast.makeText(this, "Mês do evento inválido!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (data_ano_edit < 1900 || data_ano_edit > 2100) {
                    Toast.makeText(this, "Ano do evento inválido!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (horario_hora_edit < 0 || horario_hora_edit > 23) {
                    Toast.makeText(this, "Hora do evento inválida!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (horario_minuto_edit < 0 || horario_minuto_edit > 59) {
                    Toast.makeText(this, "Minuto do evento inválido!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validação dos campos de texto
                if (nome_evento_edit.isEmpty()) {
                    Toast.makeText(this, "Nome do evento não pode estar vazio!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (descricao_edit.isEmpty()) {
                    Toast.makeText(this, "Descrição não pode estar vazia!", Toast.LENGTH_SHORT).show();
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


                // Formatando a data corretamente
                @SuppressLint("DefaultLocale")
                String data_comple = String.format("%02d/%02d/%04d", data_dia_edit, data_mes_edit, data_ano_edit);

                Date data_final = null;

                try {
                    // Verificando se a data está corretamente formatada
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    data_final = dateFormat.parse(data_comple);

                    if (data_final != null) {
                    } else {
                        Toast.makeText(this, "Data inválida!", Toast.LENGTH_SHORT).show();
                    }

                } catch (ParseException e) {
                    Toast.makeText(this, "Erro ao formatar a data!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                    return;
                }



                // Criar o objeto Evento e enviar para o serviço
                /*Eventos eventoEditado = new Eventos(
                        nome_evento_edit,
                        nome_da_empresa_edit,
                        pessoaPJ.getCodigoDocumento(),
                        eventoAtual.getCodigoDocumento(),
                        descricao_edit,
                        email_edit,
                        telefone_edit,
                        rua_edit,
                        bairro_edit,
                        cidade_edit,
                        "Bahia",
                        horario_hora_edit,
                        horario_minuto_edit,
                        data_final
                );*/
                eventoAtual.setInformacoesEvento(nome_evento_edit,descricao_edit, data_final,horario_hora_edit, horario_minuto_edit);
                EventoSERVICE.editarEvento(this, eventoAtual);

            });

            buttonDele.setOnClickListener(v -> {
                EventoSERVICE.deletarEvento(this,eventoAtual);


            });

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

        }

    }