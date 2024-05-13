package sh.lumin.skysim.commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class NWLeaderboardCommand : ListenerAdapter()  {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if(event.name == "nwleaderboard") {
            val builder = EmbedBuilder()
            builder.run {
                setTitle("test")
            }
            for (i in 0..12) {
                builder.addField("#$i", "N/A", true)
            }

            event.replyEmbeds(builder.build()).queue()
        }
    }
}