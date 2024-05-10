package com.hj.myrpc.protocol.entity;

public class HeartBeatMessage {
    public static final byte BEAT_MESSAGE=(byte)1;

    public static final byte[] BEAT_BYTE=new byte[]{BEAT_MESSAGE};

    //单例
    private HeartBeatMessage(){}

    public static boolean isHeartBeatMessage(byte[] message){
        return(message!=null&&message.length==1&&message[0]==BEAT_MESSAGE);
    }

    public static byte[] getHeartBeatMessage(){
        return BEAT_BYTE;
    }
}
