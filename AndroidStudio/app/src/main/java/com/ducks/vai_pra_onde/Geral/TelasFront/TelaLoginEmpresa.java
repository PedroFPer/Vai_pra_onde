package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ducks.vai_pra_onde.Geral.DTO.ViewCadasPessoPjDTO; // Importe o seu ViewModel
import com.ducks.vai_pra_onde.R;

public class TelaLoginEmpresa extends Fragment {

    private ImageView imageView;
    private ViewCadasPessoPjDTO viewModel; // Use o ViewModel correto aqui

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_tela_login_empresa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicialize o ImageView
        imageView = view.findViewById(R.id.imageView);

        // Obtenha o ViewModel correto
        viewModel = new ViewModelProvider(requireActivity()).get(ViewCadasPessoPjDTO.class);

        // Observe o LiveData que contém o byte[] da imagem
        viewModel.getImageByteArray().observe(getViewLifecycleOwner(), new Observer<byte[]>() {
            @Override
            public void onChanged(byte[] imageByteArray) {
                if (imageByteArray != null && imageByteArray.length > 0) {
                    // Converte o byte[] para Bitmap
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length);
                    // Exibe a imagem no ImageView
                    imageView.setImageBitmap(bitmap);
                }
            }
        });
    }
}
