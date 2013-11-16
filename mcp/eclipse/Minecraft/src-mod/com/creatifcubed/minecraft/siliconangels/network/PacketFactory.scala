package com.creatifcubed.minecraft.siliconangels.network;

import java.io.{ IOException, InputStream };

import net.minecraft.network.packet.Packet250CustomPayload;

import com.google.common.base.Charsets;
import com.google.common.io.{ ByteStreams, Closeables };
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

class PacketFactory(val gson: Gson = new Gson()) {
  
  def serialize(channel: String, data: AnyRef): Packet250CustomPayload = {
    return new Packet250CustomPayload(channel, this.gson.toJson(data).getBytes(Charsets.UTF_8));
  }
  
  @throws(classOf[IOException])
  def deserialize[T](is: InputStream, clazz: Class[T]): T = {
    return this.gson.fromJson(new String(ByteStreams.toByteArray(is), Charsets.UTF_8), clazz);
  }
}