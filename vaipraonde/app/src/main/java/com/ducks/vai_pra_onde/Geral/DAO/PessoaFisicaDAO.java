package com.ducks.vai_pra_onde.Geral.DAO;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.concurrent.CountDownLatch;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
public class PessoaFisicaDAO {
    /* LEIA:
    o metodo "cadastrarPF" possui a atual estrutura vista abaixo temporariamente
    a estrutura atual deve-se aos testes de comunicacao com o banco de dados, e posteriormente
    sofrera mudancas para a estruturacao CORRETA de classes DAO
     */
    public static void cadastrarPF(String nome, String data_nascimento, String email, String telefone, String senha) {
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
    }
}