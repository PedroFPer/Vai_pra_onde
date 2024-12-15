    package com.ducks.vai_pra_onde.Geral.TelasFront;

    import static com.google.android.material.internal.ViewUtils.dpToPx;

    import android.annotation.SuppressLint;
    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.inputmethod.EditorInfo;
    import android.widget.Button;
    import android.widget.EditText;
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

        private EditText editItemEvent;
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
            //editItemEvent = view.findViewById(R.id.item_evento);

            viewModelSessaoPJ = new ViewModelProvider(requireActivity()).get(FragmeSessaoPessoaPJViewModel.class);

            ArrayList<Eventos> listaEventos = viewModelSessaoPJ.getListaEventos();
            PessoaPJ pessoaPJ = viewModelSessaoPJ.getPessoaPJ();

            float density = getResources().getDisplayMetrics().density;



            //Codigo de teste, quando consiguir cadastra os eventos pode apagar
            ArrayList<String> teste = new ArrayList<>();
            teste.add("Teste 1");
            teste.add("Teste 2");


            if (teste != null) {
                int largura = (int) (330 * density);
                int altura = (int) (70 * density);

                noEventMessage.setVisibility(View.GONE);
                for (String s : teste) {
                    View eventoView = getLayoutInflater().inflate(R.layout.activity_item_evento, eventContainer, false);

                    EditText itemEvento = new EditText(getActivity());


                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(largura, altura);

                    itemEvento.setBackgroundResource(R.drawable.caixa);
                    itemEvento.setPadding(10, 10, 10, 10);
                    itemEvento.setText("Nome: " + teste);
                    itemEvento.setTextColor(getResources().getColor(R.color.dark_gray));
                    itemEvento.setTextSize(18);
                    itemEvento.setImeOptions(EditorInfo.IME_ACTION_NEXT);


                    eventContainer.addView(itemEvento);
                    }
                }else{
                    editItemEvent.setVisibility(View.INVISIBLE);
                    noEventMessage.setVisibility(View.VISIBLE);
                }

            //If principal, que vai ser usado quando o array de eventos forem atualizados

            /*if (listaEventos != null) {

                int largura = (int) (330 * density);
                int altura = (int) (70 * density);

                noEventMessage.setVisibility(View.GONE);

                for (Eventos evento : listaEventos) {
                    View eventoView = getLayoutInflater().inflate(R.layout.activity_item_evento, eventContainer, false);


                    EditText itemEvento = new EditText(getActivity());

                    // Define as propriedades do EditText
                   LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(largura, altura);


                    ));
                    itemEvento.setBackgroundResource(R.drawable.caixa); // Definindo o background
                    itemEvento.setPadding(10, 10, 10, 10); // Definindo o padding
                    itemEvento.setText(evento.getDataEvento() + "|" + evento.getNomeEvento()); // Definindo o texto com base no item da lista
                    itemEvento.setTextColor(getResources().getColor(R.color.dark_gray)); // Cor do texto
                    itemEvento.setTextSize(18);
                    itemEvento.setImeOptions(EditorInfo.IME_ACTION_NEXT); // Definir o botão "next" no teclado

                    // Adiciona o EditText ao container (LinearLayout)
                    eventContainer.addView(itemEvento);

                    eventContainer.addView(eventoView);
                }
            } else {
                editItemEvent.setVisibility(View.INVISIBLE);
                noEventMessage.setVisibility(View.VISIBLE);
            }*/

                buttonCadasEven.setOnClickListener(v -> {
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



