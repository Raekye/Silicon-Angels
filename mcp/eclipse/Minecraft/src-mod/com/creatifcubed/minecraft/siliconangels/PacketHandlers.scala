package com.creatifcubed.minecraft.siliconangels;

import cpw.mods.fml.common.network.{ IPacketHandler, Player, ITinyPacketHandler };
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.{ Packet250CustomPayload, Packet131MapData, NetHandler };

class RegularPacketHandler extends IPacketHandler {
  def onPacketData(manager: INetworkManager, packet: Packet250CustomPayload, player: Player): Unit = {
    ;
  }
}

class TinyPacketHandler extends ITinyPacketHandler {
  def handle(handler: NetHandler, mapData: Packet131MapData): Unit = {
    
  }
}