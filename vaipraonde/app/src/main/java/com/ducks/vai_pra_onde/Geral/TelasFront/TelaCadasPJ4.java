package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ducks.vai_pra_onde.Geral.DTO.CadasPessoaPJDTO;
import com.ducks.vai_pra_onde.Geral.DTO.FragmeCadasPessoPjDTO;
import com.ducks.vai_pra_onde.Geral.Utilidades.UtilArmazenImage;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.Geral.novaSERVICE.CadastroSERVICE;
import com.ducks.vai_pra_onde.R;

import java.io.IOException;

public class TelaCadasPJ4 extends Fragment {

    private ImageView imageViewSelect;
    private String saveImagePath;
    private byte[] imagemData;

    private FragmeCadasPessoPjDTO viewModelPj;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar o layout do fragmento
        return inflater.inflate(R.layout.activity_tela_cadas_pj4, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelPj = new ViewModelProvider(requireActivity()).get(FragmeCadasPessoPjDTO.class);


        // Referências aos botões e ImageView
        Button buttonFinCadas = view.findViewById(R.id.buttonFinalCadas);
        Button buttonSelecIma = view.findViewById(R.id.buttonSelectImage);
        imageViewSelect = view.findViewById(R.id.imageView);

        UtilArmazenImage utilArmIma = new UtilArmazenImage(getContext());

        // ActivityResultLauncher para pegar a imagem
        ActivityResultLauncher<Intent> imagePickerLaucher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == getActivity().RESULT_OK && result.getData() != null){
                        Uri imagemUri = result.getData().getData();
                        try {
                            Bitmap bitMap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imagemUri);

                            saveImagePath = utilArmIma.saveImage(bitMap);

                            imagemData = utilArmIma.convertBitMapToByteArray(bitMap);

                            viewModelPj.setDocumAutecEmpr(imagemData);

                            imageViewSelect.setImageBitmap(bitMap);

                            Toast.makeText(getContext(), "Imagem salva em " + saveImagePath, Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            Toast.makeText(getContext(), "Erro ao processar a imagem", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


        buttonSelecIma.setOnClickListener(v -> {
            Intent intentUploImag = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            imagePickerLaucher.launch(intentUploImag);
        });

        buttonFinCadas.setOnClickListener(v -> {
            byte[] validImag = viewModelPj.getImageByteArrayView().getValue();

                if (validImag == null || validImag.length ==0) {
                    Toast.makeText(getContext(), "Adicione a imagem do documento de autetificação", Toast.LENGTH_SHORT).show();
                    return;
                    }

            PessoaPJ pessoaPJ = new PessoaPJ(
                    viewModelPj.getNomeEmpresa(),
                    viewModelPj.getResponsavel(),
                    viewModelPj.getCpfResponsavel(),
                    viewModelPj.getSenha(),
                    viewModelPj.getLogradouro(),
                    viewModelPj.getBairro(),
                    viewModelPj.getCidade(),
                    viewModelPj.getEstado(),
                    viewModelPj.getCnpj(),
                    viewModelPj.getEmail(),
                    viewModelPj.getTelefone()
                    //viewModelPj.getImageByteArray()
            );
                CadastroSERVICE.executarVerificacao(requireContext(),pessoaPJ);

                Intent intent = new Intent(requireContext(), TelaInicial.class);
                startActivity(intent);


        });
    }
}
