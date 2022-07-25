package test;

import utils.JacobUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class JacobTest {

	public static void main(String[] args) {
		Map<String, String> textMap = getTextMap();
		for (String key : textMap.keySet()) {
			System.out.println(key);
			String text = key + "����" + textMap.get(key);
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
		textMap.put("ӽ�졤�����", "�졤�졤�죬������졤�衣��ë��������ˮ�����ơ������岨��");
		textMap.put("�������Ϻ�Ȼ", "���ߡ������������������š�����ҹ�������ꡤ�������䡤֪�����١�");
		textMap.put("ӽ������֪��", "����ױ�ɡ�һ�����ߣ����������¡���˿���С���֪��ϸҶ��˭���ó������¡����硤�ơ�������");
		textMap.put("��˼����ά", "�춹�������Ϲ���������������֦��Ը�����ࡤ��ߢ��������˼��");
		textMap.put("��ҹ˼�����", "��ǰ�����¡��⣬���ǡ����ϡ�˪����ͷ���������£���ͷ��˼�����硣");
		textMap.put("�緢�׵۳ǡ����", "���ǰ׵۲��Ƽ䣬ǧ�ｭ��һ�ջ�������Գ���䲻ס�������ѹ�����ɽ��");
		textMap.put("��®ɽ�ٲ������", "������¯�����̣�ң���ٲ���ǰ��������ֱ����ǧ�ߣ�������������졣");
		textMap.put("�����ס����", "��׳��۽����У����Ű���̤�������һ�̶ˮ��ǧ�ߣ��������������顣");
		textMap.put("ҹ��ɽ�¡����", "Σ¥�߰ٳߣ��ֿ�ժ�ǳ������Ҹ�����־������ˡ�");
		textMap.put("���ָ衤���", "�׷���ǧ�ɣ�Ե���Ƹ�������֪������δ�����˪��");
		textMap.put("�ƺ�¥���Ϻ�Ȼ֮���ꡤ���", "�������ǻƺ�¥���̻����������ݡ��·�ԶӰ�̿վ���Ψ�������������");
		textMap.put("������ɽ�����", "�����жϳ���������ˮ�������˻ء�������ɽ��Գ����·�һƬ�ձ�����");
//		textMap.put("", "");
//		textMap.put("", "");
//		textMap.put("", "");
//		textMap.put("", "");
		return textMap;
	}
}
