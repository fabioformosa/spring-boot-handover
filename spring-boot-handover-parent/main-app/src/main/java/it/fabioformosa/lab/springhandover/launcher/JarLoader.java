package it.fabioformosa.lab.springhandover.launcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.pf4j.JarPluginRepository;
import org.springframework.boot.loader.archive.Archive;
import org.springframework.boot.loader.archive.JarFileArchive;
import org.springframework.util.CollectionUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JarLoader {

    public static final String DEFAULT_PLUGINS_DIR = "plugins";

    private void checkIfPluginRootExistOrThrows(Path pluginsRoot) {
        if (Files.notExists(pluginsRoot) || !Files.isDirectory(pluginsRoot)) {
            log.warn("JAR LOADER - No '{}' root", pluginsRoot);
            throw new RuntimeException("JAR LOADER - No " + pluginsRoot + " root");
        }
    }

    public Optional<Archive> load() throws IOException {
        log.info("JAR LOADER - Searching for plugin jar in {}", DEFAULT_PLUGINS_DIR);
        Path pluginsRoot = Paths.get(DEFAULT_PLUGINS_DIR);

        checkIfPluginRootExistOrThrows(pluginsRoot);

        JarPluginRepository jarPluginRepository = new JarPluginRepository(pluginsRoot);
        List<Path> pluginPaths = jarPluginRepository.getPluginPaths();
        if(CollectionUtils.isEmpty(pluginPaths)) {
            log.info("JAR LOADER - Not found any plugins!");
            return Optional.empty();
        }

        File file = pluginPaths.get(0).toFile();
        log.info("JAR LOADER - Found 1 plugin {}", file.getName());

        return Optional.of(new JarFileArchive(file));
    }


}
