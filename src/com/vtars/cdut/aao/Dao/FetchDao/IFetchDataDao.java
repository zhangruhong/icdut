package com.vtars.cdut.aao.Dao.FetchDao;

import java.util.Map;
import java.util.TreeSet;

import com.vtars.cdut.aao.Model.GradeBean;

public interface IFetchDataDao {

	/**
	 * ��ȡ�ɼ�ҳ�� ��������
	 * 
	 * @param aaosessionid
	 *            ����ϵͳ��sessionid �㶮��
	 * @param kvinfo
	 *            ��̬�İ�����֤
	 * @return 
	 */
	public TreeSet<GradeBean> fetchGrades(String aaosessionid, Map<String, String> kvinfo);

	/**
	 * ��ϵͳ����������ҳ ���¼�޹�
	 * 
	 * @param newsurl
	 * @return
	 */
	public String fetchNewsContent(String newsurl);

	/**
	 * ��ϵͳ�������б�ҳ
	 * 
	 * @param AAO_URL
	 * @return
	 */
	public Map<String, String> fetchNewsUrls(String AAO_URL);

}
