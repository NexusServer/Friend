package friend;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.TextFormat;
import friend.manage.Manage;

public class EventListener implements Listener {

	private Main plugin;

	public EventListener(Main plugin) {
		this.plugin = plugin;
	}

	public Main getPlugin() {
		return plugin;
	}

	public DataBase getDataBase() {
		return plugin.getDataBase();
	}

	public Manage getManage() {
		return plugin.getManage();
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		if (getManage().isFirst(event.getPlayer())) {
			event.getPlayer().sendMessage("친구 데이터가 존재하지 않습니다... 데이터를 불러올 수 없습니다");

		} else {
			getManage().onJoin(event.getPlayer());
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!command.getName().equals("친구")) {
			return true;
		}

		if (args.length <= 0) {
			sender.sendMessage(this.getMaunal());
			return true;
		}

		switch (args[0]) {
		case "request":
		case "신청":
			getManage().requestFriend(args[1], sender.getName());

			break;
		case "del":
		case "삭제":
			if (args.length < 1 || args[1] == null) {
				sender.sendMessage(this.getMaunal());
				return true;
			}
			if (getManage().isFriend(sender.getName(), args[1])) {
				getManage().delFriend(sender.getName(), args[1]);
				sender.sendMessage(TextFormat.colorize(args[1] + "님이 친구목록에서 삭제되었습니다"));
				return true;
			} else {
				sender.sendMessage(args[1] + "님과 친구가 아닙니다");
				return true;
			}
		case "list":
		case "목록":
			sender.sendMessage(getManage().getFriends(sender.getName()).stream()
					.reduce((fir, sen) -> "§f" + fir + "    §8" + sen + "\n").get());
			sender.sendMessage("친구신청목록==========");
			sender.sendMessage(getManage().getRequester(sender.getName()).stream()
					.reduce((fir, sen) -> "§f" + fir + "    §8" + sen + "\n").get());
			return true;

		case "help":
		case "도움말":
			sender.sendMessage(this.getMaunal());
			return true;
		}

		return false;

	}

	private String getMaunal() {
		String str = "";
		str = str + "";

		return str;
	}
}
