package it.fabioformosa.lab.springhandover.launcher;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import lombok.extern.slf4j.Slf4j;

@Deprecated
@Slf4j
public class DelegatingMainAppClassLoader extends ClassLoader {

    private ClassLoader shadowParent;

    public DelegatingMainAppClassLoader(ClassLoader parent) {
        super(null);
        shadowParent = parent;
    }

    //    @Override
    //    protected Package getPackage(String name) {
    //        log.info("!!! DelegatingMainAppClassLoader !!! - GET PACKAGE ${}", name);
    //        Package pkg;
    //        synchronized (packages) {
    //            pkg = packages.get(name);
    //        }
    //        if (pkg == null) {
    //            if (parent != null)
    //                pkg = parent.getPackage(name);
    //            else
    //                pkg = Package.getSystemPackage(name);
    //            if (pkg != null)
    //                synchronized (packages) {
    //                    Package pkg2 = packages.get(name);
    //                    if (pkg2 == null)
    //                        packages.put(name, pkg);
    //                    else
    //                        pkg = pkg2;
    //                }
    //        }
    //        return pkg;
    //    }

    @Override
    public URL getResource(String name) {
        log.info("!!! DelegatingMainAppClassLoader !!! - GET RESOURCE ${}", name);
        return null;
        //        return super.getResource(name);
    }

    @Override
    public Enumeration<URL> getResources(String name) throws IOException {
        log.info("!!! DelegatingMainAppClassLoader !!! - GET RESOURCES ${}", name);
        return null;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        log.info("!!! DelegatingMainAppClassLoader !!! - LOAD CLASS ${}", name);
        return null;
        //        return super.loadClass(name, resolve);
    }

}
