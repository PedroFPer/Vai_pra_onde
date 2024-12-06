/*package com.ducks.vai_pra_onde.Geral.TelasFront;

import static android.app.PendingIntent.getActivity;
import static java.security.AccessController.getContext;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.Geral.Utilidades.UtilArmazenImage;
import com.ducks.vai_pra_onde.R;

import java.io.IOException;

public class PerfilEmpresa extends AppCompatActivity {

    private ImageView imageViewSelected;
    private  String saveImagePath;
    private byte[] imagemData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil_empresa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonSelecIma = view.findViewById(R.id.bannerbtn);
        imageViewSelect = view.findViewById(R.id.banner);

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

    }
}*/