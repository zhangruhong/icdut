package com.vtars.cdut.aao.Action;

public class MyServiceImpl implements MyService {

	@Override
	public boolean valid(String username, String pass) {
		if (username.equals("creazyit") && pass.equals("leegang")) {
			return true;
		} else {
			return false;
		}
	}

}
