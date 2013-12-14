package com.creatifcubed.minecraft.siliconangels.models;

import com.creatifcubed.minecraft.siliconangels.SiliconAngels;
import com.creatifcubed.minecraft.siliconangels.network.SetActiveItemOrBlock;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.MovementInput;
import _root_.cpw.mods.fml.relauncher.{ Side, SideOnly };

@SideOnly(Side.CLIENT)
class EntryPlugZero(val pilot: IPilot) extends IEntryPlug {
  
  var movementInputVanilla: MovementInput = null;
  
  val movementInput: MovementInputFromCode = new MovementInputFromCode();
  
  override def start(): Unit = {
    this.pilot.synchronized {
      SiliconAngels.proxy.startEntryPlug(this);
    }
  }
  
  override def stop(): Unit = {
    this.pilot.synchronized {
      SiliconAngels.proxy.stopEntryPlug(this);
    }
  }
  
  var i = 0;
  override def onTick(): Unit = {
    if (i % 20 == 0) {
      this.setActiveItemOrBlock(1);
    }
    i += 1;
  }
  
  def faceDirection(degrees: Int): Unit = {
    return;
  }
  
  def setActiveItemOrBlock(itemOrBlockId: Int): Unit = {
    this.pilot.player.sendQueue.addToSendQueue(SiliconAngels.packetFactory.serializeJson(SiliconAngels.MOD_NETWORKCHANNEL_B, new SetActiveItemOrBlock(3)));
  }
}