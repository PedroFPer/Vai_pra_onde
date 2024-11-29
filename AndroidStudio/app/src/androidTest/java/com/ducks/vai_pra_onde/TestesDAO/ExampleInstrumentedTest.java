package com.ducks.vai_pra_onde.TestesDAO;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.CollectionReference;
import org.junit.Before;
import org.junit.Test;
import com.ducks.vai_pra_onde.Geral.DAO.PessoaFisica.PessoaFisicaDAO;
import static org.junit.Assert.*;

// teste de pessoaFisica
public class ExampleInstrumentedTest {
    @Test
    public void testCadastrarPessoaFisica_real() {
        String nome = "Sayd";
        String dataNascimento = "2003-04-30";
        String email = "say@hotmail.com";
        String telefone = "75999897394";
        String senha = "aquiles&aurora";
        PessoaFisicaDAO.cadastrarPessoaFisica(nome, dataNascimento, email, telefone, senha);
    }
}
