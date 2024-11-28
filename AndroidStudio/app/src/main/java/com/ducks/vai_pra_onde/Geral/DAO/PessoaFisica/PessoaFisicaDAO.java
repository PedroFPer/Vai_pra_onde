/*package com.ducks.vai_pra_onde.Geral.DAO.PessoaFisica;
import java.util.Map;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// pacotes necessarios de conexao com o Firebase
import  com.ducks.vai_pra_onde.DAO.FirestoreDAO.FirestoreConnection;
import com.google.firebase.firestore.FirebaseFirestore;

public class PessoaFisicaDAO {
    public static void cadastrarPessoaFisica(String nome, String data_nascimento, String email, String telefone, String senha) {
        FirebaseFirestore connection = new FirestoreConnection.getConnection();

        Map<String, Object> pessoaFisica = new HashMap<>();

        // convertendo a data de String para tipo Date
        Date dataNascimentoSQL = null;
        try {
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            dataNascimentoSQL = formatador.parse(data_nascimento);
        } catch(ParseException e) {
            // exibir caixa de dialogo: "Data mal formatada!"
            return; // encerra o metodo prematuramente - sem enviar pro banco de dados
        }

        pessoaFisica.put("nome", nome);
        pessoaFisica.put("data_nascimento", dataNascimentoSQL); // o Firebase converte automaticamente Date -> TimesStamp
        pessoaFisica.put("email", email);
        pessoaFisica.put("telefone", telefone);
        pessoaFisica.put("senha", senha);

        //adiciona o documento gerado na collection "PessoaFisica"
        connection.collection("PessoaFisica").add(pessoaFisica);

        // o que falta:
        // exibir caixas de dialogo Android caso o cliente seja cadastrado com sucesso
        // e caso nao seja, usando os metodos 'addOnSuccessListener' e 'addOnFailureListener'
    }

    // public static PessoaFisicaMODEL buscarPessoaFisica(String email)
}*/