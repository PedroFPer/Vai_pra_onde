package com.ducks.vai_pra_onde.Geral.DAO;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.HashMap;
import com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.concurrent.CompletableFuture;
public class PessoaFisicaDAO {
    /* LEIA:
    o metodo "cadastrarPF" possui a atual estrutura vista abaixo temporariamente
    a estrutura atual deve-se aos testes de comunicacao com o banco de dados, e posteriormente
    sofrera mudancas para a estruturacao CORRETA de classes DAO
     */

    public static void cadastrar(PessoaFisicaTEST pessoaSERVICE) {
        FirebaseFirestore connection = ConnectionDB.connect();
        Map<String, Object> pessoaFisica = new HashMap<>();
        pessoaFisica.put("nome", pessoaSERVICE.getNome());
        pessoaFisica.put("data_nascimento", pessoaSERVICE.getData());
        pessoaFisica.put("email", pessoaSERVICE.getEmail());
        pessoaFisica.put("telefone", pessoaSERVICE.getTelefone());
        pessoaFisica.put("senha", pessoaSERVICE.getSenha());

        connection.collection("PessoaFisica").add(pessoaFisica)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

    }

    // exemplo de uso: PessoaFisicaTEST pessoaBuscada = buscarPorEmail(email).get();
    public static CompletableFuture<PessoaFisicaTEST> buscar(String email) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<PessoaFisicaTEST> future = new CompletableFuture<>();

        connection.collection("PessoaFisica").whereEqualTo("email", email).get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if(!queryDocumentSnapshots.isEmpty()) {
                        DocumentSnapshot document = queryDocumentSnapshots.getDocuments().get(0);
                        PessoaFisicaTEST pessoaSERVICE = new PessoaFisicaTEST(document.getString("nome"), document.getDate("data_nascimento"),
                        document.getString("email"), document.getString("senha"), document.getString("telefone"));
                        future.complete(pessoaSERVICE);
                    }
                    else {
                        future.complete(null);
                    }
                })
                .addOnFailureListener(e -> {
                    // excecao lancada quando ocorre um problema na busca
                    future.completeExceptionally(e);
                });
        return future;
    }

    /*public static void cadastrarPF(String nome, String data_nascimento, String email, String telefone, String senha) {
        FirebaseFirestore connection = ConnectionDB.connect();
        Map<String, Object> pessoaFisica = new HashMap<>();
        Date dataNascimentoSQL = null;

        try {
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            dataNascimentoSQL = formatador.parse(data_nascimento);
        } catch(ParseException e) {
            return;
        }

        //Timestamp dataNascimentoTimestamp = new Timestamp(dataNascimentoSQL);
        pessoaFisica.put("nome", nome);
        pessoaFisica.put("data_nascimento", dataNascimentoSQL);
        pessoaFisica.put("email", email);
        pessoaFisica.put("telefone", telefone);
        pessoaFisica.put("senha", senha);
        //final CountDownLatch latch = new CountDownLatch(1);

        connection.collection("PessoaFisica")
                .add(pessoaFisica)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        //latch.countDown();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        //latch.countDown();
                    }
                });
    }*/
}