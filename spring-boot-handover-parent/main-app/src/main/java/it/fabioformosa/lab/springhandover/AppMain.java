package it.fabioformosa.lab.springhandover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

import it.fabioformosa.lab.springhandover.launcher.HandoverStarter;

@EnableAutoConfiguration(exclude={JmxAutoConfiguration.class})
@SpringBootApplication
public class AppMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppMain.class, args);

        Thread thread = new Thread(() -> {
            try {
                new HandoverStarter(args);
            } catch (Exception e) {
            }
        });
        thread.run();
    }
}