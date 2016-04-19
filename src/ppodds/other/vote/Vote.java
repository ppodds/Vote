package ppodds.other.vote;

import org.bukkit.plugin.java.JavaPlugin;

import ppodds.other.vote.command.vt;
import ppodds.other.vote.event.InventoryClick;

public class Vote extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		saveDefaultConfig();
		getCommand("vt").setExecutor(new vt(this));
		getServer().getPluginManager().registerEvents(new InventoryClick(this), this);
		if (!getDataFolder().exists())
		{
			getDataFolder().mkdir();
		}
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
