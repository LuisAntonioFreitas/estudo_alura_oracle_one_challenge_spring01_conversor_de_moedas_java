package modules;

import models.Converter;

public interface ApiConverter {

    Converter apiConverter(String origin, String destiny, String value);
}
