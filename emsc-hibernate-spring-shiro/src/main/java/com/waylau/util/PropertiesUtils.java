package com.waylau.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesUtils {

	private static final String UTF_8 = "UTF-8";

	private static final Map<String, Properties> PROPS = new HashMap<String, Properties>();

	private PropertiesUtils() {
	}

	/**
	 * @功能: 根据name获取properties文件中的value (注意: 虽然静态方法中调用了静态变量, 使得该方法非线程安全, 但该方法只是读取配置文件, 不做修改, 所以不会有问题)
	 * @作者: yangc
	 * @创建日期: 2013-11-21 下午07:01:48
	 * @param filePath properties文件路径(classpath中的相对路径)
	 * @param name
	 * @return
	 */
	public static String getProperty(String filePath, String name) {
		if (StringUtils.isBlank(filePath) || StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("The parameters must not be null");
		}
		try {
			Properties prop = PROPS.get(filePath);
			if (prop == null) {
				prop = new Properties();
				prop.load(PropertiesUtils.class.getResourceAsStream(filePath));
				PROPS.put(filePath, prop);
			}
			return prop.getProperty(name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @功能: 根据name获取properties文件中的value, 如果为空返回默认值 (注意: 虽然静态方法中调用了静态变量, 使得该方法非线程安全, 但该方法只是读取配置文件, 不做修改, 所以不会有问题)
	 * @作者: yangc
	 * @创建日期: 2013-11-21 下午07:01:48
	 * @param filePath properties文件路径(classpath中的相对路径)
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static String getProperty(String filePath, String name, String defaultValue) {
		if (StringUtils.isBlank(filePath) || StringUtils.isBlank(name) || StringUtils.isBlank(defaultValue)) {
			throw new IllegalArgumentException("The parameters must not be null");
		}
		try {
			Properties prop = PROPS.get(filePath);
			if (prop == null) {
				prop = new Properties();
				prop.load(PropertiesUtils.class.getResourceAsStream(filePath));
				PROPS.put(filePath, prop);
			}
			String value = prop.getProperty(name);
			return StringUtils.isBlank(value) ? defaultValue : value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return defaultValue;
	}

	/**
	 * @功能: properties文件中的name,value (已过期, 会打乱properties文件中顺序, 虽然静态方法中调用了静态变量, 使得该方法非线程安全, 但是已加锁, 效率低, 不推荐使用)
	 * @作者: yangc
	 * @创建日期: 2013-11-21 下午07:02:38
	 * @param filePath properties文件路径(classpath中的相对路径)
	 * @param name
	 * @param value
	 */
	@Deprecated
	public static void setProperty(String filePath, String name, String value) {
		if (StringUtils.isBlank(filePath) || StringUtils.isBlank(name) || StringUtils.isBlank(value)) {
			throw new IllegalArgumentException("The parameters must not be null");
		}
		BufferedWriter bw = null;
		try {
			synchronized (PROPS) {
				Properties prop = PROPS.get(filePath);
				if (prop == null) {
					prop = new Properties();
					prop.load(PropertiesUtils.class.getResourceAsStream(filePath));
					PROPS.put(filePath, prop);
				}
				prop.put(name, value);
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PropertiesUtils.class.getResource(filePath).getFile()), UTF_8));
				prop.store(bw, "保存properties配置文件");
			}
			bw.flush();
			bw.close();
			bw = null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(PropertiesUtils.getProperty("/jdbc.properties", "oracle.driver"));
		PropertiesUtils.setProperty("/email.properties", "name", "yangc");
	}

}
