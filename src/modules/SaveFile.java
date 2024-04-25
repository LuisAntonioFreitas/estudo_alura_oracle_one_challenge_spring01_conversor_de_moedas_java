package modules;

import java.io.FileWriter;
import java.util.List;

public class SaveFile {

    public void saveFileTxt(List<String> list) {
        try {
            String fileName = "historico_conversoes.txt";

            FileWriter writeFile = new FileWriter(fileName);
            writeFile.write("Histórico de Conversões\n");
            writeFile.write("=======================\n");
            for (String item : list) {
                writeFile.write(item.concat("\n"));
            };
            writeFile.close();

            System.out.println("Arquivo salvo com sucesso!");
        } catch (Exception e) {
            System.out.println("Problema para salvar arquivo.");
//            System.out.println("Error Message:\n" + e.getCause());
        }
    }

}
