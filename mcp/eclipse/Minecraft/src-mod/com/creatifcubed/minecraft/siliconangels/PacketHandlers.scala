package com.creatifcubed.minecraft.siliconangels;

import _root_.cpw.mods.fml.common.network.{ IPacketHandler, Player, ITinyPacketHandler, PacketDispatcher };
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.{ Packet250CustomPayload, Packet131MapData, NetHandler };
import net.minecraft.entity.player.EntityPlayer;

import com.creatifcubed.minecraft.siliconangels.network.PacketFactory;
import com.creatifcubed.minecraft.siliconangels.network.ModCommand;

class RegularPacketHandler extends IPacketHandler {
  val handlers: Map[String, ChannelHandler] = Map(SiliconAngels.MOD_NETWORKCHANNEL_A -> new ChannelAHandler());
  
  def onPacketData(manager: INetworkManager, packet: Packet250CustomPayload, player: Player): Unit = {
    this.handlers.get(packet.channel) match {
      case Some(handler) => handler.onPacketData(manager, packet, player.asInstanceOf[EntityPlayer]);
      case None => SiliconAngels.log.info(String.format("Unknown channel {%s}", packet.channel));
    }
  }
}

class TinyPacketHandler extends ITinyPacketHandler {
  def handle(handler: NetHandler, mapData: Packet131MapData): Unit = {
    return;
  }
}

trait ChannelHandler {
  def onPacketData(manager: INetworkManager, packet: Packet250CustomPayload, player: EntityPlayer): Unit;
}

class ChannelAHandler extends ChannelHandler {
  def onPacketData(manager: INetworkManager, packet: Packet250CustomPayload, player: EntityPlayer): Unit = {
    val modCommand = SiliconAngels.packetFactory.deserializeJson(packet.data, classOf[ModCommand]);
    SiliconAngels.log.info("Mod command sent: %s - %s. World is remote: %b".format(modCommand.modId, modCommand.args.mkString(", "), player.worldObj.isRemote));
  }
}