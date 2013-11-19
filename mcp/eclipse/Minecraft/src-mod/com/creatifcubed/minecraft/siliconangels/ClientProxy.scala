package com.creatifcubed.minecraft.siliconangels;

import com.creatifcubed.minecraft.siliconangels.models.{ IEntryPlug, EntryPlugZero };

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import _root_.cpw.mods.fml.client.registry.KeyBindingRegistry;

class ClientProxy extends CommonProxy {
  
  override def startEntryPlug(entryPlug: IEntryPlug): Unit = {
    if (entryPlug.isInstanceOf[EntryPlugZero]) {
      val entryPlugZero = entryPlug.asInstanceOf[EntryPlugZero];
      val player = entryPlugZero.pilot.player.asInstanceOf[EntityPlayerSP];
      entryPlugZero.movementInputVanilla = player.movementInput;
      player.movementInput = entryPlugZero.movementInput;
    }
  }
  
  override def stopEntryPlug(entryPlug: IEntryPlug): Unit = {
    if (entryPlug.isInstanceOf[EntryPlugZero]) {
      val entryPlugZero = entryPlug.asInstanceOf[EntryPlugZero];
      val player = entryPlugZero.pilot.player.asInstanceOf[EntityPlayerSP];
      player.movementInput = entryPlugZero.movementInputVanilla;
      entryPlugZero.movementInputVanilla = null;
    }
  }
  
  override def registerRegistries(): Unit = {
    super.registerRegistries();
    KeyBindingRegistry.registerKeyBinding(new KeyHandler());
  }
}