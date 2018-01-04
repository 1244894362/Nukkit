package cn.nukkit.server.network.protocol;

import cn.nukkit.server.math.Vector3;

/**
 * Created on 15-10-14.
 */
public class MovePlayerPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.MOVE_PLAYER_PACKET;

    public long eid;
    public float x;
    public float y;
    public float z;
    public float yaw;
    public float headYaw;
    public float pitch;
    public MoveMode mode = MoveMode.NORMAL;
    public boolean onGround;
    public long ridingEid;
    public int int1 = 0;
    public int int2 = 0;

    @Override
    public void decode() {
        this.eid = this.getEntityRuntimeId();
        Vector3 v = this.getVector3f();
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        this.pitch = this.getLFloat();
        this.headYaw = this.getLFloat();
        this.yaw = this.getLFloat();
        this.mode = MoveMode.values()[this.getByte()];
        this.onGround = this.getBoolean();
        this.ridingEid = this.getEntityRuntimeId();
        if (this.mode == MoveMode.TELEPORT) {
            this.int1 = this.getLInt();
            this.int2 = this.getLInt();
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putEntityRuntimeId(this.eid);
        this.putVector3f(this.x, this.y, this.z);
        this.putLFloat(this.pitch);
        this.putLFloat(this.yaw);
        this.putLFloat(this.headYaw);
        this.putByte((byte) this.mode.ordinal());
        this.putBoolean(this.onGround);
        this.putEntityRuntimeId(this.ridingEid);
        if (this.mode == MoveMode.TELEPORT) {
            this.putLInt(this.int1);
            this.putLInt(this.int2);
        }
    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public enum MoveMode {
        NORMAL,
        RESET,
        TELEPORT,
        PITCH //facepalm Mojang
    }
}
