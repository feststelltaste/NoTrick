package de.feststelltaste.notrick.api.game;

import de.feststelltaste.notrick.api.NoTrickException;

public class ConfigurationException extends NoTrickException {

    private static final long serialVersionUID = 660381070254695567L;

    private final String message;
    
    public ConfigurationException(String errorMessage) {
        this.message = errorMessage;
    }
    
    @Override
    public String getMessage() {
        return message;
    }


}
