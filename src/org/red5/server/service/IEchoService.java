package org.red5.server.service;

/*
 * RED5 Open Source Flash Server - http://www.osflash.org/red5
 * 
 * Copyright � 2006 by respective authors. All rights reserved.
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
 * 
 * @author The Red5 Project (red5@osflash.org)
 * @author Chris Allen (mrchrisallen@gmail.com)
 */

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

/**
 * The Echo service is used to test all of the different datatypes 
 * and to make sure that they are being returned properly.
 */
public interface IEchoService {
	
	/**
	 * Used to verify that Spring has loaded the bean.
	 *
	 */
	public abstract void startUp(); 
	
	/**
	 * Verifies that a boolean that is passed in returns correctly.
	 * 
	 * @param bool
	 * @return
	 */
	public abstract boolean echoBoolean(boolean bool);

	/**
	 * Verifies that a Number that is passed in returns correctly.
	 * 
	 * Flash Number = double
	 * 
	 * @param num
	 * @return
	 */
	public abstract double echoNumber(double num);

	/**
	 * Verifies that a String that is passed in returns correctly.
	 * 
	 * @param string
	 * @return
	 */
	public abstract String echoString(String string);

	/**
	 * Verifies that a Date that is passed in returns correctly.
	 * 
	 * @param date
	 * @return
	 */
	public abstract Date echoDate(Date date);

	/**
	 * Verifies that a Flash Object that is passed in returns correctly.
	 * Flash Object = java.utils.Map
	 * 
	 * @param obj
	 * @return
	 */
	public abstract Map echoObject(Map obj);

	/**
	 * Verifies that a Flash simple Array that is passed in returns correctly.
	 * Flash simple Array = Object[]
	 * 
	 * @param array
	 * @return
	 */
	public abstract Object[] echoArray(Object[] array);

	/**
	 * Verifies that a Flash multi-dimensional Array that is passed in returns itself.
	 * Flash multi-dimensional Array = java.utils.List
	 * 
	 * @param list
	 * @return
	 */
	public abstract List echoList(List list);

	/**
	 * Verifies that Flash XML that is passed in returns itself.
	 * Flash XML = org.w3c.dom.Document
	 * 
	 * @param xml
	 * @return
	 */
	public abstract Document echoXML(Document xml);

}