# SPRING BOOT HANDOVER

This project is a PoC to prove that a spring boot project can launch another spring boot project like a relay race with the baton handover.

The project is composed by:
 * springboot-handover-main-app
 * springboot-handover-plugin
 
 They both are web applications.

 ### Main App

 the `springboot-handover-main-app` runs on an embedded jetty and it's reachable to the port 8082.
 You get the string `Hello World by Main App!` if you contact it to the `http://localhost:8082`.
 
 ### Plugin App

 the `springboot-handover-puglin' runs on an embedded and it's reachable to the port 8081.
 You get the string `Hello World by Plugin!` if you contact it to the `http://localhost:8081`.
 
 ## Quick Start
 
Build the `springboot-handover-puglin` (`mvn build`).
A maven plugin will copy the spring boot fat jar in the folder `plugins` of the `springboot-handover-main-app`.
Now launch `springboot-handover-main-app` and it will start `springboot-handover-puglin`.

When the bootstrap completes, try to open by browser:
* `http://localhost:8082` -> to get `Hello World by Main App!`
* `http://localhost:8081` -> to get `springboot-handover-puglin`

## LIMITATIONS

Currently, the only way to prove the handover is embedded the main app in a jetty and the plugin in a tomcat (or vice versa).
