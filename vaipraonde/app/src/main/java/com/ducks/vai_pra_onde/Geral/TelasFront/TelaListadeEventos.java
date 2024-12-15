    package com.ducks.vai_pra_onde.Geral.TelasFront;

    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.LinearLayout;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;
    import androidx.lifecycle.ViewModelProvider;

    import com.ducks.vai_pra_onde.Geral.FragmeViewModel.FragmeSessaoPessoaPJViewModel;
    import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
    import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
    import com.ducks.vai_pra_onde.R;

    import java.util.ArrayList;

    public class TelaListadeEventos extends Fragment {

        private LinearLayout eventContainer;
        private TextView noEventMessage;
        private PessoaPJ pessoaPJ;
        private FragmeSessaoPessoaPJViewModel viewModelSessaoPJ;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_lista_de_eventos, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            Button buttonCadasEven = view.findViewById(R.id.btn_criar_evento);

            eventContainer = view.findViewById(R.id.eventContainer);
            noEventMessage = view.findViewById(R.id.noEventMessage);

            viewModelSessaoPJ = new ViewModelProvider(requireActivity()).get(FragmeSessaoPessoaPJViewModel.class);

            ArrayList<Eventos> listaEventos = viewModelSessaoPJ.getListaEventos();



            eventContainer.removeAllViews();

            if (listaEventos != null) {
                noEventMessage.setVisibility(View.GONE);

                for (Eventos evento : listaEventos) {
                    View eventoView = getLayoutInflater().inflate(R.layout.activity_item_evento, eventContainer, false);


                    TextView eventoNome = eventoView.findViewById(R.id.eventName);
                    TextView eventoHorario = eventoView.findViewById(R.id.eventTime);

                    eventContainer.addView(eventoView);
                }
            } else {

                noEventMessage.setVisibility(View.VISIBLE);
            }

            buttonCadasEven.setOnClickListener(v->{
                if (getActivity() != null) {
                    AppCompatActivity activity = (AppCompatActivity) getActivity();

                    activity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragSessaoPJ, new TelaCadastroEvento())
                            .addToBackStack(null)
                            .commit();
                }

            });
        }





    }
