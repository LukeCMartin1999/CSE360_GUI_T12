package DataStructures;

import java.io.Serializable;

public class Progress implements Serializable {
	public enum Status { NOT_STARTED, IN_PROGRESS, FINISHED };
	
	private Status status;
	private Date date;
	private static final long serialVersionUID = 4L;
	
	public Progress() {
		setStatus(Status.NOT_STARTED);
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
		if (status != Status.NOT_STARTED) {
			setDate(new Date());
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
