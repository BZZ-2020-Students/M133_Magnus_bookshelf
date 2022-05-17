package ch.bookshelf.service;

import ch.bookshelf.model.Book;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

    @ApplicationPath("/resource")
public class Config extends Application {
        private static final String PROPERTIES_PATH = "C:\\Github\\M133_Magnus_bookshelf\\code\\Bookshelf\\src\\main\\resources\\bookList.properties";
        private static Properties properties = null;

        /**
         * Gets the value of a property
         *
         * @param property the key of the property to be read
         * @return the value of the property
         */
        public static String getProperty(String property) {
            if (Config.properties == null) {
                setProperties(new Properties());
                readProperties();
            }
            String value = Config.properties.getProperty(property);
            if (value == null) return "";
            return value;
        }

        /**
         * reads the properties file
         */
        private static void readProperties() {

            InputStream inputStream;
            try {
                inputStream = Files.newInputStream(Paths.get(PROPERTIES_PATH));
                properties.load(inputStream);
                inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new RuntimeException();
            }
        }

        /**
         * Sets the properties
         *
         * @param properties the value to set
         */
        private static void setProperties(Properties properties) {
            Config.properties = properties;
        }
}
