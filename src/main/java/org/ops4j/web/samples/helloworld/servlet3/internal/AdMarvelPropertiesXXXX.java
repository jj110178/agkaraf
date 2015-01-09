package org.ops4j.web.samples.helloworld.servlet3.internal;

import java.io.IOException;

import com.amazonaws.AmazonClientException;


public class AdMarvelPropertiesXXXX extends S3PropertiesXXXX {
    //private static final Logger logger = LoggerFactory.getLogger(AdMarvelProperties.class);
    private static final long serialVersionUID = 1L;
    private static final AdMarvelPropertiesXXXX instance;
    private static final String PROPS_FILENAME = "admarvel-web.properties";
    private static boolean reloadable = false;


    static {
        instance = new AdMarvelPropertiesXXXX();
        try {
        	System.out.println("TESTTTTTT0 ADMarvel");
            instance.load(PROPS_FILENAME);
            reloadable = true;
        } catch (Exception e) {
            try {
                // try to load the file from the classpath instead
                instance.load(AdMarvelPropertiesXXXX.class.getResourceAsStream("/" + PROPS_FILENAME));
            } catch (Exception e1) {
                //logger.error("Exception caught when loading properties: {}", PROPS_FILENAME, e);
            }
        }
    }

    public static AdMarvelPropertiesXXXX getInstance() {
        return instance;
    }

    

    @Override
    public void load(String s3filename) throws IOException, AmazonClientException {
        super.load(s3filename);
    }

    @Override
    public void reload() throws IOException, AmazonClientException {
        if (reloadable) {
            super.reload();
        } else {
            throw new UnsupportedOperationException("Properties were not initially loaded from S3; cannot reload");
        }
    }

    private AdMarvelPropertiesXXXX() {
    }

    

    public Long getAdGatewayConnectionTTL() {
        return getLong("adGateway.connectionTTL", "5000");
    }

    public Integer getAdGatewayMaxConnections() {
        return getInt("adGateway.maxConnections", "1024");
    }

    public Integer getAdGatewayMaxConnectionsPerRoute() {
        return getInt("adGateway.maxConnectionsPerRoute", "1024");
    }

    /**
     * Note that admarvel specifically closes connections so this is essentially
     * a worthless setting as of this writing.
     */
    public Long getAdGatewayKeepAlive() {
        return getLong("adGateway.keepAlive", "1000");
    }

    public Integer getAdGatewayConnectTimeout() {
        return getInt("adGateway.connectionTimeout", "300");
    }

    public Integer getAdGatewaySocketTimeout() {
        return getInt("adGateway.socketTimeout", "800");
    }

    public String[] getNorthAmericanIPV4SlashEightPrefixes() {
        return getCommaSeparatedStrings("northAmericanIPV4SlashEightPrefixes", "");
    }

    public String[] getAdGatewayToAdMarvelAdSpaces() {
        return getCommaSeparatedStrings("sprintAdGatewayToAdmarvelAdSpaces", "");
    }

    public String getAdGatewayToAdmarvelAdSpacePartnerId(String space) {
        return getString("admarvel." + space + ".partnerId", null);
    }

    public String getAdGatewayToAdmarvelAdSpaceSiteId(String space) {
        return getString("admarvel." + space + ".siteId", null);
    }

    public boolean getAdGatewayToAdmarvelAdSpaceSimple(String space) {
        return getBoolean("admarvel." + space + ".simple", null);
    }

    public boolean getAdGatewayToAdmarvelAdSpaceWellFormed(String space) {
        return getBoolean("admarvel." + space + ".wellFormed", null);
    }

    public String getAdGatewayToAdmarvelAdSpaceWarn(String space) {
        return getString("admarvel." + space + ".warn", null);
    }

    public String getAdGatewayToAdmarvelAdSpaceError(String space) {
        return getString("admarvel." + space + ".error", null);
    }
    
    public Integer getAdGatewayToAdmarvelMaxPostRead() {
        return getInt("admarvel", "1048576");
    }

    public String getAdGatewayToAdMarvelDefaultAdSpace() {
        return getString("sprintAdGatewayToAdmarvelDefaultAdSpace", "default");
    }

    public String getAdMarvelServerURL() {
        return getString("admarvel.url", null);
    }

    public String getDspName() {
        return getString("name", null);
    }

    public String getClientSla() {
        return getString("sla", null);
    }

}
