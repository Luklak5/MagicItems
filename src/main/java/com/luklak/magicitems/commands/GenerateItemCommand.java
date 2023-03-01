package com.luklak.magicitems.commands;

import com.luklak.magicitems.attributes.ItemModification;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.luklak.magicitems.other.Tools.randomEquipment;
import static com.luklak.magicitems.other.Tools.spawnItem;

public class GenerateItemCommand
{

    ItemModification im = new ItemModification();

    public GenerateItemCommand(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("generateitem").executes((command) -> {
            return GenerateItem(command.getSource());
        }));
    }

    private int GenerateItem(CommandSourceStack source) throws CommandSyntaxException
    {
        ServerPlayer player = source.getPlayerOrException();
        BlockPos pos = player.getOnPos();
        Level level = player.getLevel();
        ItemStack item = randomEquipment();
        item = im.generateStats(item);
        spawnItem(level, pos, item);
        return 1;
    }
}
