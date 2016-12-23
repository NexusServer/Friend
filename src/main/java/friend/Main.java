package friend;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import friend.manage.Manage;

public class Main extends PluginBase implements Listener {

	private DataBase dataBase;
	private Manage manage;

	@Override
	public void onEnable() {
		this.getLogger().info("[Loading] Plugin Loading...");
		this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
		this.getLogger().info("[Loading] Plugin Data Loading...");
		this.dataBase = new DataBase(this);
		this.manage = new Manage(this);
	}

	@Override
	public void onDisable() {
		this.dataBase.save();
	}

	public DataBase getDataBase() {
		return this.dataBase;
	}

	public Manage getManage() {
		return this.manage;
	}

}
