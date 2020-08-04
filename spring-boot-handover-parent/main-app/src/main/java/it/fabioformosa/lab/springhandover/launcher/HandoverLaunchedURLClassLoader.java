package it.fabioformosa.lab.springhandover.launcher;

import java.net.URL;

import org.springframework.boot.loader.LaunchedURLClassLoader;

public class HandoverLaunchedURLClassLoader extends LaunchedURLClassLoader {

    public HandoverLaunchedURLClassLoader(boolean exploded, URL[] urls, ClassLoader parent) {
        super(exploded, urls, parent);
    }

    @Override
    public URL getResource(String name) {
        URL url = null;
        if (url == null)
            url = findResource(name);
        if(url == null)
            url = super.getResource(name);
        return url;
    }

}
