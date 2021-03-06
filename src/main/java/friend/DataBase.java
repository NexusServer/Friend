package friend;

import java.io.File;
import java.util.LinkedHashMap;

import cn.nukkit.command.PluginCommand;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.utils.Config;

public class DataBase {

	public Main plugin;
	public LinkedHashMap<String, Object> FriendDB;

	public DataBase(Main plugin) {
		this.plugin = plugin;
		plugin.getDataFolder().mkdirs();
		this.initDB();
		this.registerCommands();

	}

	public void initDB() {
		FriendDB = (LinkedHashMap<String, Object>) new Config(new File(plugin.getDataFolder(), "Friend.json"),
				Config.JSON).getAll();

	}

	public void save() {
		Config FriendDB = new Config(new File(plugin.getDataFolder(), "Friend.json"), Config.JSON);
		FriendDB.setAll((LinkedHashMap<String, Object>)this.FriendDB);
		FriendDB.save();
		
	}

	public void registerCommands() {
		this.registerCommand("친구", "친구관리", "관리 친구", "true");
	}

	public void registerCommand(String name, String description, String usage, String permission) {
		SimpleCommandMap commandMap = this.plugin.getServer().getCommandMap();
		PluginCommand<Main> command = new PluginCommand<Main>(name, plugin);
		command.setDescription(description);
		command.setUsage(usage);
		command.setPermission(permission);
		commandMap.register(name, command);
	}

	/*
	 * @SuppressWarnings("unchecked") public Map<String, Object> get(String
	 * player) { return ((Map<String, Object>)
	 * this.FriendDB.get(player.toLowerCase())); }
	 * 
	 * public Map<String, Object> get(Player player) { return
	 * this.get(player.getName()); }
	 * 
	 * @SuppressWarnings("unchecked") public ArrayList<Player> getFriend(String
	 * player) { ArrayList<Player> friend = new ArrayList<>();
	 * 
	 * for (String str : (List<String>)
	 * this.get(player.toLowerCase()).get("friends")) {
	 * friend.add(plugin.getServer().getPlayer(str)); } return friend; }
	 * 
	 * public ArrayList<Player> getFriend(Player player) { return
	 * this.getFriend(player.getName().toLowerCase()); }
	 */

}
