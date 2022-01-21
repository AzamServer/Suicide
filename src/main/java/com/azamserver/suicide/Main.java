
/*
File Name: Main.java
Part of package: com.azamserver.suicide
Description: This file is the root of the plugin and tells the plugins what to do on enabling and disabling
*/

// Declare package name
package com.azamserver.suicide;

// Import all needed libraries
import com.azamserver.suicide.Commands.Suicide;
import org.bukkit.plugin.java.JavaPlugin;

// Start java class
public final class Main extends JavaPlugin {

    // Code will run on plugin enable
    @Override
    public void onEnable() {
        // Allow command "/suicide" to work
        getServer().getPluginCommand("suicide").setExecutor(new Suicide(this));
    }

    // Code will run on plugin disable
    @Override
    public void onDisable() {
        // Since there isn't anything for the plugin to do on disable, this has been left empty
    }
}
