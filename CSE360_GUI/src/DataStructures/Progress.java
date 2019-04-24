package DataStructures;

public class Progress {
	public enum Status { NOT_STARTED, IN_PROGRESS, FINISHED };
	
	private Status status;
	private Date date;
	
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