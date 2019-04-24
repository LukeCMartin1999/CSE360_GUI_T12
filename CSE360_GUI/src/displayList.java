import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import DataStructures.Entry;
import DataStructures.Progress.Status;
import DataStructures.ToDoList;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;





public class displayList {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */

	/**
	 * Open the window.
	 */
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
		shell.setText("Display List");
		
		
		 Monitor primary = display.getPrimaryMonitor();
		 Rectangle bounds = primary.getBounds();
		 Rectangle rect = shell.getBounds();

		
		int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
		
		
		 Monitor primary = display.getPrimaryMonitor();
		 Rectangle bounds = primary.getBounds();
		 Rectangle rect = shell.getBounds();

		
		int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblNewLabel.setBounds(244, 52, 111, 30);
		lblNewLabel.setText("Display List ");
		


		

		
		
		Button buttonExit = new Button(shell, SWT.NONE);
		buttonExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				mainMenu mainMenuPanel = new mainMenu();
				mainMenuPanel.open(List);
			}
		});
		buttonExit.setText("Exit");
		buttonExit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonExit.setBounds(238, 402, 124, 34);
		
		Button buttonDisplaySettings = new Button(shell, SWT.NONE);
		buttonDisplaySettings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				displayListSetting displayListSettingPanel = new displayListSetting();
				displayListSettingPanel.open(List);
				
			}
		});
		buttonDisplaySettings.setText("Display Settings");
		buttonDisplaySettings.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonDisplaySettings.setBounds(238, 358, 124, 34);
		
		List displayList = new List(shell, SWT.BORDER);
		displayList.setBounds(38, 114, 523, 238);
		String builder = new String();
		for(Entry entry : List.getEntries())
		{
		builder = "";
		builder = ("Priority: ") + entry.getPriority();
		builder = builder + ("   Due: ") + (entry.getDueDate().getMonth()) + ("/")
			+ (entry.getDueDate().getDay())+ ("/")
			+ (entry.getDueDate().getYear());
		// TODO
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
		displayList.add(builder);
		}
		
		
		

	}
}
