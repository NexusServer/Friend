package friend;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
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

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equals("친구")) {
			if (args.length < 1 || args == null) {
				sender.sendMessage(getMaunal());
				return true;
			}

			switch (args[0]) {
			case "추가":
				if (args.length < 2) {
					sender.sendMessage("추가할 대상을 입력하여 주십시요");
					return true;
				}
				if (getManage().friendExist(sender.getName())) {
					getManage().register((Player) sender);

				}
				if (getManage().isFriend(sender.getName(), args[1])) {
					sender.sendMessage("이미 친구인 사람입니다");
					return true;
				}
				getManage().addFriend(sender.getName(), args[1]);
				return true;

			case "삭제":
				break;
			case "목록":

				break;
			case "관리":

				break;
			case "워프요청":
				if (args.length < 2) {
					sender.sendMessage("요청할 상대를 입력해주십시요");
					return true;
				}
				if (getManage().isFriend(sender.getName(), args[1])
						&& getManage().isFriend(args[1], sender.getName())) {

					if (plugin.getServer().getPlayer(args[1]).isOnline()) {
						getManage().warpRequest((Player) sender, args[1]);
						plugin.getServer().getPlayer(args[1])
								.sendMessage(sender.getName() + "님이 워프를 요청하였습니다 수락하시려면 채팅창에 \"수락\"을, 그렇지 않으면 ");
					} else {
						sender.sendMessage("대상이 오프라인입니다");
						return true;
					}
				} else {
					sender.sendMessage("워프요청은 서로 친구여야만 가능합니다");
					return true;
				}

			}

		}

		return false;

	}

	@EventHandler
	public void onWarpRequest(PlayerChatEvent event) {
		if (getManage().isTarget(event.getPlayer())) {
			if (event.getMessage().equals("수락")) {
				getManage().accept(event.getPlayer());
			} else {
				getManage().refuse(event.getPlayer());
			}
		}
	}

	private String getMaunal() {
		String str = "";
		str = str + "";

		return str;
	}
}
