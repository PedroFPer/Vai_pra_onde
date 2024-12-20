package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.ducks.vai_pra_onde.Geral.FragmeViewModel.FragmeCadasPessoPjViewModel;
import com.ducks.vai_pra_onde.Geral.FragmeViewModel.FragmeSessaoPessoaPJViewModel;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.R;

import java.util.ArrayList;

public class TelaGeralSessaoPJ extends AppCompatActivity {
    private FragmeSessaoPessoaPJViewModel viewModelSessaoPJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_geral_sessao_pj);

        ArrayList<Eventos> listaEventosRecebida = getIntent().getParcelableArrayListExtra("listaEventos");
        PessoaPJ pessoaPJ = getIntent().getParcelableExtra("pessoaJuridica");
        String fragmentShow = getIntent().getStringExtra("FragmentoShow");



        viewModelSessaoPJ = new ViewModelProvider(this).get(FragmeSessaoPessoaPJViewModel.class);

        viewModelSessaoPJ.setListaEventos(listaEventosRecebida);
        viewModelSessaoPJ.setPessoaPJ(pessoaPJ);

        if (savedInstanceState == null) {
            if(fragmentShow.equals("PerfilEmpresa")) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragSessaoPJ, new PerfilEmpresa())
                        .commit();

            } else if (fragmentShow.equals("ListaPessoa")) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragSessaoPJ, new TelaListadeEventos())
                        .commit();
            }
        }

    }

}
