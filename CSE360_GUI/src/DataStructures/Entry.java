package DataStructures;

public class Entry {
	private String description;
	private int priority;
	private DueDate dueDate;
	private Progress progress;
	
	public Entry() {
		description = "No description";
		priority = 0;
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

	public DueDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(DueDate dueDate) {
		this.dueDate = dueDate;
	}

	public Progress getProgress() {
		return progress;
	}

	public void setProgress(Progress progress) {
		this.progress = progress;
	}
}
