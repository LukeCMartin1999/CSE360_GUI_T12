import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;

public class displayList {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			displayList window = new displayList();
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
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(500, 500);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblNewLabel.setBounds(194, 52, 111, 30);
		lblNewLabel.setText("Display List ");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(48, 112, 403, 214);
		
		Button buttonExit = new Button(shell, SWT.NONE);
		buttonExit.setText("Exit");
		buttonExit.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonExit.setBounds(188, 402, 124, 34);
		
		Button buttonDisplaySettings = new Button(shell, SWT.NONE);
		buttonDisplaySettings.setText("Display Settings");
		buttonDisplaySettings.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonDisplaySettings.setBounds(188, 358, 124, 34);

	}

}
