import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import DataStructures.Entry;
import DataStructures.ToDoList;
import DataStructures.Progress.Status;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;




public class changeItem {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */

	public void open(ToDoList List) {
		Display display = Display.getDefault();
		createContents(display, List);
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
	protected void createContents(Display display, ToDoList List) {
		shell = new Shell();
		shell.setSize(600, 500);
		shell.setText("SWT Application");
		shell.setText("Change Item");
		
		 Monitor primary = display.getPrimaryMonitor();
		 Rectangle bounds = primary.getBounds();
		 Rectangle rect = shell.getBounds();

		
		int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    System.out.println(x);
	    System.out.println(y);
	    shell.setLocation(x, y);
		
		
	    System.out.println(x);
	    System.out.println(y);
	    shell.setLocation(x, y);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblNewLabel.setBounds(243, 38, 113, 28);
		lblNewLabel.setText("Change Item");
		
		List changeList = new List(shell, SWT.BORDER);
		changeList.setBounds(58, 107, 483, 246);
		
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
		builder = builder + ("   Desc: ") + entry.getDescription();
		changeList.add(builder);
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
		changeList.add(builder);

		}
		
		Button Exit = new Button(shell, SWT.NONE);
		Exit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				mainMenu mainMenuPanel = new mainMenu();
				mainMenuPanel.open(List);
			}
		});
		Exit.setText("Exit");
		Exit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		Exit.setBounds(238, 412, 124, 34);
		
		Button buttonChangeItem = new Button(shell, SWT.NONE);
		buttonChangeItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int selected = changeList.getSelectionIndex();
				if(selected == -1)
				{
					Label labelSelect = new Label(shell, SWT.NONE);
					labelSelect.setAlignment(SWT.CENTER);
					labelSelect.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					labelSelect.setBounds(214, 72, 171, 14);
					labelSelect.setText("Please Select an Item First");
					return;
					
				}
				shell.dispose();
				
				System.out.println(selected);
				itemChangesSettings itemChangesSettingsPanel = new itemChangesSettings();
				
				itemChangesSettingsPanel.open(List, selected);
			}
		});
		buttonChangeItem.setText("Change Item");
		buttonChangeItem.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonChangeItem.setBounds(238, 368, 124, 34);
		

	}

}
