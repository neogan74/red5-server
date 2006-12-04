package org.red5.server.api.service;

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

import java.util.Set;

/**
 * IPendingServiceCall is a call that have a list of callbacks.
 * 
 *
 */
public interface IPendingServiceCall extends IServiceCall {

	/**
	 * Returns service call result
	 * 
	 * @return	
	 */
	public abstract Object getResult();

	public abstract void setResult(Object result);

	/**
	 * Registers callback object usually represented as an anonymous class
	 * instance that implements IPendingServiceCallback interface.
	 *  
	 * @param callback
	 *            Callback object
	 */
	public void registerCallback(IPendingServiceCallback callback);

	/**
	 * Unregisters callback object usually represented as an anonymous class
	 * instance that implements IPendingServiceCallback interface.
	 *  
	 * @param callback
	 *            Callback object
	 */
	public void unregisterCallback(IPendingServiceCallback callback);

	/**
	 * Returns list of callback objects, usually callback object represented as
	 * an anonymous class instance that implements IPendingServiceCallback
	 * interface.
	 *  
	 * @param callback
	 *            Callback object
	 */
	public Set<IPendingServiceCallback> getCallbacks();
}