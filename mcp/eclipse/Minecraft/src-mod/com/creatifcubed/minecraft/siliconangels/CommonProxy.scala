package com.creatifcubed.minecraft.siliconangels;

import com.creatifcubed.minecraft.siliconangels.models.{ IEntryPlug, EntryPlugZero };

import net.minecraft.entity.player.EntityPlayer;
import _root_.cpw.mods.fml.relauncher.{ Side, SideOnly };

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
    return;
  }
}