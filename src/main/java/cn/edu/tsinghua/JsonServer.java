package cn.edu.tsinghua;

import java.io.IOException;
import java.net.URL;

import org.eclipse.jetty.xml.XmlConfiguration;
import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class JsonServer {
	private static final Logger LOG = LoggerFactory.getLogger(JsonServer.class);

    public static void main(String[] args) throws InterruptedException {
        URL url = JsonServer.class.getResource("/jetty-config.xml");
        XmlConfiguration jettyConfig = null;
        try {
            jettyConfig = new XmlConfiguration(url);
        } catch (SAXException e) {
            LOG.error(e.toString());
            
            return;
        } catch (IOException e) {
        	LOG.error(e.toString());
        	
        	return;
        }

        Server server = null;
        try{
            server = (Server)jettyConfig.configure();
        }catch (Exception e) {
        	LOG.error(e.toString());

            return;
        }

        try {
            server.start();
        } catch (Exception e) {
        	LOG.error(e.toString());
        	
        	return;
        }

        LOG.info("Server started ...");
        
        try{
            server.join();
        }catch(InterruptedException ie) {
            throw ie;
        }
    }
}
