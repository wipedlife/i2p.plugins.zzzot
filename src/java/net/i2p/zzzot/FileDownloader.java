import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import net.i2p.I2PAppContext;
import net.i2p.client.streaming.I2PSocketEepGet;
import net.i2p.client.streaming.I2PSocketManager;
import net.i2p.crypto.SHA1;
import net.i2p.data.DataHelper;
import net.i2p.util.EepGet;
import net.i2p.util.I2PAppThread;
import net.i2p.util.Log;
import net.i2p.util.SecureFile;





public class FileDownloader{
    private static final int RETRIES = 5;
    private final String useragent = "zzzoter 666";
    private final Log _log;
    
    public boolean get(String url, String nameFile) {
		Properties opts = new Properties();
        	opts.setProperty("i2cp.dontPublishLeaseSet", "true");
        	opts.setProperty("inbound.quantity", "3");
        	opts.setProperty("outbound.quantity", "3");
        	opts.setProperty("inbound.length", "3");
        	opts.setProperty("outbound.length", "3");
        	opts.setProperty("inbound.nickname", "I2PSocketEepGet");
        	I2PSocketManager mgr = I2PSocketManagerFactory.createManager(opts);
        	if (mgr == null) {
            		System.err.println("Error creating the socket manager");
            		return false;
        	}
        	I2PSocketEepGet get = new I2PSocketEepGet(I2PAppContext.getGlobalContext(),
                                                  mgr, RETRIES, nameFile, url);
        	get.addStatusListener(get.new CLIStatusListener(1024, 40));
        	get.fetch(inactivityTimeout, -1, inactivityTimeout);
		get.addHeader("User-Agent", useragent);
        	mgr.destroySocketManager();
		if (_eepGet.fetch()) {
            		if (_log.shouldLog(Log.DEBUG))
               			 _log.debug("Fetch successful [" + _url + "]: size=" + out.length());
            		return true;
			} else {
            			if (_log.shouldLog(Log.DEBUG))
                			_log.debug("Fetch failed [" + _url + ']');
            			out.delete();
            			return false;
        		}
    }
};

