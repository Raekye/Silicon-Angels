package com.creatifcubed.minecraft.siliconangels.network;

import net.minecraft.command.{ CommandBase, ICommandSender };

class SiliconAngelsCommand extends CommandBase{
  
  override def getCommandName(): String = {
    return "siangels";
  }
  
  override def getCommandUsage(icommandsender: ICommandSender): String = {
    return "siangels <action> <mod id> <arguments>";
  }
  
  override def processCommand(icommandsender: ICommandSender, args: Array[String]): Unit = {
    return;
  }
  
}