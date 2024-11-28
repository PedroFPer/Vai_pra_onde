package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.Geral.DTO.ViewCadasPessoPjDTO;
import com.ducks.vai_pra_onde.R;

public class TelaLoginEmpresa extends AppCompatActivity {
    private ImageView imageView;
    private ViewCadasPessoPjDTO viewModelPj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_empresa);

        imageView = findViewById(R.id.imageView);

        // Inicialize o ViewModel ou DTO com dados reais
        viewModelPj = new ViewCadasPessoPjDTO();  // Ou obter dados do ViewModel real ou banco

        // Suponhamos que você tenha um byte[] com a imagem
        byte[] imagemByteArray = viewModelPj.getImageByteArray();  // Verifique se o método existe e retorna um byte[]

        if (imagemByteArray != null && imagemByteArray.length > 0) {
            // Convertendo o byte[] em Bitmap
            Bitmap bitmap = BitmapFactory.decodeByteArray(imagemByteArray, 0, imagemByteArray.length);

            // Exibindo a imagem no ImageView
            imageView.setImageBitmap(bitmap);

        }
    }
}
