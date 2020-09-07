package it.fabioformosa.lab.springhandover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class SpringHandoverTest {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void givenCompletedBootstrap_callMainApp_callPluginApp() throws Exception{

        AppMain.main(new String[] {});

        ResponseEntity<String> mainAppResponse = restTemplate.getForEntity("http://localhost:8082", String.class);
        assertThat(mainAppResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(mainAppResponse.getBody()).contains("Hello World by Main App!");


        ResponseEntity<String> pluginAppResponse = restTemplate.getForEntity("http://localhost:8081",
                String.class);
        assertThat(pluginAppResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(pluginAppResponse.getBody()).contains("Hello World by Plugin!");
    }

}
