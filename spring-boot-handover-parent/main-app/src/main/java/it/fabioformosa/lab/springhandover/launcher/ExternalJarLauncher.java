package it.fabioformosa.lab.springhandover.launcher;

import java.net.URL;

import org.springframework.boot.loader.JarLauncher;
import org.springframework.boot.loader.archive.Archive;

public class ExternalJarLauncher extends JarLauncher {

    public ExternalJarLauncher(Archive archive) {
        super(archive);
    }

    @Override
    protected ClassLoader createClassLoader(URL[] urls) throws Exception {
        //        return new HandoverLaunchedURLClassLoader(isExploded(), urls, getClass().getClassLoader());

        //        ClassLoader parent = getClass().getClassLoader();
        //        ClassLoader mainAppClassLoader = new DelegatingMainAppClassLoader(parent);
        //        return new HandoverLaunchedURLClassLoader(isExploded(), urls, mainAppClassLoader);

        //        TomcatURLStreamHandlerFactory.disable();

        return new HandoverLaunchedURLClassLoader(isExploded(), urls, getClass().getClassLoader());
    }

    public void launchApplication(String[] args) throws Exception {
        this.launch(args);
    }

}
