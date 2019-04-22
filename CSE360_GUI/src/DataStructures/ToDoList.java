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


