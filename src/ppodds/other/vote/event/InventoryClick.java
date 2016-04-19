package ppodds.other.vote.event;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import ppodds.other.vote.Vote;

public class InventoryClick implements Listener
{
	private Vote v;
	public InventoryClick(Vote v)
	{
		this.v = v;
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		File data = new File(v.getDataFolder() + File.separator + "data");
		for (File f : data.listFiles())
		{
			YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
			if (e.getInventory().getName().equals(y.getString("title")))
			{
				e.setCancelled(true);
				e.getWhoClicked().closeInventory();
				switch (e.getSlot())
				{
					case 0:
						try
						{
							y.set("answer1", y.getInt("answer1") + 1);
							y.save(f);
							e.getWhoClicked().sendMessage("你投了選項1");
							break;
						}
						catch (IOException e1)
						{
							e1.printStackTrace();
						}
					case 2:
						try
						{
							y.set("answer2", y.getInt("answer2") + 1);
							y.save(f);
							e.getWhoClicked().sendMessage("你投了選項2");
							break;
						}
						catch (IOException e1)
						{
							e1.printStackTrace();
						}
					case 4:
						try
						{
							y.set("answer3", y.getInt("answer3") + 1);
							y.save(f);
							e.getWhoClicked().sendMessage("你投了選項3");
							break;
						}
						catch (IOException e1)
						{
							e1.printStackTrace();
						}
					case 6:
						try
						{
							y.set("answer4", y.getInt("answer4") + 1);
							y.save(f);
							e.getWhoClicked().sendMessage("你投了選項4");
							break;
						}
						catch (IOException e1)
						{
							e1.printStackTrace();
						}
					case 8:
						try
						{
							y.set("answer5", y.getInt("answer5") + 1);
							y.save(f);
							e.getWhoClicked().sendMessage("你投了選項5");
							break;
						}
						catch (IOException e1)
						{
							e1.printStackTrace();
						}
				}
			}
		}
	}
}
