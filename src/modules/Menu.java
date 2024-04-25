package modules;

import models.Converter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private String origin;
    private String destiny;

    public Menu() {}
    public Menu(String origin, String destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    public void optionsMenu() {

        String opcoesMenu = """
                *****************************************************************
                *            C O N V E R S O R    D E    M O E D A S            *
                *****************************************************************
                * 1  | [USD] Dólar ............... ==>> [BRL] Real (brasileiro) *
                * 2  | [BRL] Real (brasileiro) ... ==>> [USD] Dólar             *
                * 3  | [EUR] Euro ................ ==>> [BRL] Real (brasileiro) *
                * 4  | [BRL] Real (brasileiro) ... ==>> [EUR] Euro              *
                * 5  | [USD] Dólar ............... ==>> [ARS] Peso (argentino)  *
                * 6  | [ARS] Peso (argentino) .... ==>> [USD] Dólar             *
                * 7  | [EUR] Euro ................ ==>> [ARS] Peso (argentino)  *
                * 8  | [ARS] Peso (argentino) .... ==>> [EUR] Euro              *
                * 9  | [USD] Dólar ............... ==>> [COP] Peso (colombiano) *
                * 10 | [COP] Peso (colombiano) ... ==>> [USD] Dólar             *
                * 11 | [EUR] Euro ................ ==>> [COP] Peso (colombiano) *
                * 12 | [COP] Peso (colombiano) ... ==>> [EUR] Euro              *
                * 13 | [USD] Dólar ............... ==>> [EUR] Euro              *
                * 14 | [EUR] Euro ................ ==>> [USD] Dólar             *
                * 15 | Histórico de conversões                                  *
                * 16 | Salvar histórico de conversões                           *
                * 17 | Sair                                                     *
                *****************************************************************
                Escolha uma opção válida:""";

        System.out.println(opcoesMenu);
    }

    public void executeOptionsMenu(Scanner scanner, int optionsMenu, List<String> historyConversion) {
        System.out.println("%s | Digite o valor [%s] que deseja converter para [%s]:"
                .formatted(String.valueOf(optionsMenu), getOrigin(), getDestiny()));

        ValidNumber validNumber = new ValidNumber();
        double value = validNumber.getValidDouble(scanner, null);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator('\u0000');
        DecimalFormat formatValue = new DecimalFormat("#.00", symbols);
        String valueFormat = formatValue.format(value);

        // API
        ApiConverterExchangeRateApi apiConverterCustomize = new ApiConverterExchangeRateApi();
        Converter apiConverter = apiConverterCustomize.apiConverter(getOrigin(), getDestiny(), valueFormat);

        if (!apiConverter.toString().isEmpty()) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formatDateTime = now.format(formatter);

            String addFormatDateTimeApiConverter = formatDateTime.concat(" | ").concat(apiConverter.toString());
            historyConversion.add(addFormatDateTimeApiConverter);
            System.out.println(apiConverter);
        }
    }

    private String getOrigin() {
        return this.origin;
    }
    private String getDestiny() {
        return this.destiny;
    }

}
