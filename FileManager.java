package com.galasticnetwork.tags;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.backends.file.FileConfig;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileManager {

    Main main;
    boolean hasTag;

    String prefix;
    File file;
    FileConfiguration configuration;

    public void saveCustomYml(FileConfiguration ymlConfig, File ymlFile)
    {
        file = ymlFile;
        configuration = ymlConfig;

        try {
            ymlConfig.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPrefix(Player player)
    {
        UUID uuid = player.getUniqueId();
        if(this.configuration.getString(uuid.toString() + ".tag").isEmpty())
        {
            this.hasTag = false;
            this.prefix = null;
        } else
        {

            this.prefix = configuration.getString(uuid.toString() + ".tag");
            this.hasTag = false;
        }
        return this.prefix;
    }

    public boolean doesHaveTag(Player player)
    {
        return this.hasTag;
    }
}
