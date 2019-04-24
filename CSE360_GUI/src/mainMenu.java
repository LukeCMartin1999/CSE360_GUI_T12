import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class mainMenu {

	protected Shell shlTodoList;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mainMenu window = new mainMenu();
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
		shlTodoList.open();
		shlTodoList.layout();
		while (!shlTodoList.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTodoList = new Shell();
		shlTodoList.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlTodoList.setSize(500, 500);
		shlTodoList.setText("To-Do List");
		
		Label lblNewLabel = new Label(shlTodoList, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblNewLabel.setBounds(175, 23, 150, 28);
		lblNewLabel.setText("Welcome to Your");
		
		Label lblToDoList = new Label(shlTodoList, SWT.NONE);
		lblToDoList.setFont(SWTResourceManager.getFont("Arial", 18, SWT.BOLD));
		lblToDoList.setBounds(203, 48, 94, 21);
		lblToDoList.setText("To Do List ");
		
		Button buttonRemoveItem = new Button(shlTodoList, SWT.NONE);
		buttonRemoveItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTodoList.dispose();
				removeItem removeItemPanel = new removeItem();
				removeItemPanel.open();
			}
		});
		buttonRemoveItem.setFont(SWTResourceManager.getFont("Arial", 13, SWT.NORMAL));
		buttonRemoveItem.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonRemoveItem.setBounds(165, 188, 170, 40);
		buttonRemoveItem.setText("Remove Item from List ");
		
		Button buttonAddItem = new Button(shlTodoList, SWT.NONE);
		buttonAddItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTodoList.dispose();
				addItem addItemPanel = new addItem();
				addItemPanel.open();
			}
		});
		buttonAddItem.setText("Add Item to List ");
		buttonAddItem.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonAddItem.setFont(SWTResourceManager.getFont("Arial", 13, SWT.NORMAL));
		buttonAddItem.setBounds(165, 96, 169, 40);
		
		Button buttonDisplayList = new Button(shlTodoList, SWT.NONE);
		buttonDisplayList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTodoList.dispose();
				displayList displayListPanel = new displayList();
				displayListPanel.open();
			} 
		});
		buttonDisplayList.setText("Display List");
		buttonDisplayList.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonDisplayList.setFont(SWTResourceManager.getFont("Arial", 13, SWT.NORMAL));
		buttonDisplayList.setBounds(165, 142, 170, 40);
		
		Button buttonChangeItem = new Button(shlTodoList, SWT.NONE);
		buttonChangeItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTodoList.dispose();
				changeItem changeItemPanel = new changeItem();
				changeItemPanel.open();
			}
		});
		buttonChangeItem.setText("Change Item on List");
		buttonChangeItem.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonChangeItem.setFont(SWTResourceManager.getFont("Arial", 13, SWT.NORMAL));
		buttonChangeItem.setBounds(165, 234, 170, 40);
		
		Button buttonRestoreList = new Button(shlTodoList, SWT.NONE);
		buttonRestoreList.setText("Restore Previous List");
		buttonRestoreList.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonRestoreList.setFont(SWTResourceManager.getFont("Arial", 13, SWT.NORMAL));
		buttonRestoreList.setBounds(165, 280, 170, 40);
		
		Button buttonSaveCurrentList = new Button(shlTodoList, SWT.NONE);
		buttonSaveCurrentList.setText("Save Current List");
		buttonSaveCurrentList.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		buttonSaveCurrentList.setFont(SWTResourceManager.getFont("Arial", 13, SWT.NORMAL));
		buttonSaveCurrentList.setBounds(165, 326, 170, 40);
		
		Button buttonQuitApp = new Button(shlTodoList, SWT.NONE);
		buttonQuitApp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		buttonQuitApp.setText("Quit Application");
		buttonQuitApp.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		buttonQuitApp.setFont(SWTResourceManager.getFont("Arial", 13, SWT.BOLD));
		buttonQuitApp.setBounds(165, 372, 170, 40);

	}
}
