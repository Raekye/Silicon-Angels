package com.creatifcubed.minecraft.siliconangels;

import com.creatifcubed.minecraft.siliconangels.models.{ IEntryPlug, EntryPlugZero };

import net.minecraft.entity.player.EntityPlayer;
import _root_.cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

class CommonProxy {
  
  def startEntryPlug(entryPlug: IEntryPlug): Unit = {
    if (entryPlug.isInstanceOf[EntryPlugZero]) {
      return;
    }
  }
  
  def stopEntryPlug(entryPlug: IEntryPlug): Unit = {
    if (entryPlug.isInstanceOf[EntryPlugZero]) {
      return;
    }
  }
  
  def registerRegistries(): Unit = {
    TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);
  }
}