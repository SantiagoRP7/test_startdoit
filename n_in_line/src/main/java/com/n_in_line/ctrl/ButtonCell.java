package com.n_in_line.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Button;

public class ButtonCell extends Button {
	public int i;
	public int j;
	public void doAfterCompose(Component comp) throws Exception {
		//super.doAfterCompose(comp);
	}
	public void updatePos(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
