import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import DataStructures.ToDoList;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;

public class displayListSetting {

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
		shell.setText("SWT Application");
		
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();

		
		int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    System.out.println(x);
	    System.out.println(y);
	    shell.setLocation(x, y);
		
		Button buttonPriority = new Button(shell, SWT.NONE);
		buttonPriority.setText("Display by Priority");
		buttonPriority.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonPriority.setBounds(222, 169, 156, 34);
		
		Button buttonAlphabetically = new Button(shell, SWT.NONE);
		buttonAlphabetically.setText("Display Alphabetically");
		buttonAlphabetically.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonAlphabetically.setBounds(222, 101, 156, 34);
		
		Button buttonDueDate = new Button(shell, SWT.NONE);
		buttonDueDate.setText("Display by Due Date");
		buttonDueDate.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonDueDate.setBounds(222, 240, 156, 34);
		
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
		buttonExit.setBounds(227, 384, 146, 34);
		
		Button buttonStatus = new Button(shell, SWT.NONE);
		buttonStatus.setText("Display by Status");
		buttonStatus.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonStatus.setBounds(222, 312, 156, 34);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblNewLabel.setBounds(206, 41, 187, 46);
		lblNewLabel.setText("Display List Settings ");

	}

}
