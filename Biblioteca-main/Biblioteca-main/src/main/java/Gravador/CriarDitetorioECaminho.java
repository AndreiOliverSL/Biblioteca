package Gravador;

import java.io.File;
import java.io.IOException;

public class CriarDitetorioECaminho {

    public static void main(String[] args) throws IOException {

        File diretorio = new File("caminho/do/seu/diretorio");
        if (!diretorio.exists()) {
            diretorio.mkdirs();  // Isso criará o diretório se ele não existir
        }

        String diretorioDeTrabalho = System.getProperty("user.dir");
        System.out.println("Diretório de trabalho atual: " + diretorioDeTrabalho);
    }
}
