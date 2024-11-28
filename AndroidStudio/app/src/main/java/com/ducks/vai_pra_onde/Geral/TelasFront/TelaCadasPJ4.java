package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ducks.vai_pra_onde.Geral.DTO.ViewCadasPessoPjDTO;
import com.ducks.vai_pra_onde.Geral.Utilidades.UtilArmazenImage;
import com.ducks.vai_pra_onde.R;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.io.IOException;

public class TelaCadasPJ4 extends AppCompatActivity {

    private ImageView imageViewSelect;
    private String saveImagePath;
    private byte[] imagemData;

    private ViewCadasPessoPjDTO viewModelPj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadas_pj4);

        viewModelPj = new ViewModelProvider(this).get(ViewCadasPessoPjDTO.class);

        Button buttonFinCadas = findViewById(R.id.buttonFinalCadas);
        Button buttonSelecIma = findViewById(R.id.buttonSelectImage);
        imageViewSelect = findViewById(R.id.imageView);


        UtilArmazenImage utilArmIma = new UtilArmazenImage(this);

        ActivityResultLauncher<Intent> imagePickerLaucher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK && result.getData() != null){
                        Uri imagemUri = result.getData().getData();
                        try {
                            Bitmap bitMap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagemUri);

                            saveImagePath = utilArmIma.saveImage(bitMap);

                            imagemData = utilArmIma.convertBitMapToByteArray(bitMap);

                            viewModelPj.setDocumAutecEmpr(imagemData);

                            imageViewSelect.setImageBitmap(bitMap);

                            Toast.makeText(this, "Imagem salva em " + saveImagePath, Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            Toast.makeText(this, "Erro em processar a imagem", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        buttonSelecIma.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            imagePickerLaucher.launch(intent);
        });

        buttonFinCadas.setOnClickListener(v -> {
            Intent intent2 = new Intent(TelaCadasPJ4.this, TelaLoginEmpresa.class);
            startActivity(intent2);
        });
    }
}
