package com.ducks.vai_pra_onde.Geral.Utilidades;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UtilArmazenImage {

    private Context context;

    // Construtor que recebe o contexto
    public UtilArmazenImage(Context context) {
        this.context = context;
    }

    public String saveImage(Bitmap bitmap){
        String fileName = "Documento:" + System.currentTimeMillis() + ".png";
        File directory = getFileDir();
        File imagemFile = new File(directory, fileName);

        try (FileOutputStream fos = new FileOutputStream(imagemFile)){
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (IOException e) {
            Toast.makeText(context, "Erro ao salvar a imagem", Toast.LENGTH_SHORT).show();
            return null;
        }
        return imagemFile.getAbsolutePath();
    }

    public byte[] convertBitMapToByteArray(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    private File getFileDir() {
        return context.getFilesDir();
    }
}
