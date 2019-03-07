package io.skywalker;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import io.skywalker.gmsdk.StrategyMode;

/**
 * 
 * @author Harry Zhou
 *
 */
public class GMSDKDemo {

	static {
		try {
			String envTmpDir = "";
			String tempLibPath = "";
			try {
				if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
					envTmpDir = System.getProperty("java.io.tmpdir");
					tempLibPath = envTmpDir + File.separator + "io" + File.separator + "skywalker" + File.separator
							+ "demo" + File.separator + "gmsdk" + File.separator + "lib";
					copyURLToFileForTmp(tempLibPath, GMSDKDemo.class.getResource("/assembly/gmsdk.dll"));
					copyURLToFileForTmp(tempLibPath, GMSDKDemo.class.getResource("/assembly/gmsdk_wrap.dll"));
				}
			} catch (Exception e) {
				System.out.println("复制库文件到临时目录失败 " + e);
			}
			if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
				System.load(tempLibPath + File.separator + "gmsdk.dll");
				System.load(tempLibPath + File.separator + "gmsdk_wrap.dll");
			}
		} catch (Exception e) {
			System.out.println("加载库失败!" + e);
		}
	}

	/**
	 * 复制URL到临时文件夹
	 * 
	 * @param targetDir
	 * @param sourceURL
	 * @throws IOException
	 */
	public static void copyURLToFileForTmp(String targetDir, URL sourceURL) throws IOException {
		File orginFile = new File(sourceURL.getFile());
		File targetFile = new File(targetDir + File.separator + orginFile.getName());
		if (targetFile.exists()) {
			targetFile.delete();
		}
		FileUtils.copyURLToFile(sourceURL, targetFile);

		targetFile.deleteOnExit();
	}

	public static void main(String[] args) {
		MyStrategy ms = new MyStrategy();
		ms.set_strategy_id("5bdaf1c6-4073-11e9-a2b7-001c42178e52"); // 掘金策略ID
		ms.set_token("a7sd0as6sdf70dsfasdf56asd56f8asd5fdsdasd"); // 掘金账号TOKEN
		System.out.println("StrategyMode.MODE_BACKTEST: " + StrategyMode.MODE_BACKTEST.swigValue());
		ms.set_mode(StrategyMode.MODE_BACKTEST.swigValue());
		ms.set_backtest_config("2016-07-11 17:20:00", "2017-07-11 17:30:00", 1000000, 1, 0, 0, 0, 1);
		ms.run();
		System.out.println("Done");
	}

}
