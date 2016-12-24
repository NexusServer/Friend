package friend.manage;

import friend.DataBase;
import friend.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class Request {

	private Main plugin;

	private static HashMap<CommandSender, Integer> step;

	public static final int NO_DATA = 0;

	public static final int NAME_SET = 1;
	public static final int EXECUTE_SET = 2;

	public static final int DEL_EXECUTE = 3;
	public static final int ADD_EXECUTE = 4;
	public static final int LIST_EXECUTE = 5;

	public Request(Main plugin) {
		this.plugin = plugin;
	}

	public DataBase getDataBase() {
		return this.plugin.getDataBase();
	}

	public Manage getManage() {
		return plugin.getManage();
	}

	public List<String> getRequester(String player) {
		return (List<String>) getDataBase().RequestDB.getOrDefault(player.toLowerCase(), null);
	}

	public int getStep(String player) {
		return step.getOrDefault(plugin.getServer().getPlayer(player), NO_DATA);
	}

}
