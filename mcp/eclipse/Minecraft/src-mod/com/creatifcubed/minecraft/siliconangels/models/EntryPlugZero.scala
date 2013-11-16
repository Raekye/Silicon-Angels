package com.creatifcubed.minecraft.siliconangels.models;

import com.creatifcubed.minecraft.siliconangels.SiliconAngels;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.MovementInput;

class EntryPlugZero(val pilot: IPilot) extends IEntryPlug {
  
  @SideOnly(Side.CLIENT)
  var movementInputVanilla: MovementInput = null;
  
  val movementInput: MovementInputFromCode = new MovementInputFromCode();
  
  def start(): Unit = {
    this.pilot.synchronized {
      SiliconAngels.proxy.startEntryPlug(this);
    }
  }
  
  def stop(): Unit = {
    this.pilot.synchronized {
      SiliconAngels.proxy.stopEntryPlug(this);
    }
  }
  
  def faceDirection(degrees: Int): Unit = {
    return;
  }
  
  
}