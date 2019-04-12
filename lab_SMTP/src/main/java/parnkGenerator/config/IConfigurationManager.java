package main.java.parnkGenerator.config;

import java.io.IOException;

public interface IConfigurationManager {

        public void loadProperties() throws IOException;

        public void loadVictims() throws IOException;

        public void loadMessages() throws IOException;
    }
}
