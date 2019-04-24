import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import DataStructures.Entry;
import DataStructures.ToDoList;
import DataStructures.Progress.Status;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;

public class removeItem {

	protected Shell shell;

	public void open(ToDoList List) {
		Display display = Display.getDefault();
		createContents(List, display);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents(ToDoList List, Display display) {
		shell = new Shell();
		shell.setSize(600, 500);
		shell.setText("SWT Application");
		
		 Monitor primary = display.getPrimaryMonitor();
		 Rectangle bounds = primary.getBounds();
		 Rectangle rect = shell.getBounds();

		
		int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
		
		Label lblRemoveItem = new Label(shell, SWT.NONE);
		lblRemoveItem.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblRemoveItem.setBounds(241, 44, 117, 21);
		lblRemoveItem.setText("Remove Item");
		
		List removeList = new List(shell, SWT.BORDER);
		removeList.setBounds(35, 110, 530, 220);
		String builder = new String();
		
		for(Entry entry : List.getEntries())
		{
		builder = "";
		builder = ("Priority: ") + entry.getPriority();
		builder = builder + ("   Due: ") + (entry.getDueDate().getMonth()) + ("/")
			+ (entry.getDueDate().getDay())+ ("/")
			+ (entry.getDueDate().getYear());
		// TODO
		builder = builder + ("   Progress: not implemented");

		builder = builder + ("   ");
		if(entry.getProgress().getStatus() == Status.NOT_STARTED) 
		{
			builder = builder + "Status: Not Started";	
		}
		else if(entry.getProgress().getStatus() == Status.IN_PROGRESS)
		{
			builder = builder + "Status: In Progress";
		}
		else if (entry.getProgress().getStatus() == Status.FINISHED)
		{
			builder = builder + "Status: Finished";
		}
		builder = builder + ("   Desc: ") + entry.getDescription();
		removeList.add(builder);
		}
		
		Button buttonExit = new Button(shell, SWT.NONE);
		buttonExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				mainMenu mainMenuPanel = new mainMenu();
				mainMenuPanel.open(List);
			}
		});
		buttonExit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonExit.setBounds(241, 396, 118, 34);
		buttonExit.setText("Exit");
		
		Button buttonRemove = new Button(shell, SWT.NONE);
		buttonRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selected = removeList.getSelectionIndex();
				removeList.remove(selected);
				
				if(selected == -1)
				{
					Label labelSelect = new Label(shell, SWT.NONE);
					labelSelect.setAlignment(SWT.CENTER);
					labelSelect.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelSelect.setBounds(214, 72, 171, 14);
					labelSelect.setText("Please Select an Item First");
					return;
					
				}
				List.deleteEntry(selected);
				shell.dispose();
				removeItem removeItemPanel = new removeItem();
				removeItemPanel.open(List);
				
			}
		});
		buttonRemove.setText("Remove");
		buttonRemove.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonRemove.setBounds(241, 352, 118, 34);

	}
}
