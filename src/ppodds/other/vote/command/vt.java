package ppodds.other.vote.command;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import ppodds.other.vote.Vote;

public class vt implements CommandExecutor
{

	private final Vote v;
	
	public vt(Vote v)
	{
		this.v = v;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		File config = new File(v.getDataFolder() + File.separator + "config.yml");
		YamlConfiguration configy = YamlConfiguration.loadConfiguration(config);
		if (lable.equalsIgnoreCase("vt") && sender instanceof Player && args.length <= 8)
		{
			Player p = (Player) sender;
			if (args.length == 0)
			{
				p.sendMessage("���O�Ϊk:");
				p.sendMessage("/vt [�s��] [�ﶵ���s��] �벼");
				p.sendMessage("/vt create [�s��] [���D] [�ﶵ1] [�ﶵ2] [�ﶵ3] [�ﶵ4] [�ﶵ5] �Ыؤ@�ӧ벼(��ﶵ1�]�w���ﶵ���s��1�A�H������)");
				p.sendMessage("/vt del [�s��] �R���벼(���ާ벼���G�A�����R��)");
				p.sendMessage("/vt end [�s��] �I��벼(��ܧ벼���G)");
				p.sendMessage("/vt check �d�ߦ����ǥ��b�몺��");
			}
			if (args.length == 1 && p.hasPermission(configy.getString("permission.vt.vote")))
			{
				File f = new File((v.getDataFolder() + File.separator + "data" + File.separator + args[0]) + ".yml");
				if (f.exists())
				{
					YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
					Inventory chest = Bukkit.createInventory(null, 9, y.getString("title"));
					String choice1 = y.getString("choice1");
					String choice2 = y.getString("choice2");
					String choice3 = y.getString("choice3");
					String choice4 = y.getString("choice4");
					String choice5 = y.getString("choice5");
					/////////////////////////////////////////////////////////////
					ItemStack ichoice1 = new ItemStack(Material.PAPER);
					ItemMeta imchoice1 = ichoice1.getItemMeta();
					imchoice1.setDisplayName("�ﶵ�@:");
					List<String> lore1 = new ArrayList<String>();
					lore1.add(choice1);
					imchoice1.setLore(lore1);
					ichoice1.setItemMeta(imchoice1);
					////////////////////////////////////////////////////////////
					ItemStack ichoice2 = new ItemStack(Material.PAPER);
					ItemMeta imchoice2 = ichoice2.getItemMeta();
					imchoice2.setDisplayName("�ﶵ�G:");
					List<String> lore2 = new ArrayList<String>();
					lore2.add(choice2);
					imchoice2.setLore(lore2);
					ichoice2.setItemMeta(imchoice2);
					////////////////////////////////////////////////////////////
					ItemStack ichoice3 = new ItemStack(Material.PAPER);
					ItemMeta imchoice3 = ichoice3.getItemMeta();
					imchoice3.setDisplayName("�ﶵ�T:");
					List<String> lore3 = new ArrayList<String>();
					lore3.add(choice3);
					imchoice3.setLore(lore3);
					ichoice3.setItemMeta(imchoice3);
					////////////////////////////////////////////////////////////
					ItemStack ichoice4 = new ItemStack(Material.PAPER);
					ItemMeta imchoice4 = ichoice4.getItemMeta();
					imchoice4.setDisplayName("�ﶵ�|:");
					List<String> lore4 = new ArrayList<String>();
					lore4.add(choice4);
					imchoice4.setLore(lore4);
					ichoice4.setItemMeta(imchoice4);
					////////////////////////////////////////////////////////////
					ItemStack ichoice5 = new ItemStack(Material.PAPER);
					ItemMeta imchoice5 = ichoice5.getItemMeta();
					imchoice5.setDisplayName("�ﶵ��:");
					List<String> lore5 = new ArrayList<String>();
					lore5.add(choice5);
					imchoice5.setLore(lore5);
					ichoice5.setItemMeta(imchoice5);
					////////////////////////////////////////////////////////////
					chest.setItem(0, ichoice1);
					chest.setItem(2, ichoice2);
					chest.setItem(4, ichoice3);
					chest.setItem(6, ichoice4);
					chest.setItem(8, ichoice5);
					////////////////////////////////////////////////////////////
					p.openInventory(chest);
				}
				else
				{
					p.sendMessage("���벼���s�b!");
				}
			}
			if (args.length == 8 && args[0].equalsIgnoreCase("create") && p.hasPermission(configy.getString("permission.vt.create")))
			{
				try
				{
					File dir = new File((v.getDataFolder() + File.separator + "data"));
					if (dir.exists())
					{
						File f = new File((v.getDataFolder() + File.separator + "data" + File.separator + args[1]) + ".yml");
						f.createNewFile();
						YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
						y.set("title", args[2]);
						y.set("choice1", args[3]);
						y.set("choice2", args[4]);
						y.set("choice3", args[5]);
						y.set("choice4", args[6]);
						y.set("choice5", args[7]);
						y.set("answer1", 0);
						y.set("answer2", 0);
						y.set("answer3", 0);
						y.set("answer4", 0);
						y.set("answer5", 0);
						y.save(f);
						p.sendMessage("�벼�إߦ��\!");
					}
					else
					{
						dir.mkdir();
						File f = new File((v.getDataFolder() + File.separator + "data" + File.separator + args[1]) + ".yml");
						f.createNewFile();
						YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
						y.set("title", args[2]);
						y.set("choice1", args[3]);
						y.set("choice2", args[4]);
						y.set("choice3", args[5]);
						y.set("choice4", args[6]);
						y.set("choice5", args[7]);
						y.set("answer1", 0);
						y.set("answer2", 0);
						y.set("answer3", 0);
						y.set("answer4", 0);
						y.set("answer5", 0);
						y.save(f);
						p.sendMessage("�벼�إߦ��\!");
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if (args.length == 2 && args[0].equalsIgnoreCase("del") && p.hasPermission(configy.getString("permission.vt.del")))
			{
				try
				{
					File f = new File((v.getDataFolder() + File.separator + "data" + File.separator + args[1] + ".yml"));
					if (f.exists())
					{
						f.delete();
						p.sendMessage("�R���벼���\!");
					}
					else
					{
						p.sendMessage("���벼���s�b!");
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if (args.length == 2 && args[0].equalsIgnoreCase("end") && p.hasPermission(configy.getString("permission.vt.end")))
			{
				try
				{
					File f = new File((v.getDataFolder() + File.separator + "data" + File.separator + args[1] + ".yml"));
					if (f.exists())
					{
						YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
						p.sendMessage("�H�U�O�벼���G:");
						p.sendMessage("���" + y.getString("choice1") + "���H��" + y.getInt("choice1"));
						p.sendMessage("���" + y.getString("choice2") + "���H��" + y.getInt("choice2"));
						p.sendMessage("���" + y.getString("choice3") + "���H��" + y.getInt("choice3"));
						p.sendMessage("���" + y.getString("choice4") + "���H��" + y.getInt("choice4"));
						p.sendMessage("���" + y.getString("choice5") + "���H��" + y.getInt("choice5"));
						f.delete();
						p.sendMessage("�I��벼���\!");
					}
					else
					{
						p.sendMessage("���벼���s�b!");
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if (args.length == 1 && args[0].equalsIgnoreCase("check") && p.hasPermission(configy.getString("permission.vt.check")))
			{
				File f = new File((v.getDataFolder() + File.separator + "data"));
				if (f.exists())
				{
					p.sendMessage("�H�U�O���b�i�檺�벼:");
					p.sendMessage(f.list());
				}
				else
				{
					p.sendMessage("�S�����b�i�檺�벼!");
				}

			}
		}
		
		return false;
	}
	
}
