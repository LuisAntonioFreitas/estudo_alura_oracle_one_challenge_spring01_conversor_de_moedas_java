import modules.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        ValidNumber validNumber = new ValidNumber();
        List<String> historyConversion = new ArrayList<>();

        final int OPTIONS_LIMIT = 17;
        int optionsMenu = 0;
        while (optionsMenu != OPTIONS_LIMIT) {
            menu.optionsMenu();

            optionsMenu = validNumber.getValidInteger(scanner, OPTIONS_LIMIT);

            switch (optionsMenu) {
                case 1:
                    // Dólar ==>> Real (brasileiro)
                    Menu menuDolarRealBrasileiro = new Menu("USD", "BRL");
                    menuDolarRealBrasileiro.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 2:
                    // Real (brasileiro) ==>> Dólar
                    Menu menuRealBrasileiroDolar = new Menu("BRL", "USD");
                    menuRealBrasileiroDolar.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 3:
                    // Euro ==>> Real (brasileiro)
                    Menu menuEuroRealBrasileiro = new Menu("EUR", "BRL");
                    menuEuroRealBrasileiro.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 4:
                    // Real (brasileiro) ==>> Euro
                    Menu menuRealBrasileiroEuro = new Menu("BRL", "EUR");
                    menuRealBrasileiroEuro.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 5:
                    // Dólar ==>> Peso (argentino)
                    Menu menuDolarPesoArgentino = new Menu("USD", "ARS");
                    menuDolarPesoArgentino.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 6:
                    // Peso (argentino) ==>> Dólar
                    Menu menuPesoArgentinoDolar = new Menu("ARS", "USD");
                    menuPesoArgentinoDolar.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 7:
                    // Euro ==>> Peso (argentino)
                    Menu menuEuroPesoArgentino = new Menu("EUR", "ARS");
                    menuEuroPesoArgentino.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 8:
                    // Peso (argentino) ==>> Euro
                    Menu menuPesoArgentinoEuro = new Menu("ARS", "EUR");
                    menuPesoArgentinoEuro.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 9:
                    // Dólar ==>> Peso (colombiano)
                    Menu menuDolarPesoColombiano = new Menu("USD", "COP");
                    menuDolarPesoColombiano.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 10:
                    // Peso (colombiano) ==>> Dólar
                    Menu menuPesoColombianoDolar = new Menu("COP", "USD");
                    menuPesoColombianoDolar.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 11:
                    // Euro ==>> Peso (colombiano)
                    Menu menuEuroPesoColombiano = new Menu("EUR", "COP");
                    menuEuroPesoColombiano.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 12:
                    // Peso (colombiano) ==>> Euro
                    Menu menuPesoColombianoEuro = new Menu("COP", "EUR");
                    menuPesoColombianoEuro.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 13:
                    // Dólar ==>> Euro
                    Menu menuDolarEuro = new Menu("USD", "EUR");
                    menuDolarEuro.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 14:
                    // Euro ==>> Dólar
                    Menu menuEuroDolar = new Menu("EUR", "USD");
                    menuEuroDolar.executeOptionsMenu(scanner, optionsMenu, historyConversion);
                    break;
                case 15:
                    // Histórico de conversões;
                    if (!historyConversion.isEmpty()) {
                        System.out.println("%s | Histórico de Conversões\n"
                                .concat("============================")
                                .formatted(String.valueOf(optionsMenu)));
                        for (String item : historyConversion) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("Histórico de conversões está vazio!");
                    }
                    break;
                case 16:
                    // Salvar histórico de conversões;
                    if (!historyConversion.isEmpty()) {
                        SaveFile saveFile = new SaveFile();
                        saveFile.saveFileTxt(historyConversion);
                    } else {
                        System.out.println("Histórico de conversões está vazio!");
                    }
                    break;
                case 17:
                    // Sair;
                    System.out.println("Conversor finalizado!");
                    break;
                default:
                    // Opção inválida
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();

    }
}
