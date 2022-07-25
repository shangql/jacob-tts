package test;

import utils.JacobUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class JacobTest {

	public static void main(String[] args) {
		Map<String, String> textMap = getTextMap();
		for (String key : textMap.keySet()) {
			System.out.println(key);
			String text = key + "——" + textMap.get(key);
			String wavPath = "d:/tts/" + key + ".mp3"; // "e:/text.wav";
			textToSpeech(text, wavPath);
		}
	}

	public static void textToSpeech(String text, String wavPath) {
		Integer volume = 100;
		Integer rate = -5;
		boolean speak = true; // true false
		JacobUtils.textToSpeech(text, volume, rate, speak, wavPath);
	}

	public static Map<String, String> getTextMap() {
		Map<String, String> textMap = new LinkedHashMap<String, String>();
		textMap.put("咏鹅·骆宾王", "鹅·鹅·鹅，曲项·向天·歌。白毛·浮·绿水，红掌·拨·清波。");
		textMap.put("春晓·孟浩然", "春眠·不·觉晓，处处·闻·啼鸟。夜来·风雨·声，花落·知·多少。");
		textMap.put("咏柳·贺知章", "碧玉·妆成·一树·高，万条·垂下·绿丝·绦。不知·细叶·谁·裁出，二月·春风·似·剪刀。");
		textMap.put("相思·王维", "红豆·生·南国，春来·发·几枝。愿君·多·采撷，此物·最·相思。");
		textMap.put("静夜思·李白", "窗前·明月·光，疑是·地上·霜。举头·望·明月，低头·思·故乡。");
		textMap.put("早发白帝城·李白", "朝辞白帝彩云间，千里江陵一日还。两岸猿声啼不住，轻舟已过万重山。");
		textMap.put("望庐山瀑布·李白", "日照香炉生紫烟，遥看瀑布挂前川。飞流直下三千尺，疑是银河落九天。");
		textMap.put("赠汪伦·李白", "李白乘舟将欲行，忽闻岸上踏歌声。桃花潭水深千尺，不及汪伦送我情。");
		textMap.put("夜宿山寺·李白", "危楼高百尺，手可摘星辰。不敢高声语，恐惊天上人。");
		textMap.put("秋浦歌·李白", "白发三千丈，缘愁似个长。不知明镜里，何处得秋霜。");
		textMap.put("黄鹤楼送孟浩然之广陵·李白", "故人西辞黄鹤楼，烟花三月下扬州。孤帆远影碧空尽，唯见长江天际流。");
		textMap.put("望天门山·李白", "天门中断楚江开，碧水东流至此回。两岸青山相对出，孤帆一片日边来。");
//		textMap.put("", "");
//		textMap.put("", "");
//		textMap.put("", "");
//		textMap.put("", "");
		return textMap;
	}
}
