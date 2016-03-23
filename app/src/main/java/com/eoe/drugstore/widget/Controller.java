package com.eoe.drugstore.widget;

/**
 * 主控制器类
 * 
 * 
 */
public class Controller {


//	private static Controller _controller = null;
//
//	private ArrayList<Context> cxtList; // Activity队列，仅供程序退出时使用。
//
//	private BaseActivity activity = null;
//
//	private Map<String, Object> curContent;
//
//	private Controller() {
//		cxtList = new ArrayList<Context>();
//	}
//
//	public static Controller getInstance() {
//		if (_controller == null) {
//			_controller = new Controller();
//		}
//		return _controller;
//	}
//
//	public void setCurrentActivity(Context cxt) {
//		if (cxt instanceof BaseActivity)
//			this.activity = (BaseActivity) cxt;
//		cxtList.add(activity);
//	}
//
//	public BaseActivity getCurrentActivity() {
//		return this.activity;
//	}
//
//	public ArrayList<Context> getCxtList() {
//		return cxtList;
//	}
//
//	public void launcherBack() {
//		Intent i = new Intent(Intent.ACTION_MAIN);
//		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		i.addCategory(Intent.CATEGORY_HOME);
//		activity.startActivity(i);
//	}
//
//	public void appLogout() {
//
//
//		SharedPreferences preferences = activity.getSharedPreferences(
//				Constants.SharedPreferencesName, activity.MODE_WORLD_WRITEABLE);
//		preferences.edit().putString("", "").commit();
//
//		for (Context c : cxtList) {
//			if (c != null) {
//				((Activity) c).finish();
//			}
//		}
//	}
//
//	public void appExit() {
//		for (Context c : cxtList) {
//			if (c != null) {
//				((Activity) c).finish();
//			}
//		}
//	}
//
//	public void AppHide() {
//		Intent i = new Intent(Intent.ACTION_MAIN);
//		i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//		i.addCategory(Intent.CATEGORY_HOME);
//		activity.startActivity(i);
//	}
//
//	public Map<String, Object> getCurContent() {
//		return curContent;
//	}
//
//	public void setCurContent(Map<String, Object> curContent) {
//		this.curContent = curContent;
//	}

}
