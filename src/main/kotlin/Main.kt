package sh.lumin.skysim

import io.github.cdimascio.dotenv.Dotenv
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.requests.GatewayIntent
import sh.lumin.skysim.commands.NWLeaderboardCommand
import sh.lumin.skysim.commands.NetworthCommand

val dotenv : Dotenv = Dotenv.load()

val SS_API: String = dotenv.get("SKYSIM_API")

fun main() {
    val jda = JDABuilder.createLight(dotenv.get("BOT_TOKEN"), GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.MESSAGE_CONTENT).build()

    jda.presence.activity = Activity.watching("Skysim")

    jda.updateCommands().addCommands(
        Commands.slash("networth", "Gets the networth of the specified player.")
            .addOption(OptionType.STRING, "username", "The username of the player"),
        Commands.slash("nwleaderboard", "Lists a leaderboard")
    ).queue()

    jda.addEventListener(NetworthCommand(), NWLeaderboardCommand())

}