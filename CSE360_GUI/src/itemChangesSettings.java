import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;


import DataStructures.ToDoList;

import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;


import org.eclipse.swt.widgets.Text;


public class itemChangesSettings {

	protected Shell shell;
	private Text descriptionChange;
	private Text priorityChange;
	private Text dueDateChange;

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
		shell.setText("SWT Application");
		
		Monitor primary = display.getPrimaryMonitor();
		 Rectangle bounds = primary.getBounds();
		 Rectangle rect = shell.getBounds();

		
		int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
		
		Label lblEditItem = new Label(shell, SWT.NONE);
		lblEditItem.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblEditItem.setBounds(258, 10, 84, 27);
		lblEditItem.setText("Edit Item");
		
		Label lblChangeDescription = new Label(shell, SWT.NONE);
		lblChangeDescription.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblChangeDescription.setBounds(231, 69, 137, 27);
		lblChangeDescription.setText("Change Description");
		
		descriptionChange = new Text(shell, SWT.BORDER);
		descriptionChange.setBounds(231, 102, 137, 19);
		
		Label lblChangePriority = new Label(shell, SWT.NONE);
		lblChangePriority.setText("Change Priority");
		lblChangePriority.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblChangePriority.setBounds(244, 136, 111, 27);
		
		priorityChange = new Text(shell, SWT.BORDER);
		priorityChange.setBounds(231, 169, 137, 19);
		
		Label lblChangeDueDate = new Label(shell, SWT.NONE);
		lblChangeDueDate.setText("Change Due Date");
		lblChangeDueDate.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblChangeDueDate.setBounds(235, 209, 129, 27);
		
		dueDateChange = new Text(shell, SWT.BORDER);
		dueDateChange.setBounds(232, 242, 136, 19);
		
		Button btnNotStarted = new Button(shell, SWT.RADIO);
		btnNotStarted.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		btnNotStarted.setBounds(244, 300, 103, 21);
		btnNotStarted.setText("Not Started");
		
		Label lblChangeStatus = new Label(shell, SWT.NONE);
		lblChangeStatus.setText("Change Status");
		lblChangeStatus.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblChangeStatus.setBounds(235, 267, 129, 27);
		
		Button btnFinished = new Button(shell, SWT.RADIO);
		btnFinished.setText("Finished");
		btnFinished.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		btnFinished.setBounds(244, 354, 103, 21);
		
		Button btnInProgress = new Button(shell, SWT.RADIO);
		btnInProgress.setText("In Progress");
		btnInProgress.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		btnInProgress.setBounds(244, 327, 103, 21);
		
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
		buttonExit.setBounds(238, 434, 124, 34);
		
		Button buttonChange = new Button(shell, SWT.NONE);
		buttonChange.setText("Change");
		buttonChange.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonChange.setBounds(238, 394, 124, 34);

	}
}
