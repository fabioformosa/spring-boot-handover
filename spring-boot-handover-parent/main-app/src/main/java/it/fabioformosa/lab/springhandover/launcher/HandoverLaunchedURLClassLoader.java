package it.fabioformosa.lab.springhandover.launcher;

import java.net.URL;

import org.springframework.boot.loader.LaunchedURLClassLoader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HandoverLaunchedURLClassLoader extends LaunchedURLClassLoader {

    //    private ClassLoader mainAppClassloader;

    public HandoverLaunchedURLClassLoader(boolean exploded, URL[] urls, ClassLoader parent) {
        super(exploded, urls, null);
        //        mainAppClassloader = parent;
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

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        log.trace("!!! HandoverLaunchedURLClassLoader LOAD CLASS - {}", name);
        return super.loadClass(name, resolve);
    }

}
