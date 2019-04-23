package DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToDoList {
	public enum Sort { DESC, PRIORITY, DUE_DATE, STATUS };
	
	private List<Entry> entries;
	private Sort sort;
	
	public ToDoList() {
		entries = new ArrayList<Entry>();
		sort = Sort.PRIORITY;
	}

	public List<Entry> getEntries() {
		return entries;
	}
	
	public void addEntry(Entry newEntry) {
		entries.add(newEntry);
		sortEntries();
	}

	public Sort getSort() {
		return sort;
	}
	
	public void setSort(Sort sort) {
		this.sort = sort;
		sortEntries();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		for (Entry entry : entries) {
			builder.append("Priority ").append(entry.getPriority()).append(": \n");
			builder.append("\tDesc: ").append(entry.getDescription()).append("\n");
			builder.append("\tDue: ").append(entry.getDueDate().getYear()).append("-")
				.append(entry.getDueDate().getMonth()).append("-")
				.append(entry.getDueDate().getDay()).append("\n");
			// TODO
			builder.append("\tProgress: not implemented\n");
		}
		
		return builder.toString();
	}
	
	private void sortEntries() {
		Collections.sort(entries, new EntryComparator());
	}
	
	private class EntryComparator implements Comparator<Entry> {
		@Override
		public int compare(Entry first, Entry second) {
			switch (sort) {
			case DESC:
				return first.getDescription().compareTo(second.getDescription());
			case PRIORITY:
				return first.getPriority() - second.getPriority();
			case DUE_DATE:
				return first.getDueDate().compareTo(second.getDueDate());
			case STATUS:
				if (first.getProgress().getStatus() == second.getProgress().getStatus()) return 0;
				
				if (first.getProgress().getStatus() == Progress.Status.NOT_STARTED) return -1;
				if (second.getProgress().getStatus() == Progress.Status.FINISHED) return -1;
				
				return 1;
			default:
				return first.getPriority() - second.getPriority();
			
			}
		}
	}
}


