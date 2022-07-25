package utils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobUtils {

	/**
	 * ����ת����
	 * @param text ���ʶ�����
	 * @param volume ������С(0-100)
	 * @param rate �����ʶ��ٶ�(-10 �� +10)
	 * @param speak �Ƿ��ʶ�
	 * @param wavPath ��������·��
	 */
	public static void textToSpeech(String text, Integer volume, Integer rate, boolean speak, String wavPath) {
		try {
			// ���� 0-100
			if (volume == null || volume <= 0 || volume > 100) {
				volume = 100;
			}
			// �����ʶ��ٶ� -10 �� +10
			if (rate == null) {
				rate = -2;
			} else if (rate < -5) {
				rate = -5;
			} else if (rate > 5) {
				rate = 5;
			}
			if (speak) {
				Dispatch voice = new ActiveXComponent("Sapi.SpVoice").getObject();
				// �������� 0��100
				Dispatch.put(voice, "Volume", new Variant(volume));
				// �����ʶ��ٶ�
				Dispatch.put(voice, "Rate", new Variant(rate));
				// ��ʼ�ʶ�
				Dispatch.call(voice, "Speak", new Variant(text));
				voice.safeRelease();
			}
			if (wavPath != null && wavPath.length() > 0) {
				// �����ǹ����ļ��������������ļ�
				Dispatch voice = new ActiveXComponent("Sapi.SpVoice").getObject();
				Dispatch fileStream = new ActiveXComponent("Sapi.SpFileStream").getObject();
				Dispatch audioFormat = new ActiveXComponent("Sapi.SpAudioFormat").getObject();
				// ������Ƶ����ʽ
				Dispatch.put(audioFormat, "Type", new Variant(22));
				// �����ļ��������ʽ
				Dispatch.putRef(fileStream, "Format", audioFormat);
				// ������� �ļ����򿪷���������һ��.wav�ļ�
				Dispatch.call(fileStream, "Open", new Variant(wavPath), new Variant(3), new Variant(true));
				// ���������������Ƶ�����Ϊ����ļ�����
				Dispatch.putRef(voice, "AudioOutputStream", fileStream);
				// �������� 0��100
				Dispatch.put(voice, "Volume", new Variant(volume));
				// �����ʶ��ٶ�
				Dispatch.put(voice, "Rate", new Variant(rate));
				// ��ʼ�ʶ�
				Dispatch.call(voice, "Speak", new Variant(text));
				// �ر�����ļ�
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
	 * ����ת����
	 * @param text
	 */
	public static void textToSpeech(String text) {
		try {
			ActiveXComponent ax = new ActiveXComponent("Sapi.SpVoice");
			// ����ʱ�����������
			Dispatch spVoice = ax.getObject();
			// ���� 0-100
			ax.setProperty("Volume", new Variant(100));
			// �����ʶ��ٶ� -10 �� +10
			ax.setProperty("Rate", new Variant(-5));
			// ִ���ʶ�
			Dispatch.call(spVoice, "Speak", new Variant(text));
			// �����ǹ����ļ��������������ļ�
			ax = new ActiveXComponent("Sapi.SpFileStream");
			Dispatch spFileStream = ax.getObject();
			ax = new ActiveXComponent("Sapi.SpAudioFormat");
			Dispatch spAudioFormat = ax.getObject();
			// ������Ƶ����ʽ
			Dispatch.put(spAudioFormat, "Type", new Variant(22));
			// �����ļ��������ʽ
			Dispatch.putRef(spFileStream, "Format", spAudioFormat);
			// ������� �ļ����򿪷���������һ��.wav�ļ�
			Dispatch.call(spFileStream, "Open", new Variant("e:/text.wav"), new Variant(3), new Variant(true));
			// ���������������Ƶ�����Ϊ����ļ�����
			Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
			// �������� 0��100
			Dispatch.put(spVoice, "Volume", new Variant(100));
			// �����ʶ��ٶ�
			Dispatch.put(spVoice, "Rate", new Variant(-2));
			// ��ʼ�ʶ�
			Dispatch.call(spVoice, "Speak", new Variant(text));
			// �ر�����ļ�
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
