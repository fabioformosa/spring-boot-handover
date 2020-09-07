package it.fabioformosa.lab.springhandover.launcher;

import java.util.Optional;

import org.springframework.boot.loader.archive.Archive;

public class HandoverStarter {

    //    static public void main(String[] args) throws Exception {
    //        JarLoader jarLoader = new JarLoader();
    //        Archive archive = jarLoader.load();
    //        ExternalJarLauncher externalJarLauncher = new ExternalJarLauncher(archive);
    //        externalJarLauncher.launchApplication(new String[1]);
    //    }

    static public void main(String[] args) throws Exception {
        JarLoader jarLoader = new JarLoader();
        Optional<Archive> archive = jarLoader.load();
        archive.map(ExternalJarLauncher::new).ifPresent(externalJarLauncher -> {
            try {
                externalJarLauncher.launchApplication(args);
            } catch (Exception e) {
                new RuntimeException(e);
            }
        });
    }

}
