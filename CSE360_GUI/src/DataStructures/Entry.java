package DataStructures;

public class Entry {
	private String description;
	private int priority;
	private Date dueDate;
	private Progress progress;
	
	public Entry() {
		description = "No description";
		priority = 0;
		dueDate = new Date();
		progress = new Progress();
	}
	
	public Entry(String description, int priority) {
		this.description = description;
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Progress getProgress() {
		return progress;
	}

	public void setProgress(Progress progress) {
		this.progress = progress;
	}
}
