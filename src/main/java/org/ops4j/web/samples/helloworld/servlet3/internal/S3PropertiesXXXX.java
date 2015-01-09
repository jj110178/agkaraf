package org.ops4j.web.samples.helloworld.servlet3.internal;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;

/**
 * This class is an extension of the java <code>Properties</code> class which handles
 * reading properties files from Amazon S3. In order to read from S3, the following java
 * system properties should be set:
 * <pre>
 *     aws.accessKeyId
 *     aws.secretKey
 *     aws.s3.bucket
 * </pre>
 *
 * @author Shane Koster
 */
public class S3PropertiesXXXX extends Properties {
    //private static final Logger logger = LoggerFactory.getLogger(S3Properties.class);
    //private static final String BUCKET_NAME = System.getProperty("aws.s3.bucket");
    private static final String BUCKET_NAME = "ad-gateway-dev";//System.getProperty("aws.s3.bucket");

    
    private String filename;

    public S3PropertiesXXXX() {
        super();
    }

    public S3PropertiesXXXX(Properties defaults) {
        super(defaults);
    }

    /**
     * Read a property list from an Amazon S3 bucket. The credentials and the bucket name should be specified as
     * Java system properties. After the file has been successfully loaded from S3, the instance of this class
     * will be registered with the S3PropertyRegistry.
     *
     * @param s3filename - the name of the file as it appears in the S3 bucket.
     * @throws IOException           - if an error occurred when reading from the input stream.
     * @throws AmazonClientException - if an error occurred when communicating with Amazon S3.
     * @see com.S3PropertiesXXXX.adgateway.util.S3Properties
     */
    public void load(String s3filename) throws IOException, AmazonClientException {
        //logger.info("Loading file from S3: {}", s3filename);
        AmazonS3Client s3Client = new AmazonS3Client();
        System.out.println("TESTTTTTT1");
        try (S3Object object = s3Client.getObject(BUCKET_NAME, s3filename)) {
            if (object != null) {
            	System.out.println("TESTTTTTT2");
                // create a temporary Properties object so we don't have to block for reads while downloading from s3
                Properties newProps = new Properties();
                newProps.load(object.getObjectContent());
                this.putAll(newProps);
                this.filename = s3filename;
                System.out.println("TESTTTTTT3");
                //S3PropertyRegistry.getInstance().register(this);
            }
        } catch (AmazonClientException ace) {
            //logger.error("Exception caught when loading file: {}", s3filename);
            throw ace;
        }
    }

    /**
     * Forces this class to reread its properties file from the Amazon S3 store. The filename that is read is assumed
     * to be the same one that was used to initially load this object. The behavior of this method will be to overwrite
     * any properties with the same name but not to remove any properties that have been deleted from the file.
     *
     * @throws IOException           - if an error occurred when reading from the input stream.
     * @throws AmazonClientException - if an error occurred when communicating with Amazon S3.
     */
    public void reload() throws IOException, AmazonClientException {
        //logger.info("Reloading file from S3: {}", this.filename);
        if (this.filename != null) {
            AmazonS3Client s3Client = new AmazonS3Client();
            try (S3Object object = s3Client.getObject(BUCKET_NAME, this.filename)) {
                if (object != null) {
                    // create a temporary Properties object so we don't have to block for reads while downloading from s3
                    Properties newProps = new Properties();
                    newProps.load(object.getObjectContent());
                    this.clear();
                    this.putAll(newProps);
                }
            } catch (AmazonClientException ace) {
                //logger.error("Exception caught when reloading file: {}", filename);
                throw ace;
            }
        }
    }

    public String getFilename() {
        return this.filename;
    }
    
    public String getString(String key, String def)
	{
		return getProperty(key, def);
	}
	
	public Integer getInt(String key, String def)
	{
		String s = getProperty(key, def);
		
		if (s == null)
			return null;
		
		return Integer.valueOf(s);
	}
	
	public Long getLong(String key, String def)
	{
		String s = getProperty(key, def);
		
		if (s == null)
			return null;
		
		return Long.valueOf(s);
	}
	
	public Float getFloat(String key, String def)
	{
		String s = getProperty(key, def);
		
		if (s == null)
			return null;
		
		return Float.valueOf(s);
	}
	
	
	public boolean getBoolean(String key, String def)
	{
		return Boolean.parseBoolean(getProperty(key, def));
	}
	
	public Date getDateFromSecondsEpoch(String key, String def)
	{
		Long l = getLong(key, def);
		
		if (l == null)
			return null;
		
		return new Date(l * 1000);
	}
	
	public Date getDateFromMillisecondsEpoch(String key, String def)
	{
		Long l = getLong(key, def);
		
		if (l == null)
			return null;
		
		return new Date(l);
	}
	
	public String[] getCommaSeparatedStrings(String key, String def)
	{
		String s = getString(key, def);
		
		if (s == null)
			return null;
		
		if (s.length() == 0)
			return new String[0];
		
		return s.split("\\s*,\\s*");
	}
	
	public Double getDouble(String key, String def)
	{
		String s = getProperty(key, def);
		
		if (s == null)
			return null;
		
		return Double.valueOf(s);
	}
}
