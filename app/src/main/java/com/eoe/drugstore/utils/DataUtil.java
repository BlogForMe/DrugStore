package com.eoe.drugstore.utils;

import java.io.IOException;
import java.io.InputStream;


import android.content.Context;

/**
 * 
 * @author jon
 * 
 */
public class DataUtil {
	/**
	 * 读取本地json数据
	 * 
	 * @param context
	 * @param fileName
	 * @return
	 */
	public static String readLocalJson(Context context, String fileName) {
		String data = null;
		try {
			InputStream in = context.getResources().getAssets().open(fileName);
			int length = in.available();
			byte[] buffer = new byte[length];
			in.read(buffer);
			in.close();
//			data = EncodingUtils.getString(buffer, "UTF-8");
//			buffer.toString()
			data = new String(buffer,"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;

	}
}
