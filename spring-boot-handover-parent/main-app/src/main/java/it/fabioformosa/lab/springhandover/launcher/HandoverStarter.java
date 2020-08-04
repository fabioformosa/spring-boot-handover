package it.fabioformosa.lab.springhandover.launcher;

import org.springframework.boot.loader.archive.Archive;

public class HandoverStarter {

    //    public HandoverStarter() throws Exception {
    //        JarLoader jarLoader = new JarLoader();
    //        Archive archive = jarLoader.load();
    //        ExternalJarLauncher externalJarLauncher = new ExternalJarLauncher(archive);
    //        externalJarLauncher.launchApplication(new String[1]);
    //    }

    public HandoverStarter(String[] args) throws Exception {
        JarLoader jarLoader = new JarLoader();
        Archive archive = jarLoader.load();
        ExternalJarLauncher externalJarLauncher = new ExternalJarLauncher(archive);
        externalJarLauncher.launchApplication(args);
    }

}
