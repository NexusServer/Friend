package friend;

import java.io.File;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class Main extends PluginBase implements Listener {

	@Override
	public void onEnable() {
		this.getLogger().info("[Loading] Plugin Loading...");
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getLogger().info("[Loading] EventHandler... success!");
		Config data = new Config(new File(this.getDataFolder(), "friend.json"), Config.JSON);
		this.getLogger().info("[Loading] Plugin Data Loading...");
	}

}
