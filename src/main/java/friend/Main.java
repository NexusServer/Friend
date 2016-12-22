package friend;

import java.io.File;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class Main extends PluginBase implements Listener {

	DataBase dataBase;

	@Override
	public void onEnable() {
		this.getLogger().info("[Loading] Plugin Loading...");
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getLogger().info("[Loading] Plugin Data Loading...");
		dataBase = new DataBase(this);
		
	}

	@Override
	public void onDisable() {
		this.dataBase.save();
	}
	public DataBase getDataBase(){
		return this.dataBase;
	} 
}
