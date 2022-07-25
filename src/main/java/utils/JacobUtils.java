package utils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobUtils {

	/**
	 * 文字转语音
	 * @param text 待朗读文字
	 * @param volume 音量大小(0-100)
	 * @param rate 语音朗读速度(-10 到 +10)
	 * @param speak 是否朗读
	 * @param wavPath 语音保存路径
	 */
	public static void textToSpeech(String text, Integer volume, Integer rate, boolean speak, String wavPath) {
		try {
			// 音量 0-100
			if (volume == null || volume <= 0 || volume > 100) {
				volume = 100;
			}
			// 语音朗读速度 -10 到 +10
			if (rate == null) {
				rate = -2;
			} else if (rate < -5) {
				rate = -5;
			} else if (rate > 5) {
				rate = 5;
			}
			if (speak) {
				Dispatch voice = new ActiveXComponent("Sapi.SpVoice").getObject();
				// 设置音量 0到100
				Dispatch.put(voice, "Volume", new Variant(volume));
				// 设置朗读速度
				Dispatch.put(voice, "Rate", new Variant(rate));
				// 开始朗读
				Dispatch.call(voice, "Speak", new Variant(text));
				voice.safeRelease();
			}
			if (wavPath != null && wavPath.length() > 0) {
				// 下面是构建文件流把生成语音文件
				Dispatch voice = new ActiveXComponent("Sapi.SpVoice").getObject();
				Dispatch fileStream = new ActiveXComponent("Sapi.SpFileStream").getObject();
				Dispatch audioFormat = new ActiveXComponent("Sapi.SpAudioFormat").getObject();
				// 设置音频流格式
				Dispatch.put(audioFormat, "Type", new Variant(22));
				// 设置文件输出流格式
				Dispatch.putRef(fileStream, "Format", audioFormat);
				// 调用输出 文件流打开方法，创建一个.wav文件
				Dispatch.call(fileStream, "Open", new Variant(wavPath), new Variant(3), new Variant(true));
				// 设置声音对象的音频输出流为输出文件对象
				Dispatch.putRef(voice, "AudioOutputStream", fileStream);
				// 设置音量 0到100
				Dispatch.put(voice, "Volume", new Variant(volume));
				// 设置朗读速度
				Dispatch.put(voice, "Rate", new Variant(rate));
				// 开始朗读
				Dispatch.call(voice, "Speak", new Variant(text));
				// 关闭输出文件
				Dispatch.call(fileStream, "Close");
				Dispatch.putRef(voice, "AudioOutputStream", null);
				audioFormat.safeRelease();
				fileStream.safeRelease();
				voice.safeRelease();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文字转语音
	 * @param text
	 */
	public static void textToSpeech(String text) {
		try {
			ActiveXComponent ax = new ActiveXComponent("Sapi.SpVoice");
			// 运行时输出语音内容
			Dispatch spVoice = ax.getObject();
			// 音量 0-100
			ax.setProperty("Volume", new Variant(100));
			// 语音朗读速度 -10 到 +10
			ax.setProperty("Rate", new Variant(-5));
			// 执行朗读
			Dispatch.call(spVoice, "Speak", new Variant(text));
			// 下面是构建文件流把生成语音文件
			ax = new ActiveXComponent("Sapi.SpFileStream");
			Dispatch spFileStream = ax.getObject();
			ax = new ActiveXComponent("Sapi.SpAudioFormat");
			Dispatch spAudioFormat = ax.getObject();
			// 设置音频流格式
			Dispatch.put(spAudioFormat, "Type", new Variant(22));
			// 设置文件输出流格式
			Dispatch.putRef(spFileStream, "Format", spAudioFormat);
			// 调用输出 文件流打开方法，创建一个.wav文件
			Dispatch.call(spFileStream, "Open", new Variant("e:/text.wav"), new Variant(3), new Variant(true));
			// 设置声音对象的音频输出流为输出文件对象
			Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
			// 设置音量 0到100
			Dispatch.put(spVoice, "Volume", new Variant(100));
			// 设置朗读速度
			Dispatch.put(spVoice, "Rate", new Variant(-2));
			// 开始朗读
			Dispatch.call(spVoice, "Speak", new Variant(text));
			// 关闭输出文件
			Dispatch.call(spFileStream, "Close");
			Dispatch.putRef(spVoice, "AudioOutputStream", null);
			spAudioFormat.safeRelease();
			spFileStream.safeRelease();
			spVoice.safeRelease();
			ax.safeRelease();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
