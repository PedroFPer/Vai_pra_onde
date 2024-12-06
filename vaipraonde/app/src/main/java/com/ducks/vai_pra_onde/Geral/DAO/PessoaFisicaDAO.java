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
    public static CompletableFuture<Boolean> cadastrar(PessoaFisicaTEST pessoaSERVICE) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<Boolean> future = new CompletableFuture<>();
        Map<String, Object> pessoaFisica = new HashMap<>();
        pessoaFisica.put("nome", pessoaSERVICE.getNome());
        pessoaFisica.put("data_nascimento", pessoaSERVICE.getData());
        pessoaFisica.put("email", pessoaSERVICE.getEmail());
        pessoaFisica.put("telefone", pessoaSERVICE.getTelefone());
        pessoaFisica.put("senha", pessoaSERVICE.getSenha());

        connection.collection("PessoaFisica").add(pessoaFisica)
                .addOnSuccessListener(documentoCriado -> {
                    future.complete(true);
                })
                .addOnFailureListener(e -> {
                    future.complete(false);
                });
        return future;
    }

    public static CompletableFuture<PessoaFisicaTEST> buscar(String email) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<PessoaFisicaTEST> future = new CompletableFuture<>();

        connection.collection("PessoaFisica").whereEqualTo("email", email).get()
                .addOnSuccessListener(documentosQUERY -> {
                    if(!documentosQUERY.isEmpty()) {
                        DocumentSnapshot documento =documentosQUERY.getDocuments().get(0);
                        PessoaFisicaTEST pessoaSERVICE = new PessoaFisicaTEST(documento.getString("nome"), documento.getDate("data_nascimento"),
                                documento.getString("email"), documento.getString("senha"), documento.getString("telefone"));
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

    /*public static CompletableFuture<Boolean> editar(String email, String novoEmail, String novaSenha) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<Boolean> future = new CompletableFuture<>();

    }*/

    /*public static CompletableFuture<Boolean> deletar(String email) {
        // deletar PF
    } */
}