package org.red5.server.net.rtmp.event;

/*
 * RED5 Open Source Flash Server - http://www.osflash.org/red5
 * 
 * Copyright (c) 2006 by respective authors (see below). All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or modify it under the 
 * terms of the GNU Lesser General Public License as published by the Free Software 
 * Foundation; either version 2.1 of the License, or (at your option) any later 
 * version. 
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along 
 * with this library; if not, write to the Free Software Foundation, Inc., 
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA 
 */

public class BytesRead extends BaseEvent {

	private int bytesRead = 0;

	public BytesRead(int bytesRead) {
		super(Type.STREAM_CONTROL);
		this.bytesRead = bytesRead;
	}

	@Override
	public byte getDataType() {
		return TYPE_BYTES_READ;
	}

	public int getBytesRead() {
		return bytesRead;
	}

	public void setBytesRead(int bytesRead) {
		this.bytesRead = bytesRead;
	}

	protected void doRelease() {
		bytesRead = 0;
	}

	@Override
	public String toString() {
		return "StreamBytesRead: " + bytesRead;
	}

	@Override
	protected void releaseInternal() {

	}

}