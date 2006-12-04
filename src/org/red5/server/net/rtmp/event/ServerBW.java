package org.red5.server.net.rtmp.event;

public class ServerBW extends BaseEvent {

	private int bandwidth = 0;

	public ServerBW(int bandwidth) {
		super(Type.STREAM_CONTROL);
		this.bandwidth = bandwidth;
	}

	@Override
	public byte getDataType() {
		return TYPE_SERVER_BANDWIDTH;
	}

	public int getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}

	@Override
	public String toString() {
		return "ServerBW: " + bandwidth;
	}

	@Override
	protected void releaseInternal() {

	}

}