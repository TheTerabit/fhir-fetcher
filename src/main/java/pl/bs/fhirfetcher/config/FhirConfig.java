package pl.bs.fhirfetcher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class FhirConfig {

    @Bean
    public void startServer() {
        try {
            System.out.println("Starting FHIR server...");
            // Run a java app in a separate system process
            Process proc = Runtime.getRuntime().exec("hapi-fhir-cli run-server");
            // Then retreive the process output
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();
            proc.waitFor();
            System.out.println("FHIR runs!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
