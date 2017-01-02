 package friend;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import friend.manage.Manage;

public class Main extends PluginBase {

	private DataBase dataBase;
	private Manage manage;
	private EventListener listener;

	@Override
	public void onEnable() {
		this.getLogger().info("[Loading] Plugin Loading...");
		this.listener = new EventListener(this);
		this.getServer().getPluginManager().registerEvents(listener, this);
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

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return listener.onCommand(sender, command, label, args);
	}

}
