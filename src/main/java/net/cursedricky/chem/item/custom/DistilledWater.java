package net.cursedricky.chem.item.custom.elements;

import net.cursedricky.chem.block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

public class NitricAcid extends Item {

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.chem.nitric_acid"));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public NitricAcid(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();
            Player player = pContext.getPlayer();
            ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
            InteractionHand hand = pContext.getHand();

            if(blockClicked.equals(ModBlocks.FLASK.get())) {
                level.setBlock(positionClicked, ModBlocks.NITRIC_ACID_FLASK.get().defaultBlockState(), 3);
                if (!player.isCreative()) {
                    if (hand.equals(InteractionHand.MAIN_HAND)) {
                        player.setItemInHand(InteractionHand.MAIN_HAND, itemstack);
                    } else {
                        player.setItemInHand(InteractionHand.OFF_HAND, itemstack);
                    }
                }
            }
        }

        return InteractionResult.SUCCESS;
    }

}
