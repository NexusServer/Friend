package friend;

import java.io.File;
import java.util.LinkedHashMap;

import cn.nukkit.plugin.Plugin;
import cn.nukkit.utils.Config;

public class DataBase {

	private Plugin plugin;
	private LinkedHashMap<String, Object> FriendDB;

	public DataBase(Plugin plugin) {
		this.plugin = plugin;
		plugin.getDataFolder().mkdirs();

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
}
