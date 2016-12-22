package friend;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.nukkit.Player;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.utils.Config;

public class DataBase {

	private Main plugin;
	private LinkedHashMap<String, Object> FriendDB;

	public DataBase(Main plugin) {
		this.plugin = plugin;
		plugin.getDataFolder().mkdirs();
		this.initDB();

	}

	public void initDB() {
		FriendDB = (LinkedHashMap<String, Object>) new Config(new File(plugin.getDataFolder(), "Friend.json"),
				Config.JSON).getAll();

	}

	public void save() {
		Config FriendDB = new Config(new File(plugin.getDataFolder(), "Friend.json"), Config.JSON);
		FriendDB.setAll(this.FriendDB);
		FriendDB.save();
	}
	
	public void registerCommand(String name, String description, String usage, String permission) {
		SimpleCommandMap commandMap = this.plugin.getServer().getCommandMap();
		PluginCommand<Main> command = new PluginCommand<Main>(name, plugin);
		command.setDescription(description);
		command.setUsage(usage);
		command.setPermission(permission);
		commandMap.register(name, command);
	}
	
	
	
	

	@SuppressWarnings("unchecked")
	public Map<String, Object> get(String player) {
		return ((Map<String, Object>) this.FriendDB.get(player.toLowerCase()));
	}

	public Map<String, Object> get(Player player) {
		return this.get(player.getName());
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Player> getFriend(String player) {
		ArrayList<Player> friend = new ArrayList<>();

		for (String str : (List<String>) this.get(player.toLowerCase()).get("friends")) {
			friend.add(plugin.getServer().getPlayer(str));
		}
		return friend;
	}

	public ArrayList<Player> getFriend(Player player) {
		return this.getFriend(player.getName().toLowerCase());
	}

}
