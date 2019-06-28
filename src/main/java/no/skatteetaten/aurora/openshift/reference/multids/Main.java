package no.skatteetaten.aurora.openshift.reference.multids;

import static java.lang.String.format;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    protected Main() {
    }

    public static void main(String[] args) throws Exception {

        setSystemPropertiesFromPropertiesFile("SALES_DB_PROPERTIES", "sales");
        setSystemPropertiesFromPropertiesFile("CUSTOMERS_DB_PROPERTIES", "customer");

        SpringApplication.run(Main.class, args);
    }

    /**
     * Loads datasource properties from the location specified in the <code>propertiesFileLocationEnvName</code>
     * environment variable and copies them into system properties aligned with the configuration specified in
     * <code>application.yml</code>. If the environment variable is not set, the method returns silently.
     *
     * @param propertiesFileLocationEnvName The name of the environment variable to contains the path to the file with
     *                                      the properties to read.
     * @param datasourceName                the name of the datasource in the system property to set; ie;
     *                                      <code>datasources.{datasourceName}.url</code>.
     * @throws IOException
     */
    private static void setSystemPropertiesFromPropertiesFile(
        String propertiesFileLocationEnvName,
        String datasourceName) throws IOException {

        String propertiesFileLocation = System.getenv(propertiesFileLocationEnvName);
        if (propertiesFileLocation == null) {
            return;
        }
        Properties props = new Properties();
        props.load(new FileInputStream(propertiesFileLocation));

        System.setProperty(format("datasources.%s.url", datasourceName), props.getProperty("jdbc.url"));
        System.setProperty(format("datasources.%s.username", datasourceName), props.getProperty("jdbc.user"));
        System.setProperty(format("datasources.%s.password", datasourceName), props.getProperty("jdbc.password"));
    }

}
