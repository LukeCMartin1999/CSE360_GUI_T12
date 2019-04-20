import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class displayListSetting {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void displayListSetting() {
		try {
			displayListSetting window = new displayListSetting();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
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
	protected void createContents() {
		shell = new Shell();
		shell.setSize(500, 500);
		shell.setText("SWT Application");
		
		Button buttonPriority = new Button(shell, SWT.NONE);
		buttonPriority.setText("Display by Priority");
		buttonPriority.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonPriority.setBounds(172, 169, 156, 34);
		
		Button buttonAlphabetically = new Button(shell, SWT.NONE);
		buttonAlphabetically.setText("Display Alphabetically");
		buttonAlphabetically.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonAlphabetically.setBounds(172, 101, 156, 34);
		
		Button buttonDueDate = new Button(shell, SWT.NONE);
		buttonDueDate.setText("Display by Due Date");
		buttonDueDate.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonDueDate.setBounds(172, 240, 156, 34);
		
		Button buttonExit = new Button(shell, SWT.NONE);
		buttonExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				mainMenu mainMenuPanel = new mainMenu();
				mainMenuPanel.open();
			}
		});
		buttonExit.setText("Exit");
		buttonExit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonExit.setBounds(177, 384, 146, 34);
		
		Button buttonStatus = new Button(shell, SWT.NONE);
		buttonStatus.setText("Display by Status");
		buttonStatus.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonStatus.setBounds(172, 312, 156, 34);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblNewLabel.setBounds(156, 41, 187, 46);
		lblNewLabel.setText("Display List Settings ");

	}

}
