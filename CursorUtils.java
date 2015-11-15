package com.drz.cursorUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.database.Cursor;

public class CursorUtils {

	public CursorUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 转换Cursor为list集合
	 * 
	 * @param cursor
	 * @return
	 */
	public static List<Map<String, Object>> converCursorToList(Cursor cursor) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		String[] columnNames = cursor.getColumnNames();
		// 解析Cursor中的数据
		while (cursor.moveToNext()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (String name : columnNames) {
				String value = cursor.getString(cursor.getColumnIndex(name));
				map.put(name, value);
			}
			result.add(map);
		}
		return result;
	}
}
