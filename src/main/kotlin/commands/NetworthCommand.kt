package sh.lumin.skysim.commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import sh.lumin.skysim.utils.Utils
import sh.lumin.skysim.utils.evaluators.PlayerEvaluator
import java.awt.Color


/*
event.hook.setEphemeral(true).sendMessageEmbeds(
                    EmbedBuilder().setTitle("Player does not exist")
                        .setDescription("That player does not exist!")
                )
 */
class NetworthCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if(event.name == "networth") {
            event.deferReply().queue()
            //
            val username = event.getOption("username")!!.asString
            //
            val (networth, topItems, catValues) = PlayerEvaluator.valuePlayer(username)
            //
            val embedBuilder = EmbedBuilder()
            embedBuilder.run {
                setTitle("$username's Networth")
                setDescription("Networth **${Utils.commaify(networth)}** (**${Utils.formatNumber(networth)}**)")
                setColor(Color.decode("#b642f5"))
                setThumbnail("https://visage.surgeplay.com/full/832/$username.png?no=cape,shadow")
            }
            //
            if(catValues.containsKey("purse") && catValues.containsKey("coins") && catValues.containsKey("bank")) {
                embedBuilder.addField("<:bits:1239342143986991144> Bits", "**${Utils.formatNumber(catValues["purse"]!!)}**", true)
                embedBuilder.addField("<:coins:1239342531091759165> Coins", "**${Utils.formatNumber(catValues["coins"]!!)}**", true)
                embedBuilder.addField("<:bankc:1239342529627820123> Bank", "**${Utils.formatNumber(catValues["bank"]!!)}**", true)
            }
            // Armor/Wardrobe
            if(catValues.containsKey("armor")) {
                val armorTop = topItems["armor"]!!.toMutableList()
                var worth = catValues["armor"]!!
                //
                if(catValues.containsKey("wardrobe")) {
                    armorTop.addAll(topItems["wardrobe"]!!)
                    worth += catValues["wardrobe"]!!
                }
                //
                val msg = armorTop.asSequence().sortedByDescending { it.second }.take(5).map { it.first }.toList().joinToString("\n")
                //
                embedBuilder.addField("Armor (**${Utils.formatNumber(worth)}**)", msg, false)
            }
            // Inventory
            if(catValues.containsKey("inventory")) {
                val msg = topItems["inventory"]!!.map { it.first }.toList().joinToString("\n")
                //
                embedBuilder.addField("Inventory (**${Utils.formatNumber(catValues["inventory"]!!)}**)", msg, false)
            }
            // Pets
            if(catValues.containsKey("pets")) {
                val msg = topItems["pets"]!!.map { it.first }.toList().joinToString("\n")
                embedBuilder.addField("Pets (**${Utils.formatNumber(catValues["pets"]!!)}**)", msg, false)
            }
            // Storage
            if(catValues.containsKey("vaults")) {
                val vaultsTop = (topItems["vaults"] ?: listOf()).toMutableList()
                var worth = catValues["vaults"] ?: 0
                //
                if(catValues.containsKey("enderchest")) {
                    vaultsTop.addAll(topItems["enderchest"]!!)
                    worth += catValues["enderchest"]!!
                }
                //
                val msg = vaultsTop.asSequence().sortedByDescending { it.second }.take(5).map { it.first }.toList().joinToString("\n")
                //
                embedBuilder.addField("Storage (**${Utils.formatNumber(worth)}**)", msg, false)
            }
            //
            event.hook.sendMessageEmbeds(embedBuilder.build()).queue()

        }
    }
}