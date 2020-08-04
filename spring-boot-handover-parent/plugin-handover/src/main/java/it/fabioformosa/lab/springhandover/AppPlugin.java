package it.fabioformosa.lab.springhandover;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

@EnableAutoConfiguration(exclude={JmxAutoConfiguration.class})
@SpringBootApplication
public class AppPlugin {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            Class<?> springApplicationClass = classLoader.loadClass("org.springframework.boot.SpringApplication");
            //            Constructor<?> constructor = springApplicationClass.getConstructor(Class[].class);
            //            Constructor<?> constructor = springApplicationClass.getConstructors()[0];
            //            Class[] classes = new Class[] {AppPlugin.class};
            //            Object springApplication = constructor.newInstance(AppPlugin.class);
            Method runMethod = springApplicationClass.getMethod("run", Class.class,  String[].class);
            runMethod.invoke(springApplicationClass, AppPlugin.class, args);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //        SpringApplication springApplication = new SpringApplication(new DefaultResourceLoader(Thread.currentThread().getContextClassLoader()), new Class<?>[] { AppPlugin.class });
        //        springApplication.run(args);

        //        SpringApplication.run(AppPlugin.class, args);
    }
}