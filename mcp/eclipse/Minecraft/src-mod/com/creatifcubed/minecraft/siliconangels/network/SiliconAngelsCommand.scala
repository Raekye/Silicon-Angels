package com.creatifcubed.minecraft.siliconangels.network;

import com.creatifcubed.minecraft.siliconangels.SiliconAngels;

import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.{ Player, PacketDispatcher };

import net.minecraft.command.{ CommandBase, ICommandSender };

class SiliconAngelsCommand extends CommandBase{
  
  override def getCommandName(): String = {
    return "siangels";
  }
  
  override def getCommandUsage(icommandsender: ICommandSender): String = {
    return "siangels <action> <mod id> <arguments>";
  }
  
  override def processCommand(icommandsender: ICommandSender, args: Array[String]): Unit = {
    icommandsender match {
      case player: EntityPlayerMP => {
        var x = 10;
        PacketDispatcher.sendPacketToPlayer(SiliconAngels.packetFactory.serializeJson(
                SiliconAngels.MOD_NETWORKCHANNEL_A, new ModCommand("test", Array("1, 2, 3")))
                , player.asInstanceOf[Player]);
        SiliconAngels.log.info("World is remote %b".format(player.worldObj.isRemote));
      };
      case _ => throw new ClassCastException();
    }
  }
  
}