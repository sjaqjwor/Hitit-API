package me.hitit.api.controllers.forms;

import org.apache.log4j.Logger;

public class AddFriendForm {
	private static final Logger LOG = Logger.getLogger(AddFriendForm.class.getSimpleName());

	private long[] fuidx;
	private long tuidx;

	public AddFriendForm() {
	}

	public AddFriendForm(long[] fuidx, long tuidx) {
		this.fuidx = fuidx;
		this.tuidx = tuidx;
	}

	public long[] getFuidx() {
		return fuidx;
	}
	public void setFuidx(long[] fuidx) {
		this.fuidx = fuidx;
	}
	public long getTuidx() {
		return tuidx;
	}
	public void setTuidx(long tuidx) {
		this.tuidx = tuidx;
	}


}
