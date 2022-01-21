
/*
File Name: Suicide.java
Part of package: com.azamserver.suicide
Description: This file alerts the plugin on what to do when a player issues the command "/suicide"
*/

// Declare package name
package com.azamserver.suicide.Commands;

// Import all needed libraries
import com.azamserver.suicide.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

// Start java class
public class Suicide implements CommandExecutor
{
    // Declare all needed variables
    private final Main main;
    private static final String messageStart = "" + ChatColor.BOLD + "" + ChatColor.GREEN + "[" + ChatColor.RED + "Suicide" + ChatColor.GREEN + "]: ";

    // This constructor allows Main.java to access the command "/suicide"
    public Suicide(Main main)
    {
        // Set all needed variables
        this.main = main;
    }

    // This method alerts the plugins on what to do when the command "/suicide" is run
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        // Check if the command "/suicide" had arguments
        if(args.length == 0)
        {
            // Check if console executed the command
            if(sender instanceof ConsoleCommandSender)
            {
                // If console did execute the command, respond to console with a message saying that only players can run the command
                sender.sendMessage(messageStart + "You are not allowed to issue this command as console");
                return true;
            }
            // Check if a player executed the command
            if(sender instanceof Player)
            {
                // Check if said player has the permissions to execute "/suicide"
                if(sender.isOp() || sender.hasPermission("suicide.suicide"))
                {
                    // If the player has the correct permissions, kill the command issuer
                    ((Player) sender).setHealth(0);

                    // Alert the command issuer that they have died
                    sender.sendMessage(messageStart + "You have killed your own player");
                    return true;
                }
                else
                {
                    // If the player does not have the correct permissions, alert the player that they do not have the correct permissions to run the "/suicide" command
                    sender.sendMessage(messageStart + "You do not have the permissions to execute this command");
                    return true;
                }
            }
        }
        else
        {
            // If the command "/suicide" had >= 1 arguments, check for sender's permissions
            if(sender instanceof ConsoleCommandSender || sender.isOp() || sender.hasPermission("suicide.helpMenu"))
            {
                // If the sender does have the correct permissions, send the user a help menu
                sender.sendMessage(messageStart + "Help Menu");
                sender.sendMessage(messageStart + "/suicide : Kills your own player");
                sender.sendMessage(messageStart + "/suicide help : Displays current help menu");
                return true;
            }
            else
            {
                // If the player does not have the correct permissions, alert the player that they do not have the correct permissions to run the "/suicide" command
                sender.sendMessage(messageStart + "You do not have the permissions to execute this command");
                return true;
            }
        }

        // Line of code is here to pass Java Syntax Check
        return false;
    }
}
