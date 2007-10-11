package org.red5.server.zcontext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.red5.io.flv.impl.FLVService;
import org.red5.server.persistence2.IPersistentStorage;
import org.red5.server.persistence2.RamPersistence;
import org.red5.server.service.ServiceInvoker;
import org.red5.server.stream.StreamManager;
import org.red5.server.stream.VideoCodecFactory;
import org.springframework.beans.BeansException;

public class AppContext 
	extends ZBaseContext {
	
	public static final String APP_CONFIG = "app.xml";
	public static final String APP_SERVICE_NAME = "appService";
	public static final String SO_PERSISTENCE_NAME = "sharedObjectPersistence";
	public static final String STREAM_MANAGER_NAME = "streamManager";
	public static final String VIDEO_CODEC_FACTORY = "videoCodecFactory";
	public static final String SCOPE_MAPPING = "scopeMapping";
	
	protected String appPath;
	protected String appName;
	protected HostContext host;
		
	protected static Log log =
        LogFactory.getLog(AppContext.class.getName());
	
	public AppContext(HostContext host, String appName, String appPath) throws BeansException {
		super(host, appPath, appPath + "/" + APP_CONFIG ); 
		this.appName = appName;
		this.appPath = appPath;
	}
	
	public void initialize() {
		
		super.initialize();
		
		StreamManager streamManager = null;
		if(!this.containsBean(STREAM_MANAGER_NAME)){
			streamManager = new StreamManager();
			this.getBeanFactory().registerSingleton(STREAM_MANAGER_NAME, streamManager);
			
			//streamManager.initialize();
			streamManager.setApplicationContext(this);
			// this will need to be refactored
			streamManager.setFlvService(new FLVService());
		} else {
			streamManager = (StreamManager) this.getBean(STREAM_MANAGER_NAME);
		}
		
		ZBaseApplication app = null;
		if(!this.containsBean(APP_SERVICE_NAME)){
			app = new ZBaseApplication();
			app.setApplicationContext(this);
			this.getBeanFactory().registerSingleton(APP_SERVICE_NAME, app);
			app.setStreamManager(streamManager);
			app.initialize();
		} else {
			app = (ZBaseApplication) this.getBean(APP_SERVICE_NAME);
			app.setApplicationContext(this);
			app.setStreamManager(streamManager);
			app.initialize();
		}
		
		IPersistentStorage soPersistence = null;
		if(!this.containsBean(SO_PERSISTENCE_NAME)){
			soPersistence = new RamPersistence();
			soPersistence.setApplicationContext(this);
			app.setSharedObjectPersistence(soPersistence);
		} else {
			soPersistence = (IPersistentStorage) this.getBean(SO_PERSISTENCE_NAME);
			soPersistence.setApplicationContext(this);
			app.setSharedObjectPersistence(soPersistence);
		}
		
		if (this.containsBean(VIDEO_CODEC_FACTORY)){
			VideoCodecFactory videoFactory = (VideoCodecFactory) this.getBean(VIDEO_CODEC_FACTORY);
			app.setVideoCodecFactory(videoFactory);
		}
		
		/*
		IMapping scopeMapping;
		if (this.containsBean(SCOPE_MAPPING))
			scopeMapping = (IMapping) this.getBean(SCOPE_MAPPING);
		else {
			scopeMapping = new DefaultMapping();
			this.getBeanFactory().registerSingleton(SCOPE_MAPPING, scopeMapping);
		}
		app.setScopeMapping(scopeMapping);
		*/
	}
	
	public ServiceInvoker getServiceInvoker(){
		return (ServiceInvoker) getBean(ServiceInvoker.SERVICE_NAME);
	}
}